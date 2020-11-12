package linkedlist;

/**
 * Created by tkmaab4 on 4/6/20.
 * Given a Linked List, determine if it is a Palindrome. For example, the following lists are palindromes:
 * A -> B -> C -> B -> A
 * A -> B -> B -> A
 * K -> A -> Y -> A -> K
 */
public class Palindrome {


    public static void main(String[] args) {

        LinkedList linkedList = constructLinkedList();

        System.out.println(checkIfPalindrome(linkedList));



    }

    private static boolean checkIfPalindrome(LinkedList linkedList) {
        Node median = findMedian(linkedList);
        reverseLinkedList(median);

        Node start = linkedList.head;
        Node end = linkedList.tail;

        while (start !=null && end != null) {

            if (start.value != end.value) {
                System.out.println("Not a palindrome");
                return false;
            }

            start = start.next;
            end = end.next;
        }

        return true;


    }

    private static void reverseLinkedList(Node median) {
        Node current = median;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

    }

    private static LinkedList constructLinkedList() {

        LinkedList linkedList = new LinkedList();

        Node node1 = new Node();
        node1.value=1;
        node1.next=null;
        linkedList.appendNode(node1);

        Node node2 = new Node();
        node2.value=2;
        node2.next=null;
        linkedList.appendNode(node2);

//        Node node3 = new Node();
//        node3.value=3;
//        node3.next=null;
//        linkedList.appendNode(node3);

        Node node4 = new Node();
        node4.value=2;
        node4.next=null;
        linkedList.appendNode(node4);

        Node node5 = new Node();
        node5.value=1;
        node5.next=null;
        linkedList.appendNode(node5);

        return linkedList;

    }

    public static Node findMedian(LinkedList linkedList){
        Node slow = linkedList.head;
        Node fast = linkedList.head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;

    }
}
