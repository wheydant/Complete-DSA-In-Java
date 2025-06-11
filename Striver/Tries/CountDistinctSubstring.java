package Striver.Tries;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstring {
    static int numberOfSubstring(String s){
        Set<String> set = new HashSet<>();
        set.add("");
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                set.add(s.substring(i, j + 1));
            }
        }
        System.out.println(set);
        return set.size();
    }
    static class Node{
        Node[] links = new Node[26];
        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }
        void insert(char ch, Node node){
            this.links[ch - 'a'] = node;
        }
        Node get(char ch){
            return this.links[ch - 'a'];
        }
    }

    static int numberOfSubstringTrie(String s){
        Node root = new Node();
        int unique = 1;
        
        for(int i = 0; i < s.length(); i++){
            Node node = root;
            for(int j = i; j < s.length(); j++){
                if(!node.contains(s.charAt(j))){
                    node.insert(s.charAt(j), new Node());
                    unique++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return unique;
    }
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(numberOfSubstringTrie(s));
    }
}
