package algorithm;

/**
 * 买卖股票问题
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * https://leetcode.com/pguodongroblems/best-time-to-buy-and-sell-stock-ii/description/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @Author:
 * @Date: 2018/12/9
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {

        int count = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<prices[i+1]){
                count = count + (prices[i+1] - prices[i]);
            }
        }
        return count;
    }


    /**
     * best-time-to-buy-and-sell-stock-iii
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {

        // TODO

        return 1;
    }
}
