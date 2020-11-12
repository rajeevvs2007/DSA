package queue;

import java.util.*;
import java.util.Queue;

/**
 * Created by tkmaab4 on 4/16/20.
 * You are given stock prices and the corresponding day of each stock price as an input stream. For example:

 (32, 1), (45, 1), (37,2), (42,3) ...

 Here 32 is the price and 1 is the day of the price. Your system should be able to tell the maximum stock price
 in the last 3 days.
 */
public class StockPrice {

    public static void main(String[] args){
        Stock[] stockPriceArray = constructStockPrice();
        java.util.Queue<Stock> stockQueue = new LinkedList<>();

        for(Stock stock:stockPriceArray){
            addStockToQueue(stockQueue,stock);

        }

        findMaxStockPrice(stockQueue);

    }

    private static void findMaxStockPrice(Queue<Stock> stockQueue) {

        Iterator<Stock> iterator = stockQueue.iterator();
        int max=0;
        while(iterator.hasNext()){
            if (max< iterator.next().getPrice()) {
                max=iterator.next().getPrice();
            }
        }
        System.out.println("Max stock "+ max);
    }

    private static void addStockToQueue(Queue<Stock> stockQueue, Stock stock) {
        while(!stockQueue.isEmpty() && stockQueue.peek().getDay() < (stock.getDay() -3+1)){
            stockQueue.remove();
        }
        stockQueue.add(stock);
    }

    private static Stock[] constructStockPrice() {
        Stock[] stockPrice = new Stock[6];
        stockPrice[0] = new Stock(1,31);
        stockPrice[1] = new Stock(2,32);
        stockPrice[2] = new Stock(2,33);
        stockPrice[3] = new Stock(3,34);
        stockPrice[4] = new Stock(3,35);
        stockPrice[5] = new Stock(4,33);


        return stockPrice;
    }

    private static class Stock{
        int day;
        int price;

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }



        Stock(int day, int price) {
            this.day=day;
            this.price=price;
        }


    }

}
