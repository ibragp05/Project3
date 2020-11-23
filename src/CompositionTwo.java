import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompositionTwo{
    /*
    public static String isCompound3OrMore(String word,
                                   String[] words, int iteration, String message){
        String answer = message;
        for (String item : words) {
            if ((word.equals("") || word.equals(item)) && iteration > 0) {
                answer += (" " + item);
                return answer;
            }
            if (word.startsWith(item) && !(word.equals(item))) {
                String subword = word.substring(item.length());
                answer += (" " + item);
                if (!(isCompound3OrMore(subword, words, iteration + 1, answer).equals(""))) {
                    answer = isCompound3OrMore(subword, words, iteration + 1, answer);
                    return answer;
                }
            }
        }
        return "";

    }

     */

    public static ArrayList<String> isCompound3OrMore(String word,
                                           String[] words, int iteration, ArrayList<String> message){
        ArrayList<String> answer = message;
        for (String item : words) {
            if ((word.equals("") || word.equals(item)) && iteration > 0) {
                if(answer.size() < iteration + 1) {
                    answer.add(" " + item);
                }
                else{
                    answer.set(iteration, item);
                }
                return answer;
            }
            if (word.startsWith(item) && !(word.equals(item))) {
                String subword = word.substring(item.length());
                if(answer.size() < iteration + 1) {
                    answer.add(" " + item);
                }
                else{
                    answer.set(iteration, item);
                }
                if (isCompound3OrMore(subword, words, iteration + 1, answer) != null &&
                    (!isCompound3OrMore(subword, words, iteration + 1, answer).isEmpty())) {
                    answer = isCompound3OrMore(subword, words, iteration + 1, answer);
                    return answer;
                }
            }
        }
        return null;

    }
}
