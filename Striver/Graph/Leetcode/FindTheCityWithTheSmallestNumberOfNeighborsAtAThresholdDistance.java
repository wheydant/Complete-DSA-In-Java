package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    //Floyd Warshall
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        //Fill the matrix
        int m = edges.length;
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            // Making undirected graph to directed graph
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        //Initializing diagonal to 0
        for(int i = 0; i < n; i++)dist[i][i] = 0;

        for(int k = 0;k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for(int city = 0; city < n; city++){
            int cnt = 0;
            for(int adjCity = 0 ;adjCity < n; adjCity++){
                if(dist[city][adjCity] <= distanceThreshold) cnt++;
            }

            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }

    //Dijkstra's Algo
    class Solution {
    class Pair{
        int node;
        int d;
        Pair(int n, int dist){
            this.node = n;
            this.d = dist;
        }
    }
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        List<List<Pair>> adjList = new ArrayList<>(); //sc -> V^2
        for(int i = 0; i<n; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            //bidirectional
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.d - b.d); //sc -> V
        int city = 0;
        int cities = Integer.MAX_VALUE;
        //tc = V * (E*logV + V) => V^2 + EVlogV
        for(int i = 0; i<n; i++){
            //find shortest dist from every node
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Pair(i, 0));
            dist[i] = 0;
            
            //tc - E * logV
            while(!pq.isEmpty()){
                Pair curP = pq.poll();
                int cur = curP.node, d = curP.d;
                for(Pair adjP: adjList.get(cur)){
                    int newD = d + adjP.d;

                    //Checking distance here itself so later we can clearly fetch just inf or not
                    if(newD <= distanceThreshold && newD < dist[adjP.node]){
                        pq.add(new Pair(adjP.node, newD));
                        dist[adjP.node] = newD;
                    }
                }
            }
            
            //calculating city with minCities reachable in threshold
            //count cities reachable
            int citiesReachable = 0;
            for(int j = 0; j<n; j++){
                if(i != j && dist[j] != Integer.MAX_VALUE){
                    citiesReachable++;
                }
            }
            if(citiesReachable <= cities){
                city = i;
                cities = citiesReachable;
            }
        }  

        return city;
    }
}
}
