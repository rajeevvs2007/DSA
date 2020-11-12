package BinaryTree;

import java.util.*;

/**
 * Created by tkmaab4 on 6/2/20.
 * Construct tree from inorder and pre/postorder traversal inputs
 */
public class BinaryTreeReconstruction {

    public static void main(String[] args) {

        TreeNode root = createTreeRoot();

        List<Integer>preOrderList = new ArrayList<Integer>();
        List<Integer>inOrderList = new ArrayList<Integer>();

        preorder(root,preOrderList);
        inorder(root,inOrderList);

        Object[] preOrderArray =  preOrderList.toArray();
        Object[] inOrderArray =  inOrderList.toArray();

        Integer[] inOrder = new Integer[inOrderArray.length];
        Integer[] preOrder = new Integer[preOrderArray.length];

        System.arraycopy(preOrderArray,0,preOrder,0,preOrder.length);
        System.arraycopy(inOrderArray,0,inOrder,0,inOrder.length);

        Map<Integer,Integer> inOrderMap =  createMapFromSubArray(inOrder);

        //Find root
        int rootData = findRoot(inOrderMap,preOrder);

        TreeNode newRoot = new TreeNode(rootData);

        createBinaryTree(inOrder,preOrder,inOrderMap,newRoot);


    }

    private static void createBinaryTree(Integer[] inOrder, Integer[] preOrder, Map<Integer,Integer> inOrderMap, TreeNode root) {

        if (root == null){
            return;
        }

        int rootIndex = findRootIndex(root.getData(),inOrder);

        if (rootIndex == -1) {
            return;
        }
        //Find left

        Integer[] leftSubArray = Arrays.copyOfRange(inOrder,0, rootIndex);
        Map<Integer,Integer> leftSubArrayMap =  createMapFromSubArray(leftSubArray);

        int leftRootData = findRoot(leftSubArrayMap,preOrder);
        TreeNode leftRoot = new TreeNode(leftRootData);
        root.setLeft(leftRoot);

        createBinaryTree(leftSubArray,preOrder,inOrderMap,leftRoot);
        //Find right
        Integer[] rightSubArray = Arrays.copyOfRange(inOrder,rootIndex+1, inOrder.length);
        Map<Integer,Integer> rightSubArrayMap =  createMapFromSubArray(rightSubArray);

        int rightRootData = findRoot(rightSubArrayMap,preOrder);
        TreeNode rightRoot = new TreeNode(rightRootData);
        root.setRight(rightRoot);

        createBinaryTree(rightSubArray,preOrder,inOrderMap,rightRoot);






    }

    private static int findRootIndex(int data, Integer[] inOrder) {
        int rootIndex = -1;
        for (int i = 0 ; i < inOrder.length; i ++) {
            if (data == inOrder[i]) {
                rootIndex = i ;
            }
        }
        return rootIndex;
    }

    private static Map<Integer, Integer> createMapFromSubArray(Integer[] leftSubArray) {
        Map<Integer,Integer> leftSubArrayMap = new HashMap<>();
        for (int i=0;i<leftSubArray.length;i++){
            leftSubArrayMap.put(leftSubArray[i],leftSubArray[i]);
        }
        return leftSubArrayMap;
    }

    private static int findRoot(Map<Integer, Integer> leftSubArrayMap, Integer[] preOrder) {
        for (int i = 0; i < preOrder.length; i ++){
            if(leftSubArrayMap.containsKey(preOrder[i])){
                leftSubArrayMap.remove(preOrder[i]);
                return preOrder[i];
            }
        }
        return -1;
    }

    private static void inorder(TreeNode root ,List<Integer> integerList) {
        if (root == null){
            return;
        }

        inorder(root.getLeft(),integerList);

        integerList.add(root.getData());

        inorder(root.getRight(),integerList);

        return;


    }

    private static List<Integer> preorder(TreeNode root, List<Integer> integerList) {
        if (root == null){
            return null;
        }

        integerList.add(root.getData());

        preorder(root.getLeft(),integerList);

        preorder(root.getRight(),integerList);

        return null;
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

        node3.setRight(node8);
        node3.setLeft(node6);

        node6.setLeft(node2);
        node6.setRight(node11);

        node11.setLeft(node9);
        node11.setRight(node5);

        node8.setRight(node13);

        node13.setLeft(node7);

        return node3;
    }
}
