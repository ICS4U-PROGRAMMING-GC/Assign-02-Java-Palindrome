import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Checks whether words in a file are palindromes.
 *
 * @author Carel
 * @version 2026-11-15
 */
public final class Palindrome {

    /**
     * Private constructor to prevent instantiation.
     */
    private Palindrome() {
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the word to check
     * @return true if the word is a palindrome
     */
    public static boolean isPalindrome(final String word) {
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        return word.equalsIgnoreCase(reversed);
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        ArrayList<String> results = new ArrayList<String>();

        try {
            File file = new File("words.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next();

                if (isPalindrome(word)) {
                    results.add(word + " - Palindrome");
                } else {
                    results.add(word + " - Not a palindrome");
                }
            }

            input.close();

            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

