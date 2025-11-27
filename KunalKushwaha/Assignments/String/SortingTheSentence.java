package KunalKushwaha.Assignments.String;

import java.util.Arrays;

public class SortingTheSentence{
    public String sortSentence(String s) {
        int n = s.length();
        String[] strArray = new String[10];
        Arrays.fill(strArray, "~");
        int i = 0;

        while(i < n){
            if(s.charAt(i) == ' '){
                i++;
            }else{
                StringBuilder word = new StringBuilder();
                word.append(s.charAt(i));
                i++;
                //1-9 is specified and 57 is the last value.
                while(s.charAt(i) > 57){
                    word.append(s.charAt(i++));
                }

                strArray[57 - s.charAt(i++)] = word.toString();
            }
        }

        StringBuilder sortedSentence = new StringBuilder();
        for(int j = 9; j >= 0; j--){
            if(strArray[j].compareTo("~")==0){
                continue;
            }
            sortedSentence.append(strArray[j]);
            sortedSentence.append(" ");
        }
        sortedSentence.deleteCharAt(sortedSentence.length() - 1);
        return sortedSentence.toString();
    }
    public static void main(String[] args) {
        SortingTheSentence q = new SortingTheSentence();
        System.out.println(q.sortSentence("is2 sentence4 This1 a3"));
    }
}