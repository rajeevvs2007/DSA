package BinaryTree;

import java.util.Stack;

/**
 * Created by tkmaab4 on 5/29/20.
 */
public class InOrderIteration {

    public static void main(String[] args) {
        TreeNode rootNode = createTreeRoot();

        inOrderIterative(rootNode);

        System.out.println("inOrderRecursive");

        inOrderRecursive(rootNode);

        System.out.println("inorderWithoutMarker");

        inorderWithoutMarker(rootNode);
    }

    private static void inOrderIterative(TreeNode rootNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(rootNode);

        while (!treeNodeStack.isEmpty()) {
        TreeNode current = treeNodeStack.pop();
           if (current.isVisited()) {
            System.out.println(current.getData());
        } else {
             if (current.getRight() != null){
                 treeNodeStack.push(current.getRight());
             }
            current.setVisited(true);
            treeNodeStack.push(current);
            if (current.getLeft() != null) {
                treeNodeStack.push(current.getLeft());
            }

        }



        }

    }

    private static void inOrderRecursive(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrderRecursive(rootNode.getLeft());
        System.out.println(rootNode.getData());
        inOrderRecursive(rootNode.getRight());

    }

    /**
     * 1) Create an empty stack S.
     2) Initialize current node as root
     3) Push the current node to S and set current = current->left until current is NULL
     4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
     5) If current is NULL and stack is empty then we are done.
     * @param treeNode
     */
    private static void inorderWithoutMarker (TreeNode  treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode current = treeNode;

        while (current != null || !treeNodeStack.isEmpty()) {

            while(current != null) {
                treeNodeStack.push(current);
                current = current.getLeft();
            }

            current = treeNodeStack.pop();
            System.out.println(current.getData());
            current = current.getRight();
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
