import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random Password Generator");
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Enter the complexity (1 for numbers, 2 for letters, 3 for both): ");
        int complexity = scanner.nextInt();

        String password = generateRandomPassword(passwordLength, complexity);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generateRandomPassword(int length, int complexity) {
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String characters = "";

        if (complexity == 1) {
            characters = numbers;
        } else if (complexity == 2) {
            characters = lowerChars + upperChars;
        } else if (complexity == 3) {
            characters = lowerChars + upperChars + numbers;
        } else {
            System.out.println("Invalid complexity choice.");
            System.exit(1);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
