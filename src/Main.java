import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBLogic db = new DBLogic();
        HelperMethods help = new HelperMethods();
        Scanner scanner = new Scanner(System.in);

        boolean notConnected = true;

        do {
            try {
                System.out.println("Enter database path:");
                db.setDB(scanner.nextLine());

                System.out.println("Enter username:");
                db.setUSER(scanner.nextLine());

                System.out.println("Enter password:");
                db.setPASSWORD(scanner.nextLine());
                db.connect();
                notConnected = false;
            } catch (SQLException e) {
                help.clearConsole();
                help.printSeparator(20);
                System.out.println("Error connecting!");
                help.printSeparator(20);
            }
        } while (notConnected);

        int choice;

        do{
            db.printConnectionInfo();
            System.out.println();
            System.out.println("0. QUIT");
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. CHANGE DB");
            System.out.println("Enter action:");
            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Bye bye!");
                break;
            }
            else if (choice == 1) {
                System.out.println("Enter name:");
                String name = scanner.next();

                System.out.println("Enter email:");
                String email = scanner.next();

                help.clearConsole();
                help.printSeparator(20);
                db.insert(name, email);
                help.printSeparator(20);
                help.anythingToContinue();
                help.clearConsole();
            }
            else if (choice == 2) {
                help.clearConsole();
                help.printSeparator(20);
                db.read();
                help.anythingToContinue();
                help.clearConsole();
            }
            else if (choice == 3) {
                int id;
                String column;
                String newInfo;

                System.out.println("Enter id to update: ");
                id = scanner.nextInt();

                System.out.println("Enter column to update: ");
                column = scanner.next();

                System.out.println("Enter new info: ");
                newInfo = scanner.next();

                help.clearConsole();
                db.update(id, column, newInfo);
                help.anythingToContinue();
                help.clearConsole();
            }
            else if (choice == 4) {
                int id;

                System.out.println("Enter id you want to delete: ");
                id = scanner.nextInt();

                help.clearConsole();
                db.delete(id);
                help.anythingToContinue();
                help.clearConsole();
            }
            else if (choice == 5) {
                boolean notReConnected;

                do {
                    try {
                        System.out.println("Enter new database path:");
                        db.setDB(scanner.next());

                        System.out.println("Enter new username:");
                        db.setUSER(scanner.next());

                        System.out.println("Enter new password:");
                        db.setPASSWORD(scanner.next());
                        db.connect();
                        notReConnected = false;
                    } catch (SQLException e) {
                        help.clearConsole();
                        help.printSeparator(20);
                        System.out.println("Error connecting!");
                        help.printSeparator(20);
                        notReConnected = true;
                    }
                } while (notReConnected);
            }
            else {
                help.clearConsole();
                help.printSeparator(20);
                System.out.println("I didn't understand you. Please, try again!");
                help.printSeparator(20);
                help.anythingToContinue();
                help.clearConsole();
            }
        } while(true);
    }
}
