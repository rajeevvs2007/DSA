package binarysearch;

/**
 * Created by tkmaab4 on 3/23/20.
 * A = [1,3,4,5,2] => Peak = 5
 * A = [5,3,1] => Peak = 5
 * A = [1,3,5] => Peak = 5
 */
public class SearchForPeak {

    public static void main(String[] args) {

        int[] input = {1,3,4,5,2};
        System.out.println("Find peak >"+ findPeak(input));


    }

    private static int findPeak(int[] a) {

        int low=0,high=a.length-1,mid=0;
        while (low <= high){
            mid = low +(high-low)/2;
            int left = mid > 0 ? a[mid-1]:Integer.MIN_VALUE;
            int right = mid == a.length-1 ?Integer.MIN_VALUE:a[mid+1];
            if(a[mid] > left && a[mid]<right) {
             low = mid +1;
            }else  if (a[mid] < left && a[mid]>right){
              high = mid -1;
            }else if(a[mid] < left && a[mid] < right) {
                high = mid -1;
            }else {
                return a[mid];
            }
        }
        return -1;
    }
}
