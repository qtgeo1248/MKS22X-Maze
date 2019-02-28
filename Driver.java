import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
        try { //testing exceptions
            Maze test = new Maze("1. data1.data");
        } catch (FileNotFoundException e) {
            System.out.println("1. Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong1.dat");
        } catch (IllegalStateException e) {
            System.out.println("2. Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("2. Wrong Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong2.dat");
        } catch (IllegalStateException e) {
            System.out.println("3. Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("3. Wrong Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong3.dat");
        } catch (IllegalStateException e) {
            System.out.println("4. Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("4. Wrong Exception Caught!\n");
        }
        try {
            Maze test = new Maze("wrong4.dat");
        } catch (IllegalStateException e) {
            System.out.println("5. Exception Caught!\n");
        } catch (FileNotFoundException e) {
            System.out.println("5. Wrong Exception Caught!\n");
        }

        try {
            Maze test = new Maze("data1.dat");
            System.out.println(test.solve());
            System.out.println(test + "\n");


        } catch (FileNotFoundException e) {
            System.out.println("6. Wrong Exception Caught!\n");
        }
    }
}
