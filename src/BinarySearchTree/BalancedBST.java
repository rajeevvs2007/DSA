package BinarySearchTree;

import BinaryTree.TreeNode;
import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by tkmaab4 on 6/8/20.
 */
public class BalancedBST {

    public static void main(String[] args) {

        int[] input = {1,3,4,5,6,7,8};
        int start = 0;
        int end = input.length-1;
        int mid = start + end-start/2;
        TreeNode root = getTree(input,start,end);
        LinkedList linkedList = createLinkeedList();
        TreeNode root1 = getTree(linkedList.head,linkedList.tail);
    }

    private static TreeNode getTree(Node head, Node tail) {
        if (head == null || tail == null) {
            return null;
        }

        MedianPair medianPair = findMedian(head,tail);
        if(medianPair == null) {
            return null;
        }
        TreeNode root = new TreeNode(medianPair.median.value);
        TreeNode rootL = getTree(head,medianPair.prev);
        if (medianPair.median == tail) {
            return null;
        }
        TreeNode rootR = getTree(medianPair.median.next,tail);
        root.setLeft(rootL);
        root.setRight(rootR);

        return root;
    }

    private static MedianPair findMedian(Node head, Node tail) {
        if (head == null || tail == null){
            return  null;
        }
        Node slow = head;
        Node fast = head;
        Node prevNode = null;
        while (fast != tail){
           fast = fast.next;
           if (fast != tail){
               fast=fast.next;
               prevNode = slow;
               slow=slow.next;
           }
        }
        return new MedianPair(slow,prevNode);
    }

    private static TreeNode getTree( int[] input, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(input[mid]);

        TreeNode rootL = getTree(input,start,mid-1);
        root.setLeft(rootL);

        TreeNode rootR = getTree(input,mid+1,end);
        root.setRight(rootR);

        return root;
    }

    private static LinkedList createLinkeedList() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node();
        node1.value = 1;
        linkedList.appendNode(node1);

        Node node2 = new Node();
        node2.value = 2;
        linkedList.appendNode(node2);

        Node node3 = new Node();
        node3.value = 3;
        linkedList.appendNode(node3);

        Node node4 = new Node();
        node4.value = 4;
        linkedList.appendNode(node4);

        Node node5 = new Node();
        node5.value = 5;
        linkedList.appendNode(node5);

        Node node6 = new Node();
        node6.value = 6;
        linkedList.appendNode(node6);

        Node node7 = new Node();
        node7.value = 7;
        linkedList.appendNode(node7);

        return linkedList;
    }

    private static class MedianPair {

        Node median;
        Node prev;

        MedianPair(Node median,Node prev){
            this.median = median;
            this.prev = prev;
        }

    }
}
