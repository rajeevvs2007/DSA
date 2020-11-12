package linkedlist;

/**
 * Created by tkmaab4 on 4/1/20.
 */
public class DoublyLinkedList<K,V> {

    public DoublyLinkedNode<K, V> getHead() {
        return head;
    }

    public void setHead(DoublyLinkedNode<K, V> head) {
        this.head = head;
    }

    public DoublyLinkedNode<K,V> head;
    public DoublyLinkedNode<K,V> tail;

    public void appendLinkedList(DoublyLinkedNode<K,V> doublyLinkedNode){
        if (head == null) {
            head = doublyLinkedNode;
        }else {
            tail.nextNode = doublyLinkedNode;
            doublyLinkedNode.prevNode=tail;
        }
        tail = doublyLinkedNode;

    }

    public void removeNode(DoublyLinkedNode<K,V> doublyLinkedNode) {


        if (head == doublyLinkedNode) {
            head = doublyLinkedNode.nextNode;
        }
        if (tail == doublyLinkedNode){
            tail = doublyLinkedNode.prevNode;
        }

        DoublyLinkedNode<K,V> prevNode = doublyLinkedNode.prevNode;
        DoublyLinkedNode<K,V> nextNode = doublyLinkedNode.nextNode;

        if (doublyLinkedNode.prevNode != null) {
            prevNode.nextNode = nextNode;
        }
        if (doublyLinkedNode.nextNode != null) {
            nextNode.prevNode = prevNode;
        }

    }



}
