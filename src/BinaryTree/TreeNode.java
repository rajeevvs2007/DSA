package BinaryTree;

/**
 * Created by tkmaab4 on 5/29/20.
 */
public class TreeNode {

    private TreeNode right;

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private TreeNode left;
    private boolean visited;
    private int data;

    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode() {

    }

}
