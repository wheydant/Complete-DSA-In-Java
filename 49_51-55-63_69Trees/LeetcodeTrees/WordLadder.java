package LeetcodeTrees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Time complexity = O(n^2*m)


public class WordLadder {
    //Gives TLE BC - O(n^3*m)
    public int ladderLengthKK(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        int length = 0;
        //Loop running for n times
        while(!q.isEmpty()){
            int size = q.size();
            length++;
            //Running n times
            for(int i = 0; i < size; i++){
                String current = q.poll();
                //Time m i.e. number of characters
                for(int j = 0; j < current.length(); j++){
                    char[] temp = current.toCharArray();
                    //Constant time
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord)){
                            return length + 1;
                        }
                        //TIme N
                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
    //Converting List to Set reduces time complexity O(n^2*m)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         // O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord))return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        visited.add(beginWord);
        int length = 1;
        //Loop running for n times
        while(!q.isEmpty()){
            int size = q.size();
            //Running n times
            for(int i = 0; i < size; i++){
                String current = q.poll();
                //Time m i.e. number of characters
                for(int j = 0; j < current.length(); j++){
                    char[] temp = current.toCharArray();
                    //Constant time
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if (temp[j] == ch) continue;
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord)){
                            return length + 1;
                        }

                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            length++;
        }

        return 0;
    }
}
