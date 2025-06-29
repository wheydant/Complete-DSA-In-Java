package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


//Gives TLE
/*
 * We are storing sequences in queue - thus occupying lot of space.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();

        //As queue doesn't store String but stores Arraylist
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        while(!q.isEmpty()){
            ArrayList<String> vec = q.poll();

            //Remove already visited strings from prev level
            if(vec.size() > level){
                level++;
                for(String it: usedOnLevel){
                    set.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            if(word.equals(endWord)){
                //If its the first occurrence of the seq in ans just insert it
                if(ans.size() == 0){
                    ans.add(vec);
                    //For all the subsequent endWord encounter 1st check if it's size is equal to the size present in the ans if not ignore.
                }else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }

            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord) == true){
                        vec.add(replacedWord);

                        //Java works by reference if we pass vec directly then each time vec is changed it gets reflected here.
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);

                        //mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
    public List<List<String>> findLaddersBFSStyle(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        q.offer(startPath);
        
        Set<String> usedOnLevel = new HashSet<>();
        usedOnLevel.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            // Track used words for this level only
            Set<String> localUsed = new HashSet<>();

            for (int s = 0; s < size; s++) {
                ArrayList<String> path = q.poll();
                String lastWord = path.get(path.size() - 1);

                if (lastWord.equals(endWord)) {
                    if (ans.size() == 0 || path.size() == ans.get(0).size()) {
                        ans.add(new ArrayList<>(path));
                    }
                    continue;
                }

                for (int i = 0; i < lastWord.length(); i++) {
                    char[] charArr = lastWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArr[i] = c;
                        String newWord = new String(charArr);

                        if (set.contains(newWord)) {
                            ArrayList<String> newPath = new ArrayList<>(path); // Important!
                            newPath.add(newWord);
                            q.offer(newPath);
                            localUsed.add(newWord);
                        }
                    }
                }
            }

            // Remove only after processing the entire level
            for (String w : localUsed) set.remove(w);
        }

        return ans;
    }
//----------------------------------------------------//

    //Use ladderI solution store encounter level of each number then backtrack. Backtracking restricts the unnecessary paths.
    // Keeping it global helps to avoid constant lookup and argument pass
    String b;
    HashMap<String, Integer> mpp;
    List<List<String>> ans;
    void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            //As we are storing in reverse order
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = mpp.get(word);
        //This also helps we don't have to call function each time.
        int sz = word.length();

        for(int i = 0; i < sz; i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replaceString = new String(replacedCharArray);
                if(mpp.containsKey(replaceString) && mpp.get(replaceString) + 1 == steps){
                    seq.add(replaceString);
                    dfs(replaceString, seq);
                    //BackTrack for others in same level
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLaddersCP(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        b = beginWord;
        q.offer(beginWord);
        
        mpp = new HashMap<>();
        mpp.put(beginWord, 1);

        //Size will remain fix if only single char changes are going to occur
        int size = beginWord.length();
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word= q.poll();
            int steps = mpp.get(word);
            if(word.equals(endWord)) break;
            for(int i = 0; i < size; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    //This is how you store string and not .toString()
                    String replacedString = new String(replacedCharArray);
                    if(st.contains(replacedString)){
                        q.add(replacedString);
                        st.remove(replacedString);
                        mpp.put(replacedString, steps + 1);
                    }
                }
            }
        }

        ans = new ArrayList<>();
        //Here as we have exhausted the st thus checking is its present in map
        if(mpp.containsKey(endWord) == true){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}
