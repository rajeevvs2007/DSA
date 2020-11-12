package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 6/25/20.
 * Let’s say you have to climb N steps. You can jump 1 step, 3 steps or 5 steps at a time.
 * How many ways are there to get to the top of the steps
 */
public class ClimbingSteps {

    public static void main(String[] args) {
        int numberOfWays = climbSteps(8);
        System.out.println("Number of ways " + numberOfWays);
         numberOfWays = topdown(8);
        System.out.println("Number of ways topdown" + numberOfWays);

    }

    public static Map<Integer,Integer> mem = new HashMap<Integer,Integer>();

    private static int climbSteps(int n) {
        int numSteps = 0;
        int[] a = new int[n+1];
        a[0] = 1;

        for (int i=0;i<a.length;i++){
           if(i+1 < a.length){
               a[i+1] = a[i+1] + a[i];
           }
           if (i+3 < a.length){
               a[i+3] = a[i+3] + a[i];
           }
            if (i+5 < a.length){
                a[i+5] = a[i+5] + a[i];
            }
        }
        numSteps = a[n];

        return numSteps;
    }


    private static int topdown(int n){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        int numofsteps = 0;
        if (mem.containsKey(n)) {
            numofsteps = mem.get(n);
        } else {
            numofsteps = topdown(n-3) + topdown(n-5) + topdown(n-1);
            mem.put(n,numofsteps);
        }
        return numofsteps;

    }


}
