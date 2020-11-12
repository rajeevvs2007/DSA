package misc;

/**
 * Created by tkmaab4 on 4/19/20.
 * Given a list of stock prices for a company, find the maximum amount
 * of money you can make with two trades.
 * A trade is a buy and sell.The two trades cannot overlap.
 */
public class MaxStockPriceTwoTrade {

    public static void main(String[] args) {

        int[] stock={2,3,1,4,5,7,5,4};
        findMaxIn2Trades(stock);

    }

    /**
     * Find best trade till any index and best trade after that index
     * @param stock
     * @return
     */
    private static int findMaxIn2Trades(int[] stock) {

        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = 0;
        // Divide the array two 2 regions ,one till Index I and one after index I
        // find Max at I
        int[] bestTrade_Till_I = new int[stock.length];
        for (int i = 0; i<stock.length ; i++){
            minSoFar = Math.min(minSoFar,stock[i]);
            maxDiff = Math.max(maxDiff,stock[i] - minSoFar);
            bestTrade_Till_I[i] = maxDiff;
        }


        // find Max drop
        int[] bestTrade_From_I = new int[stock.length];
        int maxSoFar = 0;
        for (int i = stock.length-1 ; i>=0; i--){
            maxSoFar = Math.max(stock[i],maxSoFar);
            maxDiff = Math.max(maxDiff, maxSoFar-stock[i]);
            bestTrade_From_I[i]=maxDiff;
        }
        int best_2trade = Integer.MIN_VALUE;

        for (int i=0; i<stock.length;i++){
            int maxSecondTrade = (i+1 < stock.length) ? bestTrade_From_I[i+1] :0;
            best_2trade = Math.max(best_2trade,bestTrade_Till_I[i] + bestTrade_From_I[i+1]);
        }

        return best_2trade;

    }
}
