package skillbuilder.core;

public class passwordValidator {
	/**
	 How will you validate a password in Java? below are the condition so we using this need to validate a given input password.		

	  At least one numeric digit
	  At Least one Small/Lowercase Letter
	  At Least one Capital/Uppercase Letter
	  Must not have space
	  Must not have slash (/)
	  At least 6 characters
	 
	 */
	public static boolean isValidPassword(String password) {
		// Check if the password is at least 6 characters long
		if (password.length() < 6) {
			return false;
		}

		// Check if the password contains at least one numeric digit
		if (!password.matches(".*\\d.*")) {
			return false;
		}

		// Check if the password contains at least one lowercase letter
		if (!password.matches(".*[a-z].*")) {
			return false;
		}

		// Check if the password contains at least one uppercase letter
		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		// Check if the password does not contain any spaces
		if (password.contains(" ")) {
			return false;
		}

		// Check if the password does not contain any slashes
		if (password.contains("/")) {
			return false;
		}

		// If all conditions are met, the password is valid
		return true;
	}

	public static void main(String[] args) {
		// Test cases
		String[] testPasswords = { "Password1", "Passw rd1", "Pass/word1", "passworD1", "PASSword1", "Pass1",
				"Password", "Pass1w", "Password123" };

		for (String password : testPasswords) {
			System.out.println("Password: " + password + " is valid: " + isValidPassword(password));
		}
	}
}
