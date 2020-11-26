import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CompositionTwo{
    public static void main(String[] args) {
        File inputFile = new File("dictionary.txt");
        File outputFile = new File("composedMore.txt");
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
            // Going through every word in the arraylist
            for (int i = 0; i < myWords.size(); i++) {
                // The list of substings in a word
                ArrayList<String> outputList =
                        CompositionTwo.isCompound3OrMore(myWords.get(i), myWords, 0, new ArrayList<String>());
                // If there are substrings
                if ( outputList!= null) {
                    String output = "";
                    for (String string : outputList) {
                        // Concatenating all the substrings
                        output += (string + " ");
                    }
                    out.println(myWords.get(i) + ": " + output);
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
            if (out != null) {
                out.close();
            }

        }
    }

    /**
     * Checks if the word is a compound with any number of substrings
     *
     * @param word word to be tested
     * @param words the array of all available words
     * @param iteration the number of times function was called minus 1
     * @param message the substrings of the compound word
     * @return null if word is not compound and array with parts of the
     * compound word if it is
     */
    public static ArrayList<String> isCompound3OrMore(String word,
                                                      ArrayList<String> words, int iteration, ArrayList<String> message){
        // If the function was just called from the main method
        if(iteration == 0){
            Collections.sort(words);
        }
        ArrayList<String> answer = message;
        // Base case
        // If there are no substrings left or the last substring equals a word
        // and the function has been recursively called
        if ((word.equals("") || Collections.binarySearch(words, word) > -1) && iteration > 0) {
            // If the substring for the current iteration was not assigned yet
            if(answer.size() < iteration + 1) {
                answer.add(" " + word);
            }
            // If there was already a substring for the current iteration
            else{
                answer.set(iteration, word);
            }
            return answer;
        }
        for (int i = 0; i < word.length(); i++) {
            // a substring of varied length representing the beginning of the word
            String substringOfWord = word.substring(0, i);
            // The result of checking if the beginning of the the word is a separate word
            int searchIndex = Collections.binarySearch(words, substringOfWord);
            if ( searchIndex > -1) {
                // Creating a substring representing the rest of the word
                String subword = word.substring(i);
                // Adding the beginning of the word to the list of substrings of the compound word
                if(answer.size() < iteration + 1) {
                    answer.add(" " + substringOfWord);
                }
                else{
                    answer.set(iteration, " " + substringOfWord);
                }
                // Recursively calling the function with the end of the word as the word argument
                answer = isCompound3OrMore(subword, words, iteration + 1, answer);
                return answer;
            }
        }
        //
        return null;
    }

}
