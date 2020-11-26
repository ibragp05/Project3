import java.io.*;
import java.util.*;

/**
 * A class that checks if any words from the dictionary are compound(2 words)
 * and outputs compound words in a file
 */
public class Composition {
    public static void main(String[] args) {
        File inputFile = new File("dictionary.txt");
        File outputFile = new File("composed.txt");
        Scanner in = null;
        PrintWriter out = null;
        // Arraylist with the all the words from the dictionary
        ArrayList<String> myWords = new ArrayList<>();
        try {
            in = new Scanner(inputFile);
            // If the file hasn't ended add the word to the end of the array
            while (in.hasNext()) {
                myWords.add(in.next());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        try {
            out = new PrintWriter(outputFile);
            // A regular array where the words from the arraylist will be put
            String[] myWordsArr = new String[myWords.size()];
            // Putting the elements of the arraylist to the regular array
            myWordsArr = myWords.toArray(myWordsArr);
            // Sorting the array in alphabetical order
            Arrays.sort(myWordsArr);
            for (int i = 0; i < myWords.size(); i++) {
                // Prints out the word if it is compound
                isCompound2(out, myWordsArr[i],myWordsArr);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally {
            if (out != null) {
                out.close();
            }

        }
    }

    /**
     * Checks if a word consists of two other words
     * @param out printwriter that outputs the compound words
     * @param word word to be checked
     * @param words the list of all words
     */
    public static void isCompound2(PrintWriter out, String word,
                                      String[] words){
        for(int i = 1; i < word.length(); i++){
            // Checks if every possible combination of 2 substrings corresponds to 2 words
            if (Arrays.binarySearch(words, word.substring(0, i)) > -1 &&
                Arrays.binarySearch(words, word.substring(i)) > -1){
                out.println(word + ": " + word.substring(0, i) + " " + word.substring(i));
                break;
            }
        }
    }
}
