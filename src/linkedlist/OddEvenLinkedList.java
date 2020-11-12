package linkedlist;

/**
 * Created by tkmaab4 on 3/25/20.
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {



        LinkedList linkedList = constructLinkedList();

        LinkedList evenList = new LinkedList();
        LinkedList oddList = new LinkedList();


        Node current = linkedList.head;
        int counter = 0;
        while (current != null ) {
            if (counter%2 == 0) {
                evenList.appendNode(current);
            } else {
                oddList.appendNode(current);
            }
            current = current.next;
            counter ++;
        }

        evenList.tail.next=null;
        oddList.tail.next=null;
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
        node3.value=1;
        node3.next=null;
        linkedList.appendNode(node3);

        Node node4 = new Node();
        node4.value=2;
        node4.next=null;
        linkedList.appendNode(node4);

        return linkedList;



    }
}
