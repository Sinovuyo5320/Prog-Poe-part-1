import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserNameValid() {
        Login login = new Login();

        assertTrue(login.checkUserName("kyl_1"), "Username should be valid");
    }

    @Test
    public void testCheckUserNameInvalidMissingUnderscore() {
        Login login = new Login();

        assertFalse(login.checkUserName("kyle"), "Username missing an underscore should be invalid.");
    }

    @Test
    public void testCheckUserNameInvalidTooLong() {
        Login login = new Login();

        assertFalse(login.checkUserName("kyle_1"), "Username longer than 5 characters should be invalid.");
    }

    @Test
    public void testCheckCellNumberValid() {
        Login login = new Login();

        assertTrue(login.checkCellNumber("+27838968976"), "Cell number starting with +27 and containing 12 characters should be valid.");
    }

    @Test
    public void testCheckCellNumberInvalidPrefix() {
        Login login = new Login();

        assertFalse(login.checkCellNumber("0838968976"), "Cell number not starting with +27 should be invalid.");
    }

    @Test
    public void testCheckCellNumberInvalidLength() {
        Login login = new Login();

        assertFalse(login.checkCellNumber("+27838"), "Cell number with incorrect length should be invalid.");
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login();

        assertTrue(login.checkPasswordComplexity("Ch@6k1n9"), "Password meeting all complexity rules should be valid.");
    }

    @Test
    public void testCheckPasswordComplexityTooShort() {
        Login login = new Login();

        assertFalse(login.checkPasswordComplexity("Pa@1"), "Password shorter than 8 characters should be invalid.");
    }

    @Test
    public void testCheckPasswordComplexityMissingRequirements() {
        Login login = new Login();

        assertFalse(login.checkPasswordComplexity("password"), "Password missing capital letters, numbers, and special characters should be invalid.");
    }

    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        login.LoginDetails("kyl_1", "Ch@6k1n9", "John", "Doe", "+27838968976");
        String result = login.registerUser();
        assertTrue(result.contains("successfully captured"), "All valid details should successfully register.");
    }

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.LoginDetails("kyl_1", "Ch@6k1n9", "John", "Doe", "+27838968976");
        assertTrue(login.LoginUser("kyl_1", "Ch@6k1n9"), "Matching username and password should return true.");
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.LoginDetails("us_r", "Pass@123", "John", "Doe", "+27123456789");
        assertFalse(login.LoginUser("us_r", "WrongPass1"), "Incorrect password should return false.");
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.LoginDetails("Ch@6kin9", "Ch@6k1n9", "John", "Doe", "+27838968976");
        String status = login.returnLoginStatus(true);
        assertTrue(status.contains("Welcome John, Doe"), "Successful login status should display the user's name.");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        String status = login.returnLoginStatus(false);
        assertTrue(status.contains("incorrect"), "Failed login status should display an error message.");
    }
}