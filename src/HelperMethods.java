import java.util.Scanner;

public class HelperMethods {
    static Scanner scanner = new Scanner(System.in);

    //method to simulate clearing out the console
    public void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //method to print separator with length n
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    //method to stop program until user enters anything
    public void anythingToContinue() {
        while (true) {
            System.out.println("\nEnter anything to continue...");
            String userInput = scanner.next();
            if (userInput.length() == 1) {
                break;
            }
            else {
                System.out.println("Enter only one character!");
            }
        }
    }
}