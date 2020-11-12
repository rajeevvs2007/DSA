package binarysearch;

/**
 * Created by tkmaab4 on 3/22/20.
 * You are given a sorted array A and a target T. Return the index where T would be placed if inserted in order. For example,

 A = [1,2,4,5,6,8] and T = 3, return index 2
 A = [1,2,4,5,6,8] and T = 0, return index 0
 A = [1,2,4,5,6,8] and T = 4, return index 3.

 aka Given an array A and target T, Find the first element larger than T
 */
public class BinarySearchInsertion {

    public static void main(String[] args) {
        int[] input = {1,2,4,5,7,8};
        int target = 6;

        System.out.println("Insert at index "+ binarySearchInsertOrder(input,target));
    }

    private static int binarySearchInsertOrder(int[] a, int target) {
        int low=0,high=a.length-1,mid=0;
        while (low <= high){
            mid = low + (high-low)/2;
            if (a[mid] > target){
                high = mid-1;
                if(mid == 0 || a[mid-1]<=target){
                    return mid;
                }

            } else if (a[mid] < target){
                if (mid == a.length-1) {
                    return a.length;
                }
                low=mid+1;

            }
        }
        return 0;
    }


}
