
/*
                                                Longest Subarray with sum K | [Postives and Negatives]


Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
Result: 3
Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.
 */
/*
Optimal Approach (Using Hashing):
Approach:
The steps are as follows:

~ First, we will declare a map to store the prefix sums and the indices.
~ Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
~ For each index i, we will do the following:
        @  We will add the current element i.e. a[i] to the prefix sum.
        @  If the sum is equal to k, we should consider the length of the current subarray i.e. i+1. We will compare this length with the existing length and consider the maximum one.
        @  We will calculate the prefix sum i.e. x-k, of the remaining subarray.
        @  If that sum of the remaining part i.e. x-k exists in the map, we will calculate the length i.e. i-preSumMap[x-k], and consider the maximum one comparing it with the existing length we have achieved until now.
        @  If the sum, we got after step 3.1, does not exist in the map we will add that with the current index into the map. We are checking the map before insertion because we want the index to be as minimum as possible and so we will consider the earliest index where the sum x-k has occurred. [Detailed discussion in the edge case section]
  In this approach, we are using the concept of the prefix sum to solve this problem. Here, the prefix sum of a subarray ending at index i, simply means the sum of all the elements of that subarray.
 */


/*
Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
               Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an element and the time complexity becomes O(N2)) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.

Space Complexity: O(N) as we are using a map data structure.
 */



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[]array = new int[size];
        System.out.print("Enter the value one by one :-");
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the value of 'K' :- ");
        int K = sc.nextInt();
        System.out.println("The length of the longest subarray is: "+optimalApproach(array,K));
    }

    private static int optimalApproach(int[] array, int k) {
        int n = array.length;
        Map<Integer,Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i<n ;i++){
            //calculate the prefix sum till index i:
            sum += array[i];

            //if the sum = k, update the maxLen:
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            // calculate the length and update maxLen:
            if(preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum,i);
            }
        }
        return maxLen;
    }
}