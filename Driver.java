import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
        try { //testing exceptions
            Maze test = new Maze("data1.data");
        } catch (FileNotFoundException e) {
            System.out.println("Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong1.dat");
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("Wrong Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong2.dat");
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("Wrong Exception Caught!\n");
        }

        try {
            Maze test = new Maze("data1.dat");
            System.out.println(test);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong Exception Caught!\n");
        }
    }
}
