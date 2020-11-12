package BinarySearchTree;

import BinaryTree.TreeNode;

/**
 * Created by tkmaab4 on 6/5/20.
 */
public class FindTheFirstOccurence {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        TreeNode treeNode = findTheFirstOccurence(root,7,null);
    }

    private static TreeNode findTheFirstOccurence(TreeNode root, int target, TreeNode firstNode) {
        if(root == null){
            return firstNode;
        }

        if (target < root.getData()){
            firstNode =  findTheFirstOccurence(root.getLeft(),target,firstNode);
        } else if (target > root.getData()){
            firstNode = findTheFirstOccurence(root.getRight(),target,firstNode);
        } else {

            firstNode = findTheFirstOccurence(root.getLeft(),target,root);
        }

        return firstNode;
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
        node5.setData(7);

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
