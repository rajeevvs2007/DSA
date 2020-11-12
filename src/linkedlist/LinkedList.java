package linkedlist;

/**
 * Created by tkmaab4 on 3/24/20.
 */
public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList(){
        this.head=null;
        this.tail=null;
    }

    public void appendNode(Node node){
        if(head == null){
            head = node;
        } else {
            tail.next=node;
        }
        tail = node;

    }

    public void deleteNode(Node prevNode, Node toDelete) {
        if (toDelete == null){
            return;
        }

        if (toDelete == head) {
            head = toDelete.next;
        }
        if (toDelete == tail) {
            tail = prevNode;
        }
        if (prevNode != null) {
            prevNode.next = toDelete.next;
        }

        return;
    }

}
