package digit;

public class Raokouling {
    public static void main(String[] args){
        String sentence = "peter piper picked a peck of pickled peppers";
        char[] letter = sentence.toCharArray();

        int[] freq = new int[26];
        for(int i=0; i<letter.length; i++){
            if(letter[i] - ' ' !=0){
                freq[ letter[i] - 'a']++;
            }
        }
        System.out.println("p的个数为: " + freq[15]);
    }
}