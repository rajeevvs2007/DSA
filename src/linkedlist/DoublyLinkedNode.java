package linkedlist;

/**
 * Created by tkmaab4 on 4/1/20.
 */
public class DoublyLinkedNode<K,V> {

    DoublyLinkedNode<K,V> nextNode;
    DoublyLinkedNode<K,V> prevNode;
    K key;
    V value;


    public DoublyLinkedNode(K key, V value){
        super();
        this.key = key;
        this.value=value;
        }
}
