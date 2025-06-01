package LeetcodeTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinayTree {
    private class Pair{
        TreeNode node;
        int row, col;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;

        // PriorityQueue to store (col, row, value)
        List<int[]> nodeList = new ArrayList<>();

        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        //This is how pairs are passed
        queue.offer(new Pair(root, 0, 0));

        int min = 0;
        int max = 0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode node = p.node;
            int row = p.row, col = p.col;

            nodeList.add(new int[]{col, row, node.val});
            if(node.left != null)
                queue.offer(new Pair(node.left, row + 1, col - 1));
            if(node.right != null)
                queue.offer(new Pair(node.right, row + 1, col + 1));
        }

        /*
        First check col 0th index if not equal sort.
        Then Check row enter here only when col are equal then sort on the basis of row.
        Third case is dummy if row and col are same compare value 
        */
        nodeList.sort((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        //Priority queue
        TreeMap<Integer, List<Integer>> colMap = new TreeMap<>();
        for (int[] triplet : nodeList) {
            //Store col and value
            int col = triplet[0];
            int val = triplet[2];
            colMap.computeIfAbsent(col, x -> new ArrayList<>()).add(val);
        }

        //Nice code
        ans.addAll(colMap.values());
        return ans;
    }
}
