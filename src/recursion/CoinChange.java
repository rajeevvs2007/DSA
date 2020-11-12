package recursion;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tkmaab4 on 6/14/20.
 * Coin Change Problem: Given a set of coin denominations, print out the different ways you can make a target amount.
 * You can use as many coins of each denomination as you like.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {3,2,5};
        int target = 4;
        printCoins(coins,target,new Stack<Integer>(),0,0);

    }

    private static void printCoins(int[] coins, int target,Stack<Integer> buffer, int sum, int startindex) {
        if (sum > target){
            return;
        }

        if (sum == target){
            printarray(buffer);
            return;
        }

        for (int i=startindex;i<coins.length;i++){
            buffer.push(coins[i]);
            printCoins(coins,target,buffer,sum+coins[i],i);
            buffer.pop();
        }

    }



    static void printarray(Stack<Integer> buffer){
        System.out.println(Arrays.toString(buffer.toArray()));
    }
}
