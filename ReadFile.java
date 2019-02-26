import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File f = new File("Maze1.txt");
            Scanner in = new Scanner(f);
            int numRows = 0;
            int numCols = 0;

            while (in.hasNextLine()) { //this prints out each line
                String line = in.nextLine();
                System.out.println(line);
                numRows++; //keeps track of num of rows for array of chars
                if (numRows == 1) { //counts the number of columns
                    for (int i = 0; i < line.length(); i++) {
                        numCols++;
                    }
                }
            }

            System.out.println("" + numRows + ", " + numCols);
        } catch (FileNotFoundException e) {
            System.out.println("NO FILE");
        }
    }
}
