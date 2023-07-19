
/*
                                                   Longest Subarray with given Sum K(Positives)

Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
Result: 3
Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
 */
/*
                     ~~~~ Better Approach(Using Hashing) ~~~~
Approach:-

The steps are as follows:
# First, we will declare a map to store the prefix sums and the indices.
# Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
# For each index i, we will do the following:
  @ We will add the current element i.e. a[i] to the prefix sum.
  @ If the sum is equal to k, we should consider the length of the current subarray i.e. i+1. We will compare this length with the existing length and consider the maximum one.
  @ We will calculate the prefix sum i.e. x-k, of the remaining subarray.
  @ If that sum of the remaining part i.e. x-k exists in the map, we will calculate the length i.e. i-preSumMap[x-k], and consider the maximum one comparing it with the existing length we have achieved until now.
  @ If the sum, we got after step 3.1, does not exist in the map we will add that with the current index into the map. We are checking the map before insertion because we want the index to be as minimum as possible and so we will consider the earliest index where the sum x-k has occurred. [Detailed discussion in the edge case section]
~In this approach, we are using the concept of the prefix sum to solve this problem. Here, the prefix sum of a subarray ending at index i, simply means the sum of all the elements of that subarray.

Observation: Assume, the prefix sum of a subarray ending at index i is x. In that subarray, we will search for another subarray ending at index i, whose sum equals k. Here, we need to observe that if there exists another subarray ending at index i with sum k, then the prefix sum of the rest of the subarray will be x-k. The below image will clarify the concept:

Now, for a subarray ending at index i with the prefix sum x, if we remove the part with the prefix sum x-k, we will be left with the part whose sum is equal to k. And that is what we want.

That is why, instead of searching the subarrays with sum k, we will keep track of the prefix sum of the subarrays generated at every index using a map data structure.

In the map, we will store every prefix sum calculated, with its index in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the index i.e. preSumMap[x-k] where the subarrays with the prefix sum x-k occur. Then we will simply subtract the index i.e. preSumMap[x-k] from the current index i to get the length of the subarray i.e. len = i -preSumMap[x-k].

We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

Edge Case: Why do we need to check the map if the prefix sum already exists? In the algorithm, we have seen that at step 3.4, we are checking the map if the prefix sum already exists, and if it does we are not updating it. Let’s understand the reason by considering the following example:
Assume the given array is {2, 0, 0, 3}. If we apply the algorithm to the given array without checking, it will be like the following:


In steps 2 and 3 the element at index i is 0. So, in those steps, the prefix sum remains the same but the index is getting updated in the map. Now, when index i reaches the end, it calculates the length i.e. i-preSumMap[rem] = 3-2 = 1. Here it is considering only the subarray [3] which is incorrect as the longest subarray we can get is [0, 0, 3] and hence the length should be 3.

Now, to avoid this edge case i.e. to maximize the calculated length, we need to observe the formula we are using to calculate the length i.e. len = i – preSumMap[rem].

Now, if we minimize the term preSumMap[rem] (i.e. the index where the subarray with sum x-k ends), we will get the maximum length. That is why we will consider only the first or the leftmost index where the subarray with sum x-k ends. After that, we will not update that particular index even if we get a similar subarray ending at a later index.

So, we will check the map before inserting the prefix sum. If it already exists in the map, we will not update it but if it is not present, we will insert it for the first time.
 */
/*
Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an element and the time complexity becomes O(N2)) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.

Space Complexity: O(N) as we are using a map data structure.
 */

import java.util.*;
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
        long K = sc.nextLong();
       System.out.println("The length of the longest subarray is: "+getLongestSubarray(array,K));
    }

    private static int getLongestSubarray(int[] array,long k) {
        int n = array.length; // size of the array

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += array[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
