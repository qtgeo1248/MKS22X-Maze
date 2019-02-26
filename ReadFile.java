import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File f = new File("Maze1.txt");
            Scanner in = new Scanner(f);
            int numRows = 0;

            while (in.hasNextLine()) { //this prints out each line
                String line = in.nextLine();
                System.out.println(line);
                numRows++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("NO FILE");
        }
    }
}
