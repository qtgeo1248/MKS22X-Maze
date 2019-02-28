import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;
    private static int[] OPTIONS = {1, 0, 0, 1, -1, 0, 0, -1};;

    public Maze(String filename) throws FileNotFoundException {
        animate = false;
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

        if (!hasStart || !hasGoal) { //does the case of no E's or no S's
            throw new IllegalStateException();
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

    public String toString() {
        String toReturn = "";
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                toReturn += maze[i][j];
            }
            toReturn += "\n";
        }
        return toReturn.substring(0, toReturn.length() - 1);
    }

    public int solve() {
        int Si = 0;
        int Sj = 0;
        for (int i = 1; i < maze.length - 1; i++) { //did this because I know outer edges are #'s'
            for (int j = 1; j < maze[i].length - 1; j++) {
                if (maze[i][j] == 'S') {
                    Si = i; //Note j is xcor and i is ycor
                    Sj = j;
                    maze[i][j] = ' ';
                }
            }
        }
        return solve(Si, Sj); //temp
    }
    public int solve(int row, int col) { //MAKE PIRVATE LATER
        if (animate) {
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        if (maze[row][col] == 'S') {
            return 0;
        } else if (maze[row][col] == ' ') {
            maze[row][col] = '@';
            int count = solve(row + 1, col) + solve(row, col + 1) + solve(row - 1, col) + solve(row, col - 1);
            if (count == -4) { //this is when you're at a dead end
                maze[row][col] = '.';
                return -1;
            } else {
                return 0;
            }
        }

        return -1; //temp
    }
}
