package leetcode;

/**
 * Created by GuoWeiyu on 2017/08/12.
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class Q123_BestTimeOfStock3 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        // null处理
        int k = 2;        // k次交易
        int length = prices.length;
        // [i][j] -> 前i次交易且最后一个交易数字是第j个数字构成的最大值
        int[][] local = new int[k + 1][length + 1];
        // [i][j] -> 前i次交易且前j个数字构成的最大值
        int[][] global = new int[k + 1][length + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= length; j++) {
                int diff=prices[j]-prices[j-1];
                local[i][j] = Math.max(global[i - 1][j - 1] + diff > 0 ? diff : 0, local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[k][length];
    }
}
