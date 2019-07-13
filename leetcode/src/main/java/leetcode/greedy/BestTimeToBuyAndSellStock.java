package leetcode.greedy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }

        int min = prices[0];
        int res = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]-min>res){
                res = prices[i]-min;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return res;
    }
}
