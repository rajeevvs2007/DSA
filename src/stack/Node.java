package stack;

/**
 * Created by tkmaab4 on 4/8/20.
 */
public class Node<T> {

    T value;
    Node next;
    Node prev;

    public Node(T value){
        this.value = value;
    }
}
