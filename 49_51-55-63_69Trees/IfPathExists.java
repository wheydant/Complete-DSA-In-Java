import BinarySearchTree.Node;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IfPathExists {
    boolean findPath(Node node, int[] arr){
        if(node == null)return arr.length == 0;

        return helper(node, arr, 0);
    }

    boolean helper(Node node, int[] arr, int index){
        if(node == null)return false;

        if(index >= arr.length || node.val != arr[index])return false;

        if(node.left == null && node.right == null && index == arr.length - 1)return true;

        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    int countPaths(Node node, int sum){
        List<Integer> path = new ArrayList<>();
        return helper(node, sum, path);
    }
    int helper(Node node, int sum, List<Integer> path){
        if(node == null)return 0;
        path.add(node.val);
        int count = 0;
        int s = 0;

        //how many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()){
            s += itr.previous();

            if(s == sum)count++;
        }

        count += helper(node.left, s, path) + helper(node.right, sum, path);

        //Backtrack
        path.remove(path.size() - 1);

        return count;

    }

    List<List<Integer>> findPaths(Node node, int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(node, sum, path);
        return paths;
    }
    void helper(Node node, int sum, List<Integer> path){
        if(node == null)return;
        path.add(node.val);

        if(node.val == sum && node.left == null && node.right == null)Paths.add(new ArrayList<>(path));
        else{
            helper(node.left, sum - node.val, path, path);
            helper(node.right, sum - node.val, path, path);
        }

        //Backtrack
        path.remove(path.size() - 1);

    }
}
