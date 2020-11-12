package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tkmaab4 on 3/30/20.
 */
public class FindCycle {

    public static void main(String[] args){
       LinkedList linkedList =  createLinkeedList();
       checkForCycle(linkedList);
       System.out.println("findLengthOfCycle >> " + findLengthOfCycle(linkedList));
       //findMedian(linkedList);
       Node node = findStartOfCycle(linkedList);
        System.out.println("findStartOfCycle>>"+ node.value);


    }

    private static Node findStartOfCycle(LinkedList linkedList) {
        Node current = linkedList.head;
        List<Node> nodeList = new ArrayList<Node>();
        while (current != null){
            if(nodeList.contains(current)){
                return current;
            }
            nodeList.add(current);
            current = current.next;

        }
        return null;
    }

    private static void findMedian(LinkedList linkedList) {

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null){
            fast = fast.next;
            if (fast != null){
                slow = slow.next;
                fast = fast.next;
            }

        }

        System.out.println("Median >> " + slow.value);

    }

    private static int findLengthOfCycle(LinkedList linkedList) {

        Node slow = linkedList.head;
        Node fast = linkedList.head;


        int counter = 0;
        while (fast != null) {
            fast = fast.next;
            if (slow == fast) {
                System.out.println("Link identified > "+ counter);
                break;
            }
            fast = fast.next;
            if(fast != null) {
                if (fast== slow) {
                    System.out.println("Link identified > "+ counter);
                    break;
                }
            }
            slow=slow.next;
            counter++;
        }

        slow = slow.next;
        int length = 1;
        while (slow != fast) {
            slow = slow.next;
            length++;
        }


        return length;
    }

    private static boolean checkForCycle(LinkedList linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        int counter = 0;
        while (fast != null) {
            fast = fast.next;
            if (slow == fast) {
                System.out.println("Link identified > "+ counter);
                return true;
            }
            fast = fast.next;
            if(fast != null) {
                if (fast== slow) {
                    System.out.println("Link identified > "+ counter);
                    return true;
                }
            }
            slow=slow.next;
            counter++;
        }

        return false;
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

        Node node7 = linkedList.head.next.next;
        linkedList.appendNode(node7);

        return linkedList;
    }
}
