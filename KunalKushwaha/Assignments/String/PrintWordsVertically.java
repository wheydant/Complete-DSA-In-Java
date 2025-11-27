package KunalKushwaha.Assignments.String;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        List<String> verticalStr = new ArrayList<>();
        String[] str = s.split("\\s+");
        int verticalIndex = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            boolean inserted = false;
            for(int i = 0; i < str.length; i++){
                if(verticalIndex >= str[i].length()) sb.append(" ");
                else {
                    sb.append(str[i].charAt(verticalIndex));
                    inserted = true;
                }
            }
            if(!inserted) break;
            verticalStr.add(sb.toString().replaceAll("\\s", ""));
            verticalIndex++;
        }
        return verticalStr;
    }

    public List<String> printVerticallyOptimum(String s) {
        String[] words = s.split(" ");
        List<String> ans = new ArrayList<>();
        int n = 0;
        for(String w : words){
            //Find the longest word
            n = Math.max(n, w.length());
        }

        for(int j = 0; j < n; j++){
            StringBuilder sb = new StringBuilder();
            for(String w : words){
                if(j < w.length()) sb.append(w.charAt(j));
                else sb.append(" ");
            }
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
                sb.setLength(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new PrintWordsVertically().printVertically("TO BE OR NOT TO BE"));
    }
}
