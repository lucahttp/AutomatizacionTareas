import java.util.InputMismatchException; // import the exception catching class
import java.util.Scanner; // import the scanner class

public class Terminal {

    // main method which will run your program
    public static void main(String args[]) {

        // create your new scanner
        // Note: since scanner is opened to "System.in" closing it will close "System.in". 
        // Do not close scanner until you no longer want to use it at all.
        Scanner scanner = new Scanner(System.in);

        // PROMPT THE USER
        // Note: when using scanner it is recommended to prompt the user with "System.out.print" or "System.out.println"
        System.out.println("Please enter a number");

        // use "try" to catch invalid inputs
        try {

            // get integer with "nextInt()"
            int n = scanner.nextInt();


            System.out.println("Please enter a decimal"); // PROMPT
            // get decimal with "nextFloat()"
            float f = scanner.nextFloat();


            System.out.println("Please enter a word"); // PROMPT
            // get single word with "next()"
            String s = scanner.next();

            // ---- Note: Scanner.nextInt() does not consume a nextLine character /n 
            // ---- In order to read a new line we first need to clear the current nextLine by reading it:
            scanner.nextLine();
            // ----
            System.out.println("Please enter a line"); // PROMPT
            // get line with "nextLine()"
            String l = scanner.nextLine();


            // do something with the input
            System.out.println("The number entered was: " + n);
            System.out.println("The decimal entered was: " + f);
            System.out.println("The word entered was: " + s);
            System.out.println("The line entered was: " + l);


        }
        catch (InputMismatchException e) {
            System.out.println("\tInvalid input entered. Please enter the specified input");
        }

        scanner.close(); // close the scanner so it doesn't leak
    }
}