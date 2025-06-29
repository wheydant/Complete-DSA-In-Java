package Striver.Graph.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    class DisjointSet{
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUPar(int n){
            if(parent[n] == n) return n;

            return parent[n] = findUPar(parent[n]);
        }

        void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v) return;

            if(size[ulp_u] < size[ulp_v]){
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else{
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        //DisJoint Set creation
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                //First time encountering mail id
                if(mapMailNode.containsKey(mail) == false){
                    //Map stores initial index to fetch later
                    mapMailNode.put(mail, i);
                } else {
                    //Already encountered this mail need to merge nodes
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        //Attach mails to there ultimate parents
        //This is how its initialize like and array crazyyy
        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i = 0; i < n; i++) mergeMail[i] = new ArrayList<>();

        //This is how we fetch map Entries
        for(Map.Entry<String, Integer> it: mapMailNode.entrySet()){
            String mail = it.getKey();
            //Crazy step
            int node = ds.findUPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(mergeMail[i].size() == 0) continue;

            //Sort the mailId's
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
