package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/27/20.
 * 1. (Level: Hard) BigInteger Addition: You are given a number in the form of an array.
 * Each digit in the array represents a digit in the number. For example, 100 -> [1,0,0].
 * Perform addition of 2 such number arrays. For example,
 * [1,1,1,1] + [2,2,3,3] = [3,3,4,4]
 * [9,9] + [1] = [1,0,0]
 */
public class BigIntegerAddition {

    public static void main(String[] args) {

        int[] array1 = {9,9,9};
        int[] array2 = {1};

        int[] result = addInteger(array1,array2);
        System.out.println("result "+ Arrays.toString(result));
    }

    private static int[] addInteger(int[] array1, int[] array2) {
        int[] larger = array1.length > array2.length ? array1:array2;
        int[] smaller = larger == array1 ? array2 : array1;
        int[] result = new int[larger.length+1];
        smaller = resizeToLarger(smaller, larger.length);
        int carry=0;
        int sum=0;
        for (int i=larger.length-1;i>=0;i--){
            sum = larger[i] + smaller[i] + carry;
            carry = sum/10;
            result[i]=sum%10;
        }
        result[0]=carry;
        return result;
    }

    private static int[] resizeToLarger(int[] smaller,int size) {
        if (smaller.length >= size){
            return new int[0];
        }
        int[] ret = new int[size];
        int diff = size-smaller.length;
        int diff1 = diff;
        for (int i=0;i<size;i++){
            if (diff > 0){
                ret[i]=0;
                diff--;
            }else{
            ret[i] = smaller[i-diff1];
            }

        }
        return ret;
    }

}
