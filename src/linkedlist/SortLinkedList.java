package linkedlist;

/**
 * Created by tkmaab4 on 3/24/20.
 * You are given a Linked List with nodes that have values 0, 1 or 2. Sort the linked list. For example,

 Input: 1 -> 0 -> 2 -> 1 -> 2 -> 1
 Output: 0 -> 1 -> 1 -> 1 -> 2 -> 2
 */
public class SortLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = createLinkedList();

        sortLinkedList(linkedList);
    }

    private static void sortLinkedList(LinkedList linkedList) {

        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();

        Node current = linkedList.head;

        while (current != null) {

            if (current.value == 0) {
                linkedList1.appendNode(current);
            } else if (current.value == 1) {
                linkedList2.appendNode(current);
            } else {
                linkedList3.appendNode(current);
            }
        }

      if (linkedList1!= null){
          linkedList1.tail=null;
      }
        if (linkedList2!= null){
            linkedList2.tail=null;
        }
        if (linkedList3!= null){
            linkedList3.tail=null;
        }
        LinkedList result  = new LinkedList();
        result.appendNode(linkedList1.head);
        result.tail=linkedList1.tail;
        result.appendNode(linkedList2.head);
        result.tail=linkedList2.tail;
        result.appendNode(linkedList3.head);
        result.tail=linkedList3.tail;

    }

    private static LinkedList createLinkedList() {
        Node node = new Node();
        node.value=1;
        Node node1 = new Node();
        node1.value=0;
        Node node2 = new Node();
        node2.value=2;
        Node node3 = new Node();
        node3.value=1;
        Node node4 = new Node();
        node4.value=2;
        Node node5 = new Node();
        node5.value=1;

        LinkedList linkedList = new LinkedList();
        linkedList.appendNode(node);
        linkedList.appendNode(node1);
        linkedList.appendNode(node2);
        linkedList.appendNode(node3);
        linkedList.appendNode(node4);
        linkedList.appendNode(node5);
        return linkedList;


    }
}
