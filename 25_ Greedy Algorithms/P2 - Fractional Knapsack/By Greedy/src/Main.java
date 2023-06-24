
//                                            " fractional knapsack Problem  (By Greedy Approach) "

//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*
Given the weights and profits of N items, in the form of {profit, weight} put these items in a knapsack of capacity W to get the maximum total profit in the knapsack. In Fractional Knapsack, we can break items for maximizing the total value of the knapsack.

Input: arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
Output: 240
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg.
Hence, total price will be 60+100+(2/3)(120) = 240

Input:  arr[] = {{500, 30}}, W = 10
Output: 166.667
 */
//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*

-: An efficient solution is to use the Greedy approach :-

The greedy solution for the fractional knapsack problem works by sorting the items by their profit-to-weight ratio and then adding the items to the knapsack in decreasing order of their ratio.
This ensures that we always add the items that will give us the most profit per unit of weight.
This will always give the maximum profit because, in each step it adds an element such that this is the maximum possible profit for that much weight.
 */
//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*

Illustration:

Check the below illustration for a better understanding:

Consider the example: arr[] = {{100, 20}, {60, 10}, {120, 30}}, W = 50.

Sorting: Initially sort the array based on the profit/weight ratio. The sorted array will be {{60, 10}, {100, 20}, {120, 30}}.

Iteration:

For i = 0, weight = 10 which is less than W. So add this element in the knapsack. profit = 60 and remaining W = 50 – 10 = 40.
For i = 1, weight = 20 which is less than W. So add this element too. profit = 60 + 100 = 160 and remaining W = 40 – 20 = 20.
For i = 2, weight = 30 is greater than W. So add 20/30 fraction = 2/3 fraction of the element. Therefore, profit = 2/3 * 120 + 160 = 80 + 160 = 240 and remaining W becomes 0.
So the final profit becomes 240 for W = 50.

-------------------------------------------------------------------------------------------------------------------------------------------------------
@~ Follow the given steps to solve the problem using the above approach ~@

Calculate the ratio (profit/weight) for each item.
Sort all the items in decreasing order of the ratio.
Initialize res = 0, curr_cap = given_cap.
Do the following for every item i in the sorted order:
If the weight of the current item is less than or equal to the remaining capacity then add the value of that item into the result
Else add the current item as much as we can and break out of the loop.
Return res.
-------------------------------------------------------------------------------------------------------------------------------------------------------

 */
//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*
Time Complexity:

The loop that calculates the ratios for each item runs for totalItems iterations, resulting in a time complexity of O(totalItems).
The sorting operation using Arrays.sort takes O(totalItems * log(totalItems)) time complexity.
The final loop that iterates over the sorted ratios runs for totalItems iterations, resulting in a time complexity of O(totalItems).
Therefore, the overall time complexity of the method can be approximated as O(totalItems * log(totalItems)).

Space Complexity:

The 2D array ratios is created to store the item indices and ratios. It has a size of totalItems rows and 2 columns, resulting in O(totalItems) space complexity.
Other variables like maximumTotalValue, ratio, and loop variables occupy constant space, so they can be ignored.
Therefore, the overall space complexity of the method can be approximated as O(totalItems).

In summary, the time complexity of the method is O(totalItems * log(totalItems)), and the space complexity is O(totalItems).
 */
//-------------------------------------------------------------------------------------------------------------------------------------------------------
// Time Complexity  :- O(n * log(n))    # where n is total_Items.
// Space Complexity :- O(n)
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                             " IMPLEMENTATION "
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.print("Enter the total Items :- ");
        int totalItems = sc.nextInt();    // this variable store total items.
        int[] values = new int[totalItems];  // this array store Items cost or value.
        int[] weights = new int[totalItems]; // this array store Items weights.
        System.out.println("-: Enter the Items Values :- ");
        setItemsData(values,totalItems);   // set the value of Item.
        System.out.println("-: Enter the Items Weights :- ");
        setItemsData(weights,totalItems);  // set the weight of Item.
        System.out.println("-: Enter The Total Knapsack Capacity :- ");
        int capacity = sc.nextInt();      // this variable store total "Knapsack capacity. "
        int maximumTotalValue = optimalSolution(values,weights,totalItems,capacity);  // this function give total Maximum profit or total value . after then maximumTotalValue variable store this maximum value.
        System.out.println(maximumTotalValue); // print the maximumTotalValue.
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    private static int optimalSolution(int[] values, int[] weights, int totalItems, int capacity) {

        int maximumTotalValue= 0; // Variable to store the maximum total value.
        int totalCapacity = capacity;
        int[][] ratios = new int[totalItems][2]; // 2D array to store item indices and their corresponding ratios.

        // Calculate and store the ratio (value/weight) for each item.
        for(int i=0;i<totalItems;i++){
            int ratio = (values[i]/weights[i]); // Calculate the ratio.
            ratios[i][0] = i; // Store the item index.
            ratios[i][1] = ratio; // Store the ratio.
        }


        // Sort the ratios in descending order using a lambda expression as the comparator.
        Arrays.sort(ratios, (o1, o2) -> Integer.compare(o2[1], o1[1]));                                //      " OR "  sorting by Ascending order
                                                                                                      // Sort the ratios in ascending order using a lambda expression as the comparator.
                                                                                                     //  Arrays.sort(ratios,Comparator.comparing(o->o[1]));


        // Iterate over the sorted ratios starting from the highest ratio.
        for (int i = 0; i < totalItems; i++) {                                                    // or  for(int i= totalItems-1;i>=0;i--)
            int itemIndex = ratios[i][0];
            int itemRatio = ratios[i][1];
            // Check if the weight of the current item is less than the remaining capacity.
            if(weights[itemIndex]<totalCapacity){
                maximumTotalValue+=values[itemIndex]; // Add the value of the current item to the maximum total value.
                totalCapacity-=weights[itemIndex]; // Reduce the total capacity by the weight of the current item.
            }else{
                maximumTotalValue = (maximumTotalValue + (itemRatio*totalCapacity));
                // Calculate the partial value based on the ratio and remaining capacity.
                // totalCapacity -= weights[ratios[i][0]]; // Reduce the total capacity by the weight of the current item.
                //totalCapacity = 0;
                break;
            }
        }
        return maximumTotalValue; // Return the maximum total value.
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------

    private static void setItemsData(int[] Item, int totalItems) { // this function for take data by user at a runtime.
         for(int i=0;i<totalItems;i++){
             Item[i] = sc.nextInt();
         }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
}

/*
The code follows a greedy approach where it sorts the items based on their value-to-weight ratios.
It then iterates over the sorted ratios, selecting items as long as their weight does not exceed the remaining capacity.
If an item's weight is greater than the remaining capacity, a partial value is calculated based on the ratio and the remaining capacity.
The final result returned is the maximum total value achievable by selecting the items while considering their values, weights, and the total capacity constraint.
 */