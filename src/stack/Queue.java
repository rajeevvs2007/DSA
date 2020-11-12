package stack;

/**
 * Created by tkmaab4 on 4/9/20.
 * 1. (Level: Medium) Implement a Queue using 2 Stacks.
 */
public class Queue<T> {


    Stack s1;
    Stack s1_temp;

    public Queue(){
        this.s1 = new Stack();
        this.s1_temp = new Stack();
    }
    //O(1)
    public void enqueue(T value){
        Node<T> node = new Node<T>(value);
        s1.push(node);
    }

    //O(n)
    public T dequeue(){

        while (!s1.isEmpty()) {
            s1_temp.push(s1.pop());
        }
        Node node = s1_temp.pop();
        T value = node != null ? (T)node.value:null;

        while (!s1_temp.isEmpty()) {
            s1.push(s1_temp.pop());
        }

        return value;
    }

    //O(n)
    public void enqueue1(T value){
        while (!s1.isEmpty()) {
            s1_temp.push(s1.pop());
        }
        Node<T> node = new Node<T>(value);
        s1.push(node);
        while (!s1_temp.isEmpty()) {
            s1.push(s1.pop());
        }

    }

    //O(1)
    public T dequeue1(T value){
        return (T)s1.pop();
    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }
}
