package binarysearch;

/**
 * Created by tkmaab4 on 3/21/20.
 *
 * Time complexity O(logn)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {2,5,9,10,11};
        int target = 5, start=0, end = a.length-1;;
        int  mid=0;
        while (start <= end) {
            mid=start + (end-start)/2;
            if (a[mid] > target) {
                end = mid-1;
            } else if (a[mid] < target) {
                start=mid+1;
            } else {
                System.out.println("Match Found! " + mid);
                break;
            }
        }

    }
}
