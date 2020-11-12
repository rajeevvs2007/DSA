package queue;

import java.util.*;

/**
 * Created by tkmaab4 on 4/17/20.
 * Given an array A and an integer K, find the maximum element in each sliding window of size K. For example:

 A = [4,6,5,2,4,7] and K = 3, windows are as follows:

 [4,6,5,2,4,7] : Max = 6
 [4,6,5,2,4,7] : Max = 6
 [4,6,5,2,4,7] : Max = 5
 [4,6,5,2,4,7] : Max = 7

 Output: 6,6,5,7

 Hint: You can do this in O(n) time, by using the Queue with Max we implemented above.
 */
public class SlidingWindowMax {
    java.util.Queue<Integer> mainQueue = new LinkedList<Integer>();
    java.util.Deque<Integer> maxQueue = new LinkedList<Integer>();

    public void enqueue(int value) {
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.removeLast();
        }
        mainQueue.add(value);
        maxQueue.add(value);
    }

    public int dequeue(){
        if(mainQueue.peek() == maxQueue.peek()){
            maxQueue.poll();
        }
        return mainQueue.poll();
    }

    public int findMax() {
        return maxQueue.peek();
    }

    public int size(){
        return mainQueue.size();
    }

    public boolean isEmpty(){
        return mainQueue.isEmpty();
    }


    public static void main (String[] args) {
        int[] input = {4,6,5,2,4,7};
        int[] output = new int[input.length];
        int outputArrayCounter = 0;
        int windowWidth = 3;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        for (int i : input){

            slidingWindowMax.enqueue(i);

            if (!slidingWindowMax.isEmpty() && slidingWindowMax.size() == windowWidth){
                output[outputArrayCounter]=slidingWindowMax.findMax();
                slidingWindowMax.dequeue();
                outputArrayCounter++;
            }


        }
        System.out.println("Output array " + Arrays.toString(output));
    }




}
