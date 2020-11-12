package sortiing;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 5/25/20.
 */
public class SortFile {

    public static void main(String[] args) {

        File inputFile = new File("/Users/tkmaab4/Documents/InputFile.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            Map<Integer,char[]> lineMap = new HashMap<Integer,char[]>();
            String st;
            int counter = 0;
            while((st = bufferedReader.readLine()) != null) {
               lineMap.put(counter,st.toCharArray());
               counter++;
            }

            int[] lineArray = new int[lineMap.size()];

            int i = 0;
            for (Integer key : lineMap.keySet()) {
                lineArray[i] = key;
                i++;
            }

            performQuickSort(lineArray,lineMap,0,lineArray.length-1);

            for (i=0; i < lineArray.length; i++) {
                System.out.println(lineMap.get(lineArray[i]));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void performQuickSort(int[] lineArray, Map<Integer, char[]> lineMap, int start , int end) {
        if (start >= end) {
            return;
        }
        int pIndex = partition(lineArray,lineMap,start,end);
        performQuickSort(lineArray,lineMap,start,pIndex-1);
        performQuickSort(lineArray,lineMap,pIndex+1,end);

    }

    private static int partition(int[] lineArray, Map<Integer, char[]> lineMap, int start, int end) {
        int pivot = lineMap.get(lineArray[end])[0];
        int k = start;
        for (int i = start ; i < end; i ++) {
        if (lineMap.get(lineArray[i])[0] < pivot) {
            swap(lineArray,i,k);
            k++;
        }else if (lineMap.get(lineArray[i])[0] == pivot) {
            int j = 0;
            int l = 0;
            boolean matchNotFound = false;
            while (j <  lineMap.get(lineArray[i]).length && l < lineMap.get(lineArray[end]).length) {
                if (lineMap.get(lineArray[i])[j] != lineMap.get(lineArray[end])[l]) {
                    matchNotFound = true;
                    break;
                }
                j++;
                l++;
            }
            if (matchNotFound && lineMap.get(lineArray[i])[j] < lineMap.get(lineArray[end])[l]) {
                swap(lineArray,i,k);
                k++;
            }
        }
        }

        swap(lineArray,k,end);
        return k;
    }
    private static void swap(int[] a, int i, int k) {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
