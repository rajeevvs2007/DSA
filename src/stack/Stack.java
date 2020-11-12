package stack;

import javafx.util.Pair;

/**
 * Created by tkmaab4 on 4/8/20.
 */
public class Stack<T> {

 Node<T> top;


    public void push(Node<T> node){
        node.next=null;
        node.prev=null;

        if (top != null) {
            top.next = node;
            node.prev = top;
        }
        if (node.value instanceof Pair) {
            Pair<Integer,Integer> pair = (Pair)node.value;
            int maxSoFar = this.peek() != null ?  (int)((Pair)this.peek()).getValue() :0;
            if (maxSoFar <= pair.getKey()) {
                maxSoFar = pair.getKey();
            }
            pair = new Pair<>(pair.getKey(),maxSoFar);
            node.value = (T)pair;

        }
        top = node;

    }

    public Node<T> pop(){

        if (top == null) {
            return null;
        }
        Node<T> lastNode = top;
        top = top.prev;

        return lastNode;

    }

    public T peek(){
        return top !=null ? top.value : null;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
