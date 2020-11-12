package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tkmaab4 on 6/26/20.
 * Longest Increasing Subsequence: Given an array of integers, find the length of the longest
 * increasing subsequence.
 * For e.g, in [1, 3, 2, 5, 3, 5, 6], the longest increasing subsequence is [1, 2, 3, 5, 6] of length 5.
*/
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {1,3,2,5,3,5,6};
        Arrays.sort(a);
        Set<Integer> map = new HashSet<>();
        for (int i=0;i<a.length;i++){
            map.add(a[i]);
        }

        System.out.println(Arrays.toString(a));
        System.out.println("Longest increasing subsequence" + map.size());
    }
}
