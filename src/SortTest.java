import java.io.*;
import java.util.*;
public class SortTest {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner in = null;
        int wordNum = 0;
        try {
            in = new Scanner(inputFile);
            while (in.hasNext()) {
                wordNum++;
                in.next();
            }
        } catch (IOException e) {
            System.out.println("IO");
        } finally {
            if (in != null) {
                in.close();
            }
        }
        MyWord[] myWords = new MyWord[wordNum];
        try {
            in = new Scanner(inputFile);
            for (int i = 0; i < wordNum; i++) {
                myWords[i] = new MyWord(in.next());
            }
        } catch (IOException e) {
            System.out.println("IO");
        } finally {
            if (in != null) {
                in.close();
            }
        }
        Arrays.sort(myWords);
        PrintWriter out = null;
        try{
            File myOutputFile = new File("output.txt");
            out = new PrintWriter(myOutputFile);
            for(MyWord myWord : myWords){
                out.print(myWord.word + " ");
            }

        }
        catch(IOException e){
            System.out.println("IO");
        }
        finally{
            if(out != null){
                out.close();
            }
        }
    }
}
