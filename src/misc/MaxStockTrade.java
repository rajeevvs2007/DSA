package misc;

/**
 * Created by tkmaab4 on 4/19/20.
 * (Level: Medium) Given a list of stock prices for a company, find the maximum amount of money you
 * could have made with one trade (one buy/sell). For example, if A = [2,3,1,4,5,7,5,4],
 * the max money with a single trade is 6, if you buy at 1 and sell at 7.
 */
public class MaxStockTrade {

    public static void main(String[] args){

        int[] stock={2,3,1,4,5,7,5,4};
        findMaxTrade(stock);

    }

    /**
     * At any point max trade is price at that point minus min price so far
     * @param stock
     */
    private static void findMaxTrade(int[] stock) {
        if (stock == null || stock.length < 2) {
            return;
        }
        int minSoFar = Integer.MAX_VALUE;
        int maxTrade = 0;
        for(int i : stock){
            minSoFar = Math.min(i,minSoFar);
            maxTrade = Math.max(i-minSoFar,maxTrade);
        }
        System.out.println("MaxTrade  " +maxTrade);
    }

}
