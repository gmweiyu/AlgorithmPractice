package leetcode;

/**
 * Created by GuoWeiyu on 2017/08/12.
 * Description:
 */
public class Q121_BestTimeOfStock {
    public static void main(String[] args) {
        int[] prices={7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (Integer price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                ans = Math.max(ans, price - buyPrice);
            }
        }
        return ans;
    }
}
