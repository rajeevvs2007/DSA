package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tkmaab4 on 6/14/20.
 */
public class PrintAllSubsets {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
       findAllCombinations(input,result,0, new ArrayList<Integer>());

     }

    private static void findAllCombinations(int[] a, List<List<Integer>> result, int startIndex, ArrayList<Integer> subset) {
        result.add(new ArrayList<>(subset));
        System.out.println(Arrays.toString(result.toArray()));
        for (int i = startIndex; i< a.length;i++){
            subset.add(a[i]);
            findAllCombinations(a,result,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}
