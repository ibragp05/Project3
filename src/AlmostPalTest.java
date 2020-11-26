import java.io.*;
import java.util.*;

/**
 * A class that checks if a word is almost a palindrome
 * and will be a palindrome if one letter is changed
 *
 * @author Polina Ibragimova
 * @version 25.11.2020
 */
public class AlmostPalTest {
    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            File inputFile = new File("dictionary.txt");
            File outputFile = new File("almostPalOutput.txt");
            in = new Scanner(inputFile);
            out = new PrintWriter(outputFile);
            String word;
            // While the file hasn't ended
            while(in.hasNext()){
                word = in.next();
                // Checking if a word is almost a palindrome
                if(isAlmostPal(word, 0, word.length())){
                    out.println(word);
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally {
            // If the scanner and print writer exist close them
            if(in != null && out != null){
                in.close();
                out.close();
            }
        }
    }

    /**
     * Recursive method that checks if a word would be a palindrome if 1 letter is changed
     * @param word the word to be checked
     * @param sameLetterCounter the number of matching letters at both ends of the word
     * @param originalWordLength the length of the original word
     * @return true if the word is almost as palindrome
     */
    public static boolean isAlmostPal(String word, int sameLetterCounter, int originalWordLength){
        boolean isAlmostPal = false;
        // If letters at both ends of the word match
        if((word.charAt(0) == word.charAt(word.length() - 1)) && word.length() != 1){
            sameLetterCounter++;
        }
        // If a word has 1 or 2 letters (base case)
        if(word.length() < 3) {
            // If there is 1 pair of letters that doesn't match
            if((originalWordLength / 2 - sameLetterCounter) == 1) {
                isAlmostPal = true;
            }
        }
        // If the word is bigger than 2 letters
        else{
            isAlmostPal = isAlmostPal(word.substring(1,word.length() - 1), sameLetterCounter, originalWordLength);
        }
        return isAlmostPal;
    }
}
