import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner in = new Scanner(f);
        int numRows = 0;
        int numCols = 0;

        while (in.hasNextLine()) { //this prints out each line
            String line = in.nextLine();
            numRows++; //keeps track of num of rows for array of chars
            if (numRows == 1) { //counts the number of columns
                for (int i = 0; i < line.length(); i++) {
                    numCols++;
                }
            }
        }

        in = new Scanner(f); //resets the scanner
        maze = new char[numRows][numCols];
        int currentRow = 0;
        boolean hasStart = false;
        boolean hasGoal = false;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char currentCell = line.charAt(i);
                if (currentCell == 'S') {
                    if (hasStart == false) {
                        hasStart = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                if (currentCell == 'E') {
                    if (hasGoal == false) {
                        hasGoal = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                maze[currentRow][i] = currentCell;
            }
            currentRow++;
        }
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
    public void setAnimate(boolean b) {
        animate = b;
    }
    public void clearTerminal() {
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
}
