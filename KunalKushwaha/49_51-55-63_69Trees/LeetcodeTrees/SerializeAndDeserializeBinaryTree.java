package LeetcodeTrees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
    One approach have pre and inorder storage.
    Another approach store pre order with null. There also better way via heaps
*/
public class SerializeAndDeserializeBinaryTree {
    private static final String splitter = ",";
    private static final String nullNode = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    void buildString(TreeNode node, StringBuilder sb){
        if(node == null)sb.append(nullNode).append(splitter);
        else{
            sb.append(node.val).append(splitter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }

    TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals(nullNode)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
