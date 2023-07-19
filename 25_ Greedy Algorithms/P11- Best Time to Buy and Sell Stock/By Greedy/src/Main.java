
//                                                        Best Time to Buy and Sell Stock


/*
Question :- Given an array prices[] of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible for buying and selling the stocks on different days
            using transactions where at most one transaction is allowed.

Note :- Stock must be bought being sold.


Sample Input 1 : prices[] = {7, 6, 4, 3, 1}
Sample Output 1 : 0

Sample Input 1 : prices[] = {7, 1, 5, 3, 6, 4}
Sample Output 1 : 5
 */

/*
Time Complexity :- O(n)
Space Complexity :- O(1)
 */

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size = sc.nextInt();
        int[] prices = new int[size];
        for(int i=0;i<size;i++){
            prices[i] = sc.nextInt();
        }
        System.out.println("Maximum Profit :- "+optimalSolution(prices,size));
    }

    private static int optimalSolution(int[] prices, int size) {
        int buy = prices[0]; // Assume the first price is the initial buying price
        int max_profit = 0; // Initialize the maximum profit to 0
        for(int i = 1; i < size; i++) { // Iterate through the prices array starting from index 1
            if(buy > prices[i]) {
                buy = prices[i]; // If the current price is lower than the buying price, update the buying price
            } else if ((prices[i] - buy) > max_profit) {
                max_profit = prices[i] - buy; // If the difference between the current price and buying price is greater than the current maximum profit, update the maximum profit
            }
        }
        return max_profit; // Return the maximum profit
    }
}