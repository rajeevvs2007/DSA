package DP;

/**
 * Created by tkmaab4 on 6/29/20.
 * Number of ways we can make a change for $5 from coins $1,$2,$3
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins  = {1,2,3};
        int target = 5;

        System.out.println("2D array " + makeWays(coins,target));
        System.out.println("1D array " + bottomUpWith1D(coins,target));

    }

    private static int makeWays(int[] coins, int target) {
        int numOfWays = 0;
        int[][] waysTab = new int[coins.length][target+1];
        for (int i=0;i<coins.length;i++){
            for (int j=0;j<=target;j++){
                if (j == 0){
                    waysTab[i][j] = 1;// No of ways to make $0 can be assumed as 1 way.
                } else if (coins[i] > j){
                    waysTab[i][j] = i==0 ? 0:waysTab[i-1][j];
                } else {
                    waysTab[i][j] = ((i-1 >=0)? waysTab[i-1][j]:0) + waysTab[i][j-coins[i]];
                }
                numOfWays  = waysTab[i][j];
            }
        }
        return numOfWays;

    }

    //ToDo
    private static int minWays(int[] coins, int target) {
        int numOfWays = 0;
        int[][] waysTab = new int[coins.length][target+1];
        for (int i=0;i<coins.length;i++){
            for (int j=0;j<=target;j++){
                if (j == 0){
                    waysTab[i][j] = 1;// No of ways to make $0 can be assumed as 1 way.
                } else if (coins[i] > j){
                    waysTab[i][j] = i==0 ? 0:waysTab[i-1][j];
                } else {
                    waysTab[i][j] = Math.min(((i-1 >=0)? waysTab[i-1][j]:Integer.MAX_VALUE) , waysTab[i][j-coins[i]]);
                }
                numOfWays  = waysTab[i][j];
            }
        }
        return numOfWays;

    }

    private static int bottomUpWith1D(int[] coins, int target){
        int numWays = 0;
        int[] total = new int[target+1];
        total[0] = 1;
        for (int amount : total){
            for (int coin : coins) {

            }
        }

        return numWays;
    }
}
