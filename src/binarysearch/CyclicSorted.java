package binarysearch;

/**
 * Created by tkmaab4 on 3/23/20.
 * Given a sorted array A that has been rotated in a cycle, find the smallest element of the array in O(log(n)) time. For example,

 [1,2,4,5,7,8] rotated by 3 gives us A = [5,7,8,1,2,4] and the smallest number is 1.
 [1,2,4,5,7,8] rotated by 1 gives us A = [8,1,2,4,5,7] and the smallest number is 1.
 */
public class CyclicSorted {

    public static void main(String[] args) {
        int[] input = {5,7,8,1,2,4};

        System.out.println("smallest number " + findSmallestNumber(input));
    }

    private static int findSmallestNumber(int[] a) {
        int low=0,high=a.length-1,mid=0,right=a[a.length-1];

        while(low <= high){

            mid = low + (high-low)/2;
            if(a[mid] < right && (mid == 0 ||(a[mid]< a[mid-1]))){
                return a[mid];
            } else if (a[mid] > right){
                low = mid+1;
            } else {
                high=mid-1;
            }



        }
        return 0;
    }

}


