package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
	void helper(int i, List<Integer> currPath, List<List<Integer>> allPaths, int[][] graph){
		if(i == graph.length - 1){
			// currPath.add(i);
			allPaths.add(new ArrayList<>(currPath));
			// currPath.remove(currPath.size() - 1);
			return;
		}
		for(int idx = 0; idx < graph[i].length; idx++){
			currPath.add(graph[i][idx]);
			helper(graph[i][idx], currPath, allPaths, graph);
			currPath.remove(currPath.size() - 1);
		}
	}
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currPath = new ArrayList<>();
		currPath.add(0);
		helper(0, currPath, allPaths, graph);
		return allPaths;
    }

	public static void main(String[] args) {
		System.out.println(new AllPathFromSourceToTarget().allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
	}
}
