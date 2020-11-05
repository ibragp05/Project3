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
        int biggestLength = Math.max(word1.length(), word2.length());
        // Going through every character
        for(int i = 0; i < biggestLength; i++){
            // Reverse alphabetical order
            if(word1.charAt(i) > word2.charAt(i)){
                return -1;
            }
            else if(word1.charAt(i) < word2.charAt(i)){
                return 1;
            }
        }
        return 0;

    }

}
