
//                                                           Find minimum number of coins (Indian Coins )
//                                               [ greedy algorithm applicable only when canonical coin system are given ]

/*
Find minimum number of coins
Problem Statement:
Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency,
i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

Examples:

Example 1:

Input: V = 70

Output: 2

Explanation: We need a 50 Rs note and a 20 Rs note.

Example 2:

Input: V = 121

Output: 3

Explanation: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
 */

/*
:- Solution -: (Greedy Algorithm)
Approach: We will keep a pointer at the end of the array i.
Now while(V >= coins[i]) we will reduce V by coins[i] and add it to the ans array.
We will also ignore the coins which are greater than V and the coins which are less than V.
We consider them and reduce the value of V by coins[I].
 */

/*
Time Complexity  :- O(V)
Space Complexity :- O(1)
 */




import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] indianCoins = {2000,500,100,50,20,10,5,2,1};
        System.out.print("Enter the Amount :- ₹");
        int value = sc.nextInt();
        System.out.println("Minimum No Of Coins/Notes To make Change for a '₹"+value+"' :- "+minimumNumber(indianCoins,value));
    }

    private static int minimumNumber(int[] indianCoins, int value) {
        int count=0;
        int amount = value;
        System.out.print("The Coins/Notes are  :- ");
        for(int i=0;i<indianCoins.length;){
            if(indianCoins[i]<=amount){
                count++;
                amount-=indianCoins[i];
                System.out.print("[ ₹"+indianCoins[i]+" ]");
            }
            else{
                i++;
            }
        }
        System.out.println();
        return count;
    }
}