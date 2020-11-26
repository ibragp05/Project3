import java.io.*;
import java.util.*;

/**
 * A class for testing MyWord class's compareTo method
 * through sorting
 *
 * @author Polina Ibragimova
 * @version 25.11.2020
 */
public class SortTest {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner in = null;
        // The number of words in the file
        int wordNum = 0;
        try {
            in = new Scanner(inputFile);
            while (in.hasNext()) {
                wordNum++;
                // Moving to the next word
                in.next();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally {
            // Closing the scanner if it exists
            if (in != null) {
                in.close();
            }
        }
        // Array with MyWord objects formed with the input
        MyWord[] myWords = new MyWord[wordNum];
        try {
            // Opening the Scanner again to read the words again
            in = new Scanner(inputFile);
            for (int i = 0; i < wordNum; i++) {
                myWords[i] = new MyWord(in.next());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally {
            // Closing the scanner if it exists
            if (in != null) {
                in.close();
            }
        }
        // Sorting MyWords in reverse alphabetical order
        Arrays.sort(myWords);
        PrintWriter out = null;
        try{
            File myOutputFile = new File("output.txt");
            out = new PrintWriter(myOutputFile);
            // Printing out every word sorted
            for(MyWord myWord : myWords){
                out.print(myWord.word + " ");
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        finally{
            if(out != null){
                out.close();
            }
        }
    }
}
