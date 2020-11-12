package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 5/5/20.
 */
public class BinarySearchFindingRange {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9};
        int rangeStart = 3;
        int rangeEnd = 9;

        System.out.println(Arrays.toString(findElementsInRange(rangeStart,rangeEnd,input)));
    }

    private static int[] findElementsInRange(int rangeStart, int rangeEnd, int[] input) {
        int low=0, high = input.length-1;
        int begIndex=0, endIndex=0;
        while (low < high){
            int mid = low + (high-low)/2;
            if (input[mid] > rangeStart) {
                high=mid-1;
            } else if (input[mid] < rangeStart){
                low=mid+1;
            } else {
                begIndex = mid;
                break;
            }
        }
        low=0;
        high = input.length-1;
        while (low < high){
            int mid = low + (high-low)/2;
            if (input[mid] > rangeEnd) {
                high=mid-1;
            } else if (input[mid] < rangeEnd){
                low=mid+1;
            } else {
                endIndex = mid;
                break;
            }
        }
        int[] output = Arrays.copyOfRange(input,begIndex,endIndex);
        return output;
    }


}
