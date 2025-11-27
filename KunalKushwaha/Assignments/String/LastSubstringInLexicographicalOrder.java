package KunalKushwaha.Assignments.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LastSubstringInLexicographicalOrder {
    public String lastSubstringBruteForce(String s) {
        List<String> v = new ArrayList<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < n; j++){
                temp.append(s.charAt(j));
                v.add(temp.toString());
            }
        }

        Collections.sort(v);

        return v.get(v.size() - 1);
    }
    public String lastSubstringBruteSet(String s) {
        SortedSet<String> v = new TreeSet<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < n; j++){
                temp.append(s.charAt(j));
                v.add(temp.toString());
            }
        }

        return v.last();
    }

    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;

        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
                continue;
            }

            if (s.charAt(i + k) > s.charAt(j + k)) {
                // i's substring is better, move j forward
                j = j + k + 1;
            } else {
                // j's substring is better, move i forward
                int tmp = i;
                i = j;
                //Imp case
                j = tmp + k + 1;
                // J + 1 gives TLE
                // j = j + 1;
            }

            k = 0; // reset offset
            if (i == j) j++; // make sure i and j don't overlap
        }

        return s.substring(i);
    }
    
    public String lastSubstringOptimum(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int maxIndex = len - 1;

        for(int currIndex = len - 2; currIndex >= 0; currIndex--) {
            if(arr[currIndex] > arr[maxIndex]) {
                maxIndex = currIndex;
            } else if(arr[currIndex] == arr[maxIndex]) {
                int ptr1 = currIndex + 1;
                int ptr2 = maxIndex + 1;

                while(ptr1 < maxIndex && ptr2 < len && arr[ptr1] == arr[ptr2]) {
                    ptr1++;
                    ptr2++;
                }

                if(ptr1 == maxIndex || ptr2 == len || arr[ptr1] > arr[ptr2]) {
                    maxIndex = currIndex;
                }
            }
        }

        return s.substring(maxIndex);
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("abab"));
    }
}
