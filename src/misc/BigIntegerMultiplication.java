package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/28/20.
 *  (Level: Hard) BigInteger Multiplication: You are given a number in the form of an array.
 *  Each digit in the array represents a digit in the number. For example, 100 -> [1,0,0].
 *  Perform multiplication of 2 such number arrays. For example,

 [2,0,5,0] * [2] = [4,1,0,0]
 [9,9] * [1] = [9,9]
 */
public class BigIntegerMultiplication {

    public static void main(String[] args) {

    int[] a = {9,4,3};
    int[] b = {9};
    int[] result = multiply2Arrays(a,b);
    System.out.println("result "+ Arrays.toString(trimLeadingZeros(result)));




    }

    private static int[] trimLeadingZeros(int[] result) {
        int endIndex=0;
        for (int i=0;i<result.length;i++){
            if(result[i]>0){
                endIndex=i;
                break;
            }
        }
        return Arrays.copyOfRange(result,endIndex,result.length);
    }

    private static int[] multiply2Arrays(int[] a, int[] b) {
        if(a==null || b == null || a.length <1|| b.length < 1){
            return null;
        }
        int[] larger = a.length > b.length ? a:b;
        int[] smaller = larger == a ? b : a;
        int[] result = new int[0];
        int zerocount=0;
        for (int i=smaller.length-1;i>=0;i--){
            int[] product = new int[larger.length+1+zerocount];
            int carry=0;
            for(int j=larger.length-1;j>=0;j--){
                int prod=larger[j] * smaller[i]+carry;
                product[j+1]=prod%10;
                carry=prod/10;
            }
            product[0]=carry;
            result=addInteger(result,product);
            zerocount++;

        }
        return result;
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
            result[i+1]=sum%10;
        }
        result[0]=carry;
        return result;
    }

    private static int[] resizeToLarger(int[] smaller,int size) {
        if (smaller.length >= size){
            return smaller;
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
