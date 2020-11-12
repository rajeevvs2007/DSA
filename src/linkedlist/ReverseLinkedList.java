package linkedlist;

/**
 * Created by tkmaab4 on 4/2/20.
 *
 * Input: Head -> 1 -> 2 -> 3 -> 4 -> null
 * Output: Head -> 4 -> 3 -> 2 -> 1 -> null
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = constructLinkedList();

        reverseLinkedList(linkedList);

   }

    private static void reverseLinkedList(LinkedList linkedList) {

        Node current = linkedList.head;
        Node prev = null;
        Node tail = linkedList.head;
        while (current != null){
            Node next = current.next;
            current.next=prev;
            prev=current;
            current=next;

        }

        linkedList.head = prev;
        linkedList.tail = tail;

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

        Node node3 = new Node();
        node3.value=3;
        node3.next=null;
        linkedList.appendNode(node3);

        Node node4 = new Node();
        node4.value=4;
        node4.next=null;
        linkedList.appendNode(node4);

        return linkedList;



    }
}
