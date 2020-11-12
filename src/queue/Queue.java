package queue;

/**
 * Created by tkmaab4 on 4/14/20.
 */
public class Queue<T> {

    Object[] dataElements;
    int front;
    int end;
    int length;
    int capacity;

    public Queue(int capacity){
        dataElements = new Object[capacity];
        front=0;
        end=0;
        length=0;
        this.capacity=capacity;
    }

    public void add(T value){
        if (length == capacity){
            throw new UnsupportedOperationException("Queue Full");
        }
        dataElements[end] = value;
        if (end == capacity-1) {
            end =0;
        } else {
            end = end+1;
        }

        length++;
    }

    public T remove(){
        if (length == 0) {
            throw new UnsupportedOperationException("Queue Empty");
        }
        T result = (T) dataElements[front];


        if (front == capacity-1) {
            front =0;
        } else {
            front = front +1;
        }
        length--;
        return result;

    }

}
