package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/26/20.
 * Rotate an array A by X items. For example,
 A = [1,2,3,4,5,6] and X = 2, Result = [5,6,1,2,3,4]

 */
public class RotateArrayByXTimes {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int target = 2;
        int start=0;
        int end = a.length-1;
        reverseArray(a,start,end);
        reverseArray(a,start,target-1);
        reverseArray(a,start+target,end);
        System.out.println("Final array" + Arrays.toString(a));


    }

    private static void reverseArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }


    }
}
