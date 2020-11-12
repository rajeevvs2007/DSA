package binarysearch;

/**
 * Created by tkmaab4 on 3/23/20.
 *  Given a sorted array A and a target T, find the target. If the target is not in the array, find the number closest to the target.
 *  For example, if A = [2,3,5,8,9,11] and T = 7, return 8.
 */
public class FindClosestTarget {


    public static void main(String[] args) {
        int[] input = {2,3,8,8,9,11};
        int target = 12;
        System.out.println("closest target " + findClosestTarget(input,target));
        System.out.println("closest target " + findClosest1(input,target));
    }

    private static int findClosestTarget(int[] a, int target) {
        if (a == null || a.length == 0 ) {
            return -1;
        }
        int low=0,high=a.length-1,mid=0;
        while(low<=high) {
            mid = low + (high-low)/2;
            if (a[mid] > target){
                high = mid-1;

            } else if (a[mid] < target) {
                low = mid +1;
                if (mid == a.length-1 ){
                    return a[a.length-1];
                }
                if (a[mid+1] > target){

                    return a[mid+1];
                }
            } else {
                return mid;
            }
        }
        return 0;
    }

    private static int findClosest1(int[] a,int target) {

        if (a == null || a.length == 0 ) {
            return -1;
        }

        int closest=-1;
        for (int i=0;i<a.length;i++){
            if (target == a[i]){
                System.out.println("Target found at" + i);
            } else if (i>0 && target>a[i-1] && target <a[i]){
                closest=a[i];
            }else if (target>a[i]){
                closest=a[i];
            }
        }
        return closest;
    }

}
