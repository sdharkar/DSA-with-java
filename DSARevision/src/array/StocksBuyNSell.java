package array;
//1. Find the maximum profit by buying and selling a stock once.
//2. Find the maximum profit by buying and selling a stock multiple times.
//3. Find the maximum profit by buying and selling a stock at most kth times.
//Time Complexity: O(n)
//Space Complexity: O(1)

public class StocksBuyNSell {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Single Transaction: " + maxProfitSingleTransaction(prices));

        System.out.println("Optimized Single Transaction: " + optimizedMaxProfitSingleTransaction(prices));

        System.out.println("Multiple Transactions: " + maxProfitMultipleTransactions(prices));

        int k = 2;
        System.out.println("At most " + k + " transactions: " + maxProfitAtMostKthTransactions(prices, k));

    }

    //Single Transaction
    // Approach:Track the minimum price so far and calculate the profit at each step. Update the maximum profit accordingly.
    // Algorithm:
    // 	1.	Initialize:
    // 	•	minPrice = Integer.MAX_VALUE
    // 	•	maxProfit = 0
    // 	2.	Iterate through the array of prices:
    // 	•	Update minPrice to the smallest value seen so far.
    // 	•	Calculate the current profit as price[i] - minPrice.
    // 	•	Update maxProfit if the current profit is greater than maxProfit.
    public static int maxProfitSingleTransaction(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {//If the current price is less than the minimum price
                minPrice = price;
            } else if (price - minPrice > maxProfit) {//If the difference between the current price and the minimum price is greater than the maximum profit
                maxProfit = price - minPrice;//Update the maximum profit
            }
        }
        return maxProfit;
    }

    //optimized
    public static int optimizedMaxProfitSingleTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

//Multiple Transactions
// Problem:Maximize profit by buying and selling multiple times. You cannot hold more than one stock at a time.
// Approach:Add the positive differences between consecutive prices.
// Algorithm:
//     1.	Iterate through the prices:
//     •	If price[i] > price[i-1], add price[i] - price[i-1] to the profit.
    public static int maxProfitMultipleTransactions(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {//If the current price is greater than the previous price
                maxProfit += prices[i] - prices[i - 1]; //Add the difference between the current price and the previous price to the maximum profit
            }
        }
        return maxProfit;
    }

    //At most kth transactions
// Problem:Maximize profit with at most k transactions.
// Approach:Use Dynamic Programming. Let dp[i][j] represent the maximum profit using at most i transactions up to day j.
// Algorithm:
// 	1.	Initialize a dp[k+1][n] array.
// 	2.	Base cases:
// 	•	dp[0][j] = 0 (0 transactions yield 0 profit).
// 	•	dp[i][0] = 0 (No days yield 0 profit).
// 	3.	For each transaction i and day j:
// 	•	Compute the maximum profit by:
// 	•	Not transacting: dp[i][j-1].
// 	•	Transacting: Maximize (prices[j] - prices[m] + dp[i-1][m]) for all m < j.
// 	4.	Optimize by storing a running max of (dp[i-1][m] - prices[m]).
    public static int maxProfitAtMostKthTransactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            return maxProfitMultipleTransactions(prices);//If k is greater than half the length of the array, return the maximum profit using multiple transactions
        }
        int[][] dp = new int[k + 1][n];//Create a 2D array of size k+1 x n

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];//Initialize the maximum difference with the first price
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);//Update the maximum profit
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);//Update the maximum difference
            }
        }
        return dp[k][n - 1];
    }

}
