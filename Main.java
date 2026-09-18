import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userAccount = new Login();

        System.out.println("=== REGISTRATION PROCESS ===");

        System.out.println("Enter Firstname:");
        String Firstname = scanner.nextLine();

        System.out.println("Enter Lastname:");
        String Lastname = scanner.nextLine();

        System.out.println("Enter Username:");
        String Username = scanner.nextLine();

        System.out.println("Enter Cellnumber (starts with +27):");
        String Cellnumber = scanner.nextLine();

        System.out.println("Enter Password:");
        String Password = scanner.nextLine();

        // Send data to the object being the loginDetails construction
        userAccount.LoginDetails(Username, Password, Firstname, Lastname, Cellnumber);

        // Check registration results
        String registrationMessage = userAccount.registerUser();
        System.out.println("\n" + registrationMessage);

        // If registration succeeded, move to login
        if (registrationMessage.contains("successfully captured")) {
            System.out.println("\n=== LOGIN PROCESS ===");

            System.out.println("Enter Username:");
            String loginUser = scanner.nextLine();

            System.out.println("Enter Password:");
            String loginPass = scanner.nextLine();

            boolean loginSuccess = userAccount.LoginUser(loginUser, loginPass);
            String finalMessage = userAccount.returnLoginStatus(loginSuccess);

            System.out.println(finalMessage);
        }

        scanner.close();
    }
}