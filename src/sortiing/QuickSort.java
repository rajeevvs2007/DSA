package sortiing;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tkmaab4 on 5/21/20.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input  = {8,5,1,3,4,2,7,6};

        //doPartition(input,0,input.length-1);

        quickSort(input,0,input.length-1);

        System.out.println("After partition " + Arrays.toString(input));
    }

    private static void quickSort(int[] input, int start,int end) {
        while (start >= end) {
            return;
        }
        int pIndex = doPartition(input,start,end);
        quickSort(input,start,pIndex-1);
        quickSort(input,pIndex+1,end);
    }

    public static int doPartition(int[] a, int start, int end) {
        int randomIndex = start +  new Random().nextInt(end-start +1);
        swap(a,randomIndex,end);
        int pivot = a[end];

        int k = start;
        for (int i=start;i<end;i++){
//            if(i==k){
//                continue;
//            }

            if(a[i] <= pivot) {
                swap(a,i,k);
                k++;
            }
        }

        swap(a,k,end);
        return k;
    }

    private static void swap(int[] a, int i, int k) {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
