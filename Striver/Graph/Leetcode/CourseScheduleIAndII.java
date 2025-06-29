package Striver.Graph.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Can use topological sort as one task is independent of other.
//Two approaches detect a cycle using DFS or keep an order with BFS Topo sort will be useful for II 
public class CourseScheduleIAndII {
    public int[] findOrderII(int numCourses, int[][] prerequisites) {
        //Form Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0;i < m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();

            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)q.offer(it);
            }
        }

        if(topo.size() == numCourses){
            return topo.stream().mapToInt(i -> i).toArray();
        }

        return new int[0];
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Form Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0;i < m; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();

            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)q.offer(it);
            }
        }

        return topo.size() == numCourses;
    }
}
