package Striver.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class AlienDictionary {
    //abcd - a - 0, b - 1, c - 2, d - 3
    // Fetch order thus topo sort
    private static List<Integer> topoSort(int V, List<List<Integer>> adj){
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0)queue.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)queue.offer(it);
            }
        }
        return topo;
    }
    public static String findOrder(String[] dict, int N, int K) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for(int it:topo){
            ans = ans + (char)(it + (int)'a');
        }
        return ans;
    }
    //When order is not possible
    /*
     * Two cases
     *  1. abcd, abc dictionary order which is wrong abc and abc are same and in any dict abc should be before abcd.
     *  2. Cyclic dependency a < b < a
     *  Can be added this two cases to fix dictionary.
     */
    public static void main(String[] args) {
        String[] dict = {"caa", "aaa", "aab"};
        int numberOfWord = 3;
        int numberOfWordsFromEnglishAlphabets = 3;

        System.out.println(findOrder(dict, numberOfWord, numberOfWordsFromEnglishAlphabets));
    }
}
