package BinarySearchTree;

import BinaryTree.TreeNode;

/**
 * Created by tkmaab4 on 6/6/20.
 */
public class LCA {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        TreeNode node1 = findNode(root,8);
        TreeNode node2 = findNode(root,11);

        TreeNode lca = findLCA(root,node1,node2);
        System.out.println("LCA" + lca.getData());

    }

    private static TreeNode findNode(TreeNode root, int i) {
        if (root == null){
            return null;
        }
        TreeNode node = null;
        if(root.getData() > i){
            node = findNode(root.getLeft(),i);
        } else if (root.getData() < i){
            node = findNode(root.getRight(),i);
        }else {
            node = root;
        }
        return node;
    }

    private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        TreeNode lca = null;
        while (root != null) {
            if (root.getData() > node1.getData() && root.getData() > node2.getData()){
                root = root.getLeft();
            } else if (root.getData() < node1.getData() && root.getData() < node2.getData()){
                root = root.getRight();
            } else {
                lca = root;
                break;
            }
        }
        return lca;
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
