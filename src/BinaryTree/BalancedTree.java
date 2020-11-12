package BinaryTree;

/**
 * Created by tkmaab4 on 5/31/20.
 */
public class BalancedTree {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        System.out.println(isBalancedTree(root) == Integer.MIN_VALUE ? "UnBalanced" : "Balanced");
    }

    private static int isBalancedTree(TreeNode root) {
        if(root == null){
            return -1;
        }
        int leftH = isBalancedTree(root.getLeft());
        if (leftH == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightH = isBalancedTree(root.getRight());
        if (rightH == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = Math.abs(leftH - rightH);
        if (diff > 1){
            return Integer.MIN_VALUE;
        }
        return Math.max(leftH,rightH) + 1;
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

       // node2.setLeft(node1);
        // node2.setRight(node3);
        // node3.setLeft(node5);
        //node6.setLeft(node5);
        //node6.setRight(node7);

        return node4;
    }
}
