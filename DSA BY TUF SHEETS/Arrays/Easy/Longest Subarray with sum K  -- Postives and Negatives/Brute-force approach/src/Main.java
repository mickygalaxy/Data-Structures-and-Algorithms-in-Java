
/*
                                                Longest Sub array with sum K | [Positives and Negatives]


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
:- Approach -:

The steps are as follows:

~ First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
~ Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
~ Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j].
~ If the sum is equal to k, we will consider its length i.e. (j-i+1). Among all such subarrays with sum k, we will consider the one with the maximum length by comparing all the lengths.
 */
/*
Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

@ Assume previous subarray = arr[i……j-1]
@ current subarray = arr[i…..j]
@ Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving the j pointer, we can calculate the sum.

[*]~~ Note: For a better understanding of intuition, please watch the video at the bottom of the page.
 */

/*
Time Complexity: O(N2) approx., where N = size of the array.
Reason: We are using two nested loops, each running approximately N times.

Space Complexity: O(1) as we are not using any extra space.
 */



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
        long K = sc.nextLong();
        System.out.println("The length of the longest subarray is: "+bruteForceApproach(array,K));
    }

    private static int bruteForceApproach(int[] array, long k) {
        int n = array.length;
        int length = 0;
        for(int i=0;i<n;i++){ // starting index
            int sum = 0;
            for(int j=i;j<n;j++){ // ending index
                // add the current element to
                // the subarray a[i...j-1]:

                sum+= array[j];
                if(sum == k){
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return length;
    }
}