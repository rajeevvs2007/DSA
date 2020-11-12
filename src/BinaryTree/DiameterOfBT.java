package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 5/31/20.
 * Find the Diameter of a Binary Tree. The Diameter is the longest path from any 2 nodes in the tree.
 */
public class DiameterOfBT {

    public static void main(String[] args) {

        TreeNode root = createTreeRoot();
        Map<String,Integer> diameterMap = new HashMap<>();
        diameterMap.put("diameter",-1);
        diameter(root,diameterMap);
        System.out.println("Diameter > "+ diameterMap.get("diameter"));

    }

    private static int diameter(TreeNode root, Map<String, Integer> diameterMap) {
        if (root == null){
            return 0;
        }
        int leftH = diameter(root.getLeft(), diameterMap);
        int rightH = diameter(root.getRight(), diameterMap);
        int height = Math.max(leftH,rightH) + 1;
        int maxPathAtNode = rightH +leftH + 1 ;
        int diameter = Math.max(maxPathAtNode,diameterMap.get("diameter"));
        diameterMap.put("diameter",diameter);
        return height;
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

        //node2.setLeft(node1);
        //node2.setRight(node3);

        node6.setLeft(node5);
        node6.setRight(node7);

        node5.setLeft(node1);
        node7.setLeft(node3);

        return node4;
    }
}


