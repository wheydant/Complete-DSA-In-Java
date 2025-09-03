package KunalKushwaha.Assignments.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        //Cant use comparator as char is primitive data type
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.compare(s1, s2) == 0;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        boolean[] map = new boolean[n];
        for(int i = 0; i < n; i++){
            if(map[i]) continue;
            List<String> currAnagrams = new ArrayList<>();
            currAnagrams.add(strs[i]);
            for(int j = i + 1; j < n; j++){
                if(isAnagram(strs[i], strs[j]) && !map[j]){
                    currAnagrams.add(strs[j]);
                    map[j] = true;
                }
            }
            ans.add(currAnagrams);
        }

        return ans;
    }

    public List<List<String>> groupAnagramsOptimum(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        int n=strs.length;
        if(n==0 || n==1){
            List<String> level=new ArrayList<>();
            level.add(strs[0]);
            ans.add(level);
            return ans;
        }
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            //After sorting all anagram will look the same
            Arrays.sort(c);
            String newstr=new String(c);
            //Add if not present
            map.putIfAbsent(newstr,new ArrayList<>());
            //And add the original string to the sortedString if it was not found earlier and even if pattern exist
            map.get(newstr).add(s);

        }
        ans.addAll(map.values());

        return ans;
    }    

    public static void main(String[] args) {
        GroupAnagrams q = new GroupAnagrams();
        System.out.println(q.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
