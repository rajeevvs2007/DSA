package linkedlist;

import java.util.HashMap;

/**
 * Created by tkmaab4 on 4/1/20.
 */
public class LRUCache<K,V> {

    HashMap<K,DoublyLinkedNode<K,V>> map;
    DoublyLinkedNode<K,V> head;
    DoublyLinkedNode<K,V> tail;
    int capacity;

    public LRUCache(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;

    }

    public V read(K key){
        if (key == null) {
            return null;
        }
        if (map.get(key) == null) {
            return null;
        }
        removeNode(map.get(key));
        appendNode(map.get(key));
        return map.get(key).value;
    }

    public void write(K key, V value){
        if (map.get(key) != null){
            removeNode(map.get(key));
        }
        if (map.size() == capacity){
            removeNode(head);
        }
        appendNode(new DoublyLinkedNode<>(key, value));

    }

    private void appendNode(DoublyLinkedNode<K, V> kvDoublyLinkedNode) {
        DoublyLinkedNode<K,V> doublyLinkedNode =
                new DoublyLinkedNode<>(kvDoublyLinkedNode.key,kvDoublyLinkedNode.value);

        if (head == null){
            head = doublyLinkedNode;
        } else {
            tail.nextNode = doublyLinkedNode;
            doublyLinkedNode.prevNode=tail;
        }
        tail = doublyLinkedNode;
        map.put(doublyLinkedNode.key,doublyLinkedNode);
    }

    private void removeNode(DoublyLinkedNode<K, V> kvDoublyLinkedNode) {
        if(kvDoublyLinkedNode == null){
            return;
        }
        DoublyLinkedNode<K, V> prevNode = kvDoublyLinkedNode.prevNode;
        DoublyLinkedNode<K, V> nextNode = kvDoublyLinkedNode.nextNode;

        if (prevNode == null) {
            head = nextNode;
        }
        if (nextNode == null){
            tail=prevNode;

        }
        prevNode.nextNode=nextNode;
        map.remove(kvDoublyLinkedNode.key);
    }



    public void remove(K key){

    }
}
