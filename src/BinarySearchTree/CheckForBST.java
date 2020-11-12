package BinarySearchTree;

import BinaryTree.TreeNode;

/**
 * Created by tkmaab4 on 6/3/20.
 * https://www.youtube.com/watch?v=yEwSGhSsT0U
 */
public class CheckForBST {
    public static void main(String[] args) {

        TreeNode root = createTreeRoot();


        System.out.println(checkIfTreeIsBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE) );

        System.out.println("searchNode(root,11) " + searchNode(root,11));

        addNode(root,20);

        deleteNode(root,11);

    }

    /**
     * O(logN)
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private static boolean checkIfTreeIsBST(TreeNode root, int minValue, int maxValue) {

        if (root == null) {
            return true;
        }

        if (root.getData() > minValue && root.getData() < maxValue
            && checkIfTreeIsBST(root.getLeft(),minValue,root.getData())
            &&  checkIfTreeIsBST(root.getRight(),root.getData(),maxValue)) {
            return true;
        } else {
            return false;
        }
  }

    /**
     *  O(logN)
      * @param root
     * @param dataToBeAdded
     */
      private static void addNode(TreeNode root, int dataToBeAdded) {

        if (root == null) {
            return;
        }
        if (dataToBeAdded > root.getData()) {

            if (root.getRight() == null) {
                root.setRight(new TreeNode(dataToBeAdded));
            }
            addNode(root.getRight(),dataToBeAdded);

        } else if (dataToBeAdded < root.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(dataToBeAdded));
            }

            addNode(root.getLeft(),dataToBeAdded);
        }


      }

    /**
     * O(logN)
     * @param root
     * @param dataToDelete
     */
    private static TreeNode deleteNode(TreeNode root, int dataToDelete){

        if (root == null) {
            return root;
        } else if (dataToDelete < root.getData()) {
            TreeNode node = deleteNode(root.getLeft(),dataToDelete);
            root.setLeft(node);
        } else if (dataToDelete > root.getData()) {
            TreeNode node = deleteNode(root.getRight(),dataToDelete);
            root.setRight(node);
        } else {
            // Case 1 : No child
            if (root.getRight() == null && root.getLeft() == null){
                root = null;
            // Case 2 : One child
            } else if (root.getLeft() == null){
                root = root.getRight();
            } else if (root.getRight() == null){
                root = root.getLeft();
            // Case 3 : 2 children
            } else {
                TreeNode minNode = findMin(root.getRight());
                root.setData(minNode.getData());
                deleteNode(root.getRight(),minNode.getData());
            }
        }

        return root;

      }

    /**
     * Min will be left most element in the root
     * @param root
     * @return
     */
    private static TreeNode findMin(TreeNode root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    private static int checkNoOfNodes(TreeNode node) {
        int noOfNodes = 0;
        if (node.getRight() == null && node.getLeft() == null){
            return 0;
        } else if (node.getLeft() == null || node.getRight() == null){
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean searchNode(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        boolean targetFound = false;

        if (target > root.getData()) {
            targetFound = searchNode(root.getRight(), target);
        } else if (target < root.getData()){
            targetFound = searchNode(root.getLeft(),target);
        } else {
            return true;
        }

       return targetFound;
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
