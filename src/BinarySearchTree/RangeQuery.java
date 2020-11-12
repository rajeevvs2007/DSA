package BinarySearchTree;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by tkmaab4 on 6/5/20.
 */
public class RangeQuery {

    public static void main(String[] args) {

        TreeNode root = createTreeRoot();
        int low = 3;
        int high = 11;
        List<Integer> range = findRange(root,low,high, null);
        findRangeOpt(root,low,high);
        System.out.println(Arrays.toString(range.toArray()));
        System.out.println(Arrays.toString(findRangeOpt(root,low,high).toArray()));

    }

    private static List<Integer>  findRangeOpt(TreeNode root, int low, int high) {

        List<Integer> rangeList = new ArrayList<>();

        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        while (!treeNodeStack.isEmpty()) {
            TreeNode treeNode = treeNodeStack.pop();
            if (treeNode.getData() >= low && treeNode.getData() <= high) {
                rangeList.add(treeNode.getData());
            }
            if(treeNode.getData() >= low && treeNode.getLeft() != null){
                treeNodeStack.push(treeNode.getLeft());
            }
            if(treeNode.getData() <= high  && treeNode.getRight() != null){
                treeNodeStack.push(treeNode.getRight());
            }
        }

        return rangeList;

    }

    /**
     * Inorder traversal
     * @param root
     * @param low
     * @param high
     * @param rangeList
     * @return
     */
    private static List<Integer> findRange(TreeNode root, int low, int high,List<Integer> rangeList) {

        if (root == null) {
            return rangeList;
        }
        if (rangeList == null) {
            rangeList = new ArrayList<Integer>();
        }
        if (root.getData() >= low) {
            findRange(root.getLeft(),low,high,rangeList);
        }


        if (root.getData() >= low && root.getData() <= high){
            rangeList.add(root.getData());
        }

        if (root.getData() <= high) {
            findRange(root.getRight(),low,high,rangeList);
        }


        return rangeList;
    }

    private static TreeNode createTreeRoot() {
        TreeNode node1 = new TreeNode();
        node1.setData(1);

        TreeNode node2 = new TreeNode();
        node2.setData(3);

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

        TreeNode node8 = new TreeNode();
        node8.setData(8);

        TreeNode node9 = new TreeNode();
        node9.setData(9);

        TreeNode node11 = new TreeNode();
        node11.setData(11);

        TreeNode node13 = new TreeNode();
        node13.setData(13);

        node7.setLeft(node3);
        node7.setRight(node9);

        node3.setLeft(node2);
        node3.setRight(node5);

        node5.setRight(node6);


        node9.setLeft(node8);
        node9.setRight(node11);

        node11.setRight(node13);


        return node7;
    }
}
