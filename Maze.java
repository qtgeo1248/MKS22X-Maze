import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {
        File f = new File("Maze1.txt");
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
    }
}
