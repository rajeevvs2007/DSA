package BinaryTree;

/**
 * Created by tkmaab4 on 5/31/20.
 */
public class BottomToTop {

    public static void main(String[] args) {
        TreeNode root = createTreeRoot();
        System.out.println(findHeight(root));
    }

    private static int findHeight(TreeNode root) {
        if (root == null){
            return -1;
        }

        int leftH = findHeight(root.getLeft());
        int rightH = findHeight(root.getRight());

        return Math.max(rightH,leftH) + 1;
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
