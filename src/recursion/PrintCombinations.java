package recursion;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 6/14/20.
 */
public class PrintCombinations {


    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        // printCombination(input,new int[3],0,0);
        printCombo(input,new int[3],0,0);
    }

    private static void printCombo(int[] a, int[] result, int index,int resultIndex) {

        if (result.length == resultIndex){
            printarray(result);
            return;
        }

        for (int i=index; i < a.length; i++){
            result[resultIndex] = a[i];
            printCombo(a,result,i+1,resultIndex+1);
        }

    }

    static void printCombination(int[] a, int[] x, int startIndex, int bufferIndex) {

        //basecase
        if (x.length == bufferIndex) {
            printarray(x);
            return;
        }

        if (startIndex == a.length) {
            return;
        }

        for (int i = startIndex; i < a.length; i++) {
            x[bufferIndex] = a[i];
            printCombination(a, x, i + 1, bufferIndex + 1);
        }


 }

         static void printarray(int[] bufferArray){
 System.out.println(Arrays.toString(bufferArray));
 }
}
