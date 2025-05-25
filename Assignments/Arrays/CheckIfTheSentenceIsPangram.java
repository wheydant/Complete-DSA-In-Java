
import java.util.Arrays;

public class CheckIfTheSentenceIsPangram{
    public static boolean checkIfPangram(String sentence) {
        int[] mapChar = new int[26];
        Arrays.fill(mapChar, 0);

        for(int i = 0; i < sentence.length(); i++){
            mapChar[(int)sentence.charAt(i) - 97]++;
        }
        for(int i = 0; i < mapChar.length; i++){
            //System.out.println((char)(i + 97));
            if(mapChar[i] == 0)return false;
        }
        return true;
    }
    public boolean checkIfPangramOptimum(String sentence) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.contains(String.valueOf(c))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
}