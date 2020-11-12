package linkedlist;

/**
 * Created by tkmaab4 on 3/26/20.
 * Delete a node of linked list
 */
public class DeleteNode {

    public static void main(String[] args) {

        LinkedList linkedList = constructLinkedList();
        Node current = linkedList.head;

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
