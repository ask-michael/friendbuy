import java.util.HashMap;
import java.util.Scanner;

public class CommandHandlers {

    private static String name;
    private static int value;

    public static void main(String[] args){

        Table userTable = new Table("usertable",new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        while(!userInput.equals("END")) {

            switch(userInput){
                case "BEGIN":
                    accessDatabase(scanner, userInput, userTable);
                    //Implement recursive transaction class for nested transactions
                default :
                    accessDatabase(scanner, userInput, userTable);
            }
            userInput = scanner.next();

        }
    }

    private static void accessDatabase(Scanner scanner, String userInput, Table userTable){
            switch (userInput) {
                case "SET":
                    name = scanner.next();
                    value = scanner.nextInt();
                    userTable.createRecord(name, value);
                    break;
                case "GET":
                    name = scanner.next();
                    userTable.getRecord(name);
                    break;
                case "UNSET":
                    name = scanner.next();
                    userTable.deleteValue(name);
                    break;
                case "NUMEQUALTO":
                    value = scanner.nextInt();
                    userTable.getNumNamesWithValue(value);
                    break;
                default:
                    System.out.println("Invalid Input action");
            }
        }

}
