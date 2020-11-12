package binarysearch;

/**
 * Created by tkmaab4 on 3/23/20.
 * Binary search when the length of array is unknown.Find element with time complexity O(logn)
 */
public class BSWithUnknownLength {

    public static void main(String[] args) {
        int[] input = {2,5,9,10,11};
        System.out.println("BSWithUnknownLength >>" + findElementFromUnknownLength(input));
    }

    private static int findElementFromUnknownLength(int[] a) {
        boolean lastElement = false;
        int counter =0;
        int lowerLimit =0;
        int upperLimit =0;
        while (!lastElement){

            try {
                int element = a[counter];
                lowerLimit=counter;
                counter = counter + 2;
            } catch (ArrayIndexOutOfBoundsException e) {
                lastElement = true;
                upperLimit=counter;
            }


        }
        System.out.println("Upper and Lower limit > "+ lowerLimit + "::"+upperLimit);
        int mid=0;
        while (lowerLimit <= upperLimit){
            mid = lowerLimit + (upperLimit-lowerLimit)/2;
            try {
                int element = a[mid];
                lowerLimit = mid +1;
            } catch (ArrayIndexOutOfBoundsException e) {
                upperLimit = mid-1;
            }

        }
        System.out.println("Array length > "+ lowerLimit);

        int target = 9;
        int low = 0,high=lowerLimit-1,mid1=0;
        while (low <= high){
            mid1 = low + (high-low)/2;
            if (a[mid1]>target){
                high = mid1-1;
            } else if(a[mid]<target){
                low = mid1+1;
            } else {
                return mid1;
            }
        }

        return -1;
    }
}
