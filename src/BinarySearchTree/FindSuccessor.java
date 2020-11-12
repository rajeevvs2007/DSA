package BinarySearchTree;

import BinaryTree.TreeNode;

/**
 * Created by tkmaab4 on 6/5/20.
 */
public class FindSuccessor {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();

        System.out.println("findSuccessor(root,9) " + findSuccessor(root,findNode(root,9)));
        System.out.println("findSuccessor(root,6) " + findSuccessor(root,findNode(root,6)));
        System.out.println("findSuccessor(root,13) " + findSuccessor(root,findNode(root,13)));


    }

    private static TreeNode findNode(TreeNode root,int target) {
        TreeNode targetNode = null;
        while (root != null) {
            if (target < root.getData()){
                root = root.getLeft();
            }else if (target > root.getData()){
                root = root.getRight();
            } else {
                targetNode = root;
                break;
            }
        }
        return targetNode;
    }

    /**
     *
     * @param root
     * @param
     * @return
     */
    private static String findSuccessor(TreeNode root, TreeNode node) {
        if (node == null) {
            return null;
        }
        Integer successor = null;
        // Case : When right node is not null , find the MIN value in the right subtree
        if (node.getRight() != null) {
            node = node.getRight();
            while (node != null){
                successor = node.getData();
                node = node.getLeft();
            }

        } else {
            TreeNode current =  root;

            while(current != null){
                if (current.getData() > node.getData()){
                    successor = current.getData();
                    current = current.getLeft();
                } else if (current.getData() < node.getData()){
                    current = current.getRight();
                } else if (current.getData() == node.getData()){
                    break;
                }

            }

        }


        return successor == null ? null : String.valueOf(successor);
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
