import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
        try {
            Maze test = new Maze("data1.data");
        } catch (FileNotFoundException e) {
            System.out.println("Exception Caught!\n");
        }
    }
}
