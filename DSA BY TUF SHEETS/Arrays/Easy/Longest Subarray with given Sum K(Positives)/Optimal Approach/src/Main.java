
//                                                   Longest Subarray with given Sum K(Positives)
//
// Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
//
//  Examples 1:
//    Input Format: N = 3, k = 5, array[] = {2,3,5}
//    Result: 2
//    Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
//
//   Example 2:
//     Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
//     Result: 3
//     Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
/*
Approach:
The steps are as follows:

1) First, we will take two pointers: left and right, initially pointing to the index 0.
2) The sum is set to a[0] i.e. the first element initially.
3) Now we will run a while loop until the right pointer crosses the last index i.e. n-1.
4) Inside the loop, we will do the following:
     1) We will use another while loop, and it will run until the sum is lesser or equal to k.
         Inside this second loop, from the sum, we will subtract the element that is pointed by the left pointer and increase the left pointer by 1.
     2) After this loop gets completed, we will check if the sum is equal to k. If it is, we will compare the length of the current subarray i.e. (right-left+1) with the existing one and consider the maximum one.
     3) Then we will move forward the right pointer by 1. If the right pointer is pointing to a valid index(< n) after the increment, we will add the element i.e. a[right] to the sum.
5) Finally, we will return the maximum length.
 */
/*
Time Complexity :-  O(2*N), where N = size of the given array.
         Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times in total. So, the time complexity will be O(2*N) instead of O(N2).

Space Complexity :- O(1) as we are not using any extra space.

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
        System.out.println("The length of the longest subarray is: "+optimalApproach(array,K));
    }

    private static int optimalApproach(int[] array, long k) {
          int n = array.length; // size of the array
          int left = 0, right =0; // two pointer
          long sum = array[0];
          int  maxLen = 0;
          while(right < n){
              //if sum >k, reduce the subarray from left
              //until sum becomes less or equal to k:
              while(left<=right && sum>k){
                  sum-=array[left];
                  left++;
              }

              //if sum = k, update the maxLen i.e. answer:
              if(sum == k){
                  maxLen = Math.max(maxLen, right-left+1);
              }
              // Move forward the right pointer:
              right++;
              if(right < n) sum += array[right];
          }
          return maxLen;
    }
}