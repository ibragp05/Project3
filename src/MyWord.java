/**
 * A class used to describe words and compare them
 * in a reverse alphabetical order
 *
 * @author Polina Ibragimova
 * @version 25.11.2020
 */
public class MyWord implements Comparable<Object>{
    String word;

    /**
     * Initializes word instance variable
     *
     * @param word String representation of a word
     */
    MyWord(String word){
        this.word = word;
    }

    /**
     * Compares the objects' fields in a reverse
     * alphabetical order
     *
     * @param o object being compared to
     * @return 0 if 2 words are the same
     *         1 if the first word comes after the second in the alphabet
     *         -1 if the first word comes before the second in the alphabet
     */
    @Override
    public int compareTo(Object o) {
        // Setting to lowercase to ignore the capitalization
        String word1 = this.word.toLowerCase();
        String word2 = ((MyWord)o).word.toLowerCase();
        // The length of the longest word
        int shortestLength = Math.min(word1.length(), word2.length());
        // Going through every character
        for(int i = 0; i < shortestLength; i++){
            // Reverse alphabetical order
            if(word1.charAt(i) > word2.charAt(i)){
                return -1;
            }
            else if(word1.charAt(i) < word2.charAt(i)){
                return 1;
            }
        }
        // If one word equals the beginning of the other word
        if(word1.length() > word2.length()){
            return -1;
        }
        else if(word1.length() < word2.length()){
            return 1;
        }
        else {
            return 0;
        }

    }

}
