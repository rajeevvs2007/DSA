package queue;

import sun.jvm.hotspot.tools.HeapDumper;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/15/20.
 */
public class SlidingWindows {

    public static void main(String[] args) {

        int[] input = {2,3,5,6,2,1};
        int slidingWindowSize = 3;

        findSlidingWindowSum(input,slidingWindowSize);
        findSlidingWindowSumWithQueue(input,slidingWindowSize);


    }

    private static void findSlidingWindowSumWithQueue(int[] input, int slidingWindowSize) {
        Queue<Integer> queue = new Queue<Integer>(3);
        int[] resultArray = new int[input.length];
        int windowSum = 0;
        int resultArrCnt=0;
        for (int i=0;i<input.length; i++){
            queue.add(input[i]);
            windowSum = windowSum + input[i];
            if(queue.length == slidingWindowSize) {
                resultArray[resultArrCnt]=windowSum;
                int removedElement = queue.remove();
                windowSum = windowSum - removedElement;
                resultArrCnt++;
            }
        }
        System.out.println("Final output Array " + Arrays.toString(resultArray));

    }

    /**
     * using 2 pointers
     * @param input
     * @param slidingWindowSize
     */
    private static void findSlidingWindowSum(int[] input, int slidingWindowSize) {
        if (slidingWindowSize > input.length) {
            throw new IllegalArgumentException("Window size greater than array size");
        }
        int start = 0;
        int end= start + slidingWindowSize;

        while (end <= input.length) {
            int sum = 0;
            for (int i=start;i<end;i++){
                sum=input[i]+sum;
                }
            System.out.println("SUM >>"+ sum);
            start = start+1;
            end=start + slidingWindowSize;
        }

    }
}
