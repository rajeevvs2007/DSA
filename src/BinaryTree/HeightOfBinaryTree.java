package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 5/30/20.
 */
public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        Map<String,Integer> maxDepth = new HashMap<>();
        maxDepth.put("maxDepth", -1);
        int depthOfParent= -1;
        heightOfBinaryTree(root,maxDepth,depthOfParent);
        System.out.println("Height of BT"+ maxDepth);
    }

    private static void heightOfBinaryTree(TreeNode root, Map<String,Integer> maxDepth, int depthOfParent) {

        if (root == null) {
            return;
        }
        int depthOfCurrentNode = depthOfParent+1;
        int maxDepthIntValue = maxDepth.get("maxDepth");
        maxDepthIntValue = Math.max(maxDepthIntValue,depthOfCurrentNode);
        maxDepth.put("maxDepth", maxDepthIntValue);
        heightOfBinaryTree(root.getLeft(),maxDepth,depthOfCurrentNode);
        heightOfBinaryTree(root.getRight(),maxDepth,depthOfCurrentNode);

    }

    private static TreeNode createTreeRoot() {
        TreeNode node1 = new TreeNode();
        node1.setData(1);

        TreeNode node2 = new TreeNode();
        node2.setData(2);

        TreeNode node3 = new TreeNode();
        node3.setData(3);

        TreeNode node4 = new TreeNode();
        node4.setData(4);

        TreeNode node5 = new TreeNode();
        node5.setData(5);

        TreeNode node6 = new TreeNode();
        node6.setData(6);

        TreeNode node7 = new TreeNode();
        node7.setData(7);

        node4.setLeft(node2);
        node4.setRight(node6);

        node2.setLeft(node1);
        node2.setRight(node3);

        node6.setLeft(node5);
        node6.setRight(node7);

        return node4;
    }

    private static class MutableInt {

        int value;


    }
}
