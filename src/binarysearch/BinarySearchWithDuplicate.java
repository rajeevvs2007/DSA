package binarysearch;


/**
 * Created by tkmaab4 on 3/22/20.
 * Given a sorted array that can contain duplicates, find the first occurrence of a target element T.
 * For example, if A = [2,3,4,4,5,6] and T = 4, return index 2.
 */
public class BinarySearchWithDuplicate {

    public static void main(String[] args) {
        int[] input = {1,2,4,5,5,7};
        int target=9;
        System.out.println("binarySearch! "+ binarySearch(input,target));
    }

    private static int binarySearch(int[] a, int target) {
        int low=0,high=a.length-1, mid=0;
        while (low<=high){
            mid = low + (high-low)/2;
            if (target > a[mid]) {
                low=mid+1;
            } else if (target<a[mid]|| (a[mid]==target && mid >0 && a[mid-1]==target)) {
                high=mid-1;
            } else {
                return mid;
            }
        }
        return 0;
    }

}
