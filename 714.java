class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0; // Represents the maximum profit when not holding any stock
        int hold = -prices[0]; // Represents the maximum profit when holding a stock

        for (int i = 1; i < n; i++) {
            int prevCash = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, prevCash - prices[i]);
        }

        return cash;
    }
}
