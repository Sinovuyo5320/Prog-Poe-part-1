public class Login {

    //variables to store user info
    private String storedUsername;
    private String storedPassword; 
    private String FirstName;
    private String LastName;
    private String Cellnumber;

    // Method to save user details after registration
    public void LoginDetails(String Username, String Password, String Firstname, String Lastname, String Cellnumber) {
        this.storedUsername = Username;
        this.storedPassword = Password;
        this.FirstName = Firstname;
        this.LastName = Lastname;
        this.Cellnumber = Cellnumber;
    }


    // Checks if username has an underscore and is 5 characters or less
    public boolean checkUserName(String username) {
        boolean hasUnderscore = username.contains("_");
        boolean correctLength = username.length() <= 5;

        if (hasUnderscore && correctLength) {
            return true;
        } else {
            return false;
        }
    }

    // Checks cell number
    public boolean checkCellNumber(String cellnumber) {
        boolean startsWithCode = cellnumber.startsWith("+27");
        boolean correctLength = cellnumber.length() == 12;

        if (startsWithCode && correctLength) {
            return true;
        } else {
            return false;
        }
    }

    // Checks password
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasUpper && hasDigit && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    // Validates all registration fields
    public String registerUser() {
        if (checkUserName(storedUsername) == false) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters.";
        }

        if (checkPasswordComplexity(storedPassword) == false) {
            return "Password is not correctly formatted; please ensure that your password contains at least eight characters, a capital letter, and a number.";
        }

        if (checkCellNumber(Cellnumber) == false) {
            return "Phone number is not correctly formatted; please ensure it starts with +27 and contains 12 characters in total.";
        }

        return "Username was successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    //login credentials
    public boolean LoginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername.equals(this.storedUsername) && enteredPassword.equals(this.storedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Returns a welcome or error message based on login status
    public String returnLoginStatus(boolean LoggedIn) {
        if (LoggedIn == true) {
            return "Welcome " + this.FirstName + ", " + this.LastName + "! It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
