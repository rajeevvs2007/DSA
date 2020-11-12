package BinaryTree;

/**
 * Created by tkmaab4 on 5/31/20.
 * Given 2 nodes of a tree, find their lowest common ancestor (LCA). Assume that each node has a parent pointer.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode root = createTreeRoot();

        TreeNode node1 = findNode(root,7);
        TreeNode node2 = findNode(root,8);

        TreeNode lca = findLCA(root,node1,node2);

        System.out.println("LCA >>" + lca.getData());
    }

    private static TreeNode findLCA(TreeNode current, TreeNode node1, TreeNode node2) {

        if (current == null){
            return null;
        }

        if (current == node1 || current == node2){
            return current;
        }

        TreeNode nodeL = findLCA(current.getLeft(),node1,node2);
        TreeNode nodeR = findLCA(current.getRight(),node1,node2);

        if (nodeL != null && nodeR != null) {
            return current;
        }

        return nodeL != null ? nodeL : nodeR;

    }

    private static TreeNode findNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.getData() == target){
            return root;
        }

        TreeNode left =  findNode(root.getLeft(),target);
        TreeNode right =  findNode(root.getRight(),target);

        return left != null ? left : right;
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

        node3.setLeft(node8);
        node3.setRight(node6);

        node6.setLeft(node2);
        node6.setRight(node11);

        node11.setLeft(node9);
        node11.setRight(node5);

        node8.setRight(node13);

        node13.setLeft(node7);

        return node3;
    }
}
