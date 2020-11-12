package queue;

import java.util.*;
import java.util.Queue;

/**
 * Created by tkmaab4 on 4/16/20.
 Deque implementation looks more less like this (language agnostic):

 so we have a deque of max elements, the one on the front is the desired max, and a standard queue.

 Push operation

 If the queue is empty, just push the element on both, the queue and the deque.
 If the queue is not empty, push the element on the queue, going from the back of the deque delete all elements that are strictly less than the one we are now pushing (they will surly not be the max, since the pushed element is larger and will last on the queue for longer) and push the current element on the back of the deque

 Remove operation

 If the front of the deque is equal to the front of the queue then pop both (deque from the front)
 If the front of the deque is not equal to the front of the queue then pop just the queue, the poped element surely is not the largest one.

 Get max
 It is just the first element of the deque.
 */
public class QueueMax {

    static Queue<Integer> primaryQueue = new LinkedList<>();
    static Deque<Integer> maxQueue = new LinkedList<>();


    public  void enqueue(int value) {
        primaryQueue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value ){
            maxQueue.removeLast();
        }
        maxQueue.add(value);

    }

    public  int dequeue() {
        if(primaryQueue.peek() == maxQueue.peek()) {
            maxQueue.poll();
        }
        return primaryQueue.poll();
    }

    public  int findMax() {
        return maxQueue.poll();
    }

    public static void main(String[] args) {
        QueueMax queueMax = new QueueMax();
        queueMax.enqueue(2);
        queueMax.enqueue(4);
        queueMax.enqueue(3);
        queueMax.enqueue(7);
        queueMax.enqueue(2);
        queueMax.enqueue(4);
        queueMax.enqueue(9);


        System.out.println("Max value " + queueMax.findMax());

    }

    /**
     *

    private static void constructInputQueue(Queue<DataElement> inputQ,int[] test) {
        int maxSoFar = 0;
        DataElement dataElement = null;
        for (int i : test){
            if (!inputQ.isEmpty()) {
                maxSoFar = inputQ.peek().getMaxSoFar() < i ? i:maxSoFar;
                dataElement = inputQ.peek();
                dataElement.setMaxSoFar(maxSoFar);
            }
            inputQ.add(new DataElement(i,maxSoFar));

        }


    }

    private static class DataElement {
        public int getValue() {
            return value;
        }
        public DataElement(int value,int maxSoFar){
            this.value=value;
            this.maxSoFar=maxSoFar;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMaxSoFar() {
            return maxSoFar;
        }

        public void setMaxSoFar(int maxSoFar) {
            this.maxSoFar = maxSoFar;
        }

        int value;
        int maxSoFar;


    }
     */
}
