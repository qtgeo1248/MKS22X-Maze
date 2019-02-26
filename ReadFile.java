import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File f = new File("Maze1.txt");
            Scanner in = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("NO FILE");
        }
    }
}
