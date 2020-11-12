package arrays;


import com.sun.tools.javac.util.Pair;

import java.util.HashMap;

/**
 * Created by tkmaab4 on 3/20/20.
 * Given an array of integers, find the contiguous subarray that sums to 0.
 * The array can contain both negative and positive integers.
 */
public class PrefixSum {

    public static void main(String[] args) {
        int[] input = {2,4,-2,1,-3,5,-3};
        int target=0;
        int sum = 0;
        Pair<Integer,Integer> resultPair = new Pair<>(0,0);
        for (int i=0;i<input.length;i++){
            sum=input[i];
            for(int j=i+1;j<input.length;j++){
                sum = sum + input[j];
                if (sum == target) {
                    resultPair = new Pair<>(input[i],input[j]);
                    break;
                }
            }
            if (sum == target) {
                break;
            }
        }
        System.out.println("resultPair " + resultPair);
        System.out.println("continousArray " + continousArray(input));
    }


    public static Pair continousArray(int [] input) {
        int sum=0;
        int target = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<input.length;i++){
            sum = sum + input[i];
            if (sum == target) {
                return new Pair(0,i);
            }else if (map.containsValue(sum)){
                return new Pair(map.get(sum) + 1, i);
            }
            map.put(sum,i);
        }
        return null;
    }
}
