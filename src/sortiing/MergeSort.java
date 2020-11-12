package sortiing;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 5/20/20.
 */
public class MergeSort {

    public static void main(String[] args) {
        int a[] = {2,8,9};
        int b[] = {3,4,7};
        int input[] = {2,9,8,3,4,7};

        int output[] = mergeSort(input);


        System.out.println("Result "+ Arrays.toString(output));

    }

    private static int[] mergeSort(int[] input) {
        if (input == null || input.length == 1) {
            return input;
        }
        int start =0;
        int end = input.length-1;
        int mid = start + end-start/2;

        mergeSort(input,0,end);

        return input;
    }

    private static void mergeSort(int[] input, int start, int end) {

        if(start >= end) {
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);
        merge(input,start,mid,end);



    }

    private static void merge(int[] input, int start, int mid, int end) {
        int i= start;
        int j = mid +1 ;
        int k = 0;
        int[] result = new int[end-start+1];
        while (i <= mid && j <= end){
            if (input[i] < input[j]) {
                result[k++] = input[i++];
            } else {
                result[k++] = input[j++];
            }
        }

        while (i<=mid){
            result[k++] = input[i++];
        }

        while (j<=end){
            result[k++] = input[j++];
        }

        for(int c=0;c<k;c++) {
            input[start+c] = result[c];
        }
    }




}
