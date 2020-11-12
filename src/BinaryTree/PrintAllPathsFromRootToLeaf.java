package BinaryTree;


import java.util.Stack;

/**
 * Created by tkmaab4 on 5/30/20.
 */
    public class PrintAllPathsFromRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        String prevPath = null;
        printPath(root,prevPath);
        Stack<TreeNode> treeNodeStack = new Stack();
        printPathUsingStack(root,treeNodeStack);
    }

    private static void printPathUsingStack(TreeNode root, Stack<TreeNode> treeNodeStack) {
        if (root == null) {
            return;
        }
        treeNodeStack.push(root);

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(treeNodeStack);
        }
        printPathUsingStack(root.getLeft(),treeNodeStack);
        printPathUsingStack(root.getRight(),treeNodeStack);
        treeNodeStack.pop();
    }

    private static void printPath(TreeNode root, String prevPath) {
        if (root == null) {
           return;
        }
        prevPath = prevPath != null ? prevPath+">" + root.getData() : String.valueOf(root.getData());
        printPath(root.getLeft(),prevPath);
        printPath(root.getRight(),prevPath);

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(prevPath);
        }
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
}
