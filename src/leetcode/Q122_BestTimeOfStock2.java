package leetcode;

/**
 * Created by GuoWeiyu on 2017/08/12.
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Q122_BestTimeOfStock2 {
    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buyPrice = Integer.MAX_VALUE;
        int maxSellPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (Integer price : prices) {
            // 出现下降，计算当前值
            if (price < maxSellPrice) {
                ans += (maxSellPrice - buyPrice);
                buyPrice = price;
            }
            maxSellPrice = price;
        }
        ans += (maxSellPrice - buyPrice);
        return ans;
    }
}
