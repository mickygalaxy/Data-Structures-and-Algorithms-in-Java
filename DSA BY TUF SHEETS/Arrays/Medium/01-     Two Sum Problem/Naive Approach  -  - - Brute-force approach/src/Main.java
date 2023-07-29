
//                                            Two Sum : Check if a pair with given sum exists in Array

/*
Problem Statement:-----  Given an array of integers arr[] and an integer target. ----------------

1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
 */
/*
Examples:

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.



Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
 */
/*

Intuition: For each element of the given array, we will try to search for another element such that its sum is equal to the target.
           If such two numbers exist, we will return the indices or “YES” accordingly.

Approach:

First, we will use a loop(say i) to select the indices of the array one by one.
For every index i, we will traverse through the remaining array using another loop(say j) to find the other number such that the sum is equal to the target (i.e. arr[i] + arr[j] = target).
Observation:- In every iteration, if the inner loop starts from index 0, we will be checking the same pair of numbers multiple times. For example, in iteration 1, for i = 0, we will check for the pair arr[0] and arr[1]. Again in iteration 2, for i = 1, we will check arr[1] and arr[0]. So, to eliminate these same pairs, we will start the inner loop from i+1.

Dry Run:- Given array, nums = [2,1,3,4], target = 4

Using the naive approach, we first select one number and then find the second one.

For index 0, element= 2,
Then, we iterate through indices 1 to 3 to check if target – x, i.e. 4 – 2 = 2 exists. 2 does not exist from index 1 to 3, we move to the next index.

For index 1, element=1,
Then, we iterate through indices 2 to 3 to find if target – x, i.e. 4 – 1 = 3 exists. 3 exists at index 2, so we store the indices 1 and 2, break the loop, and return the indices.
 */
/*
 Time Complexity :- O(n*n)                --:> Reason: There are two loops(i.e. nested) each running for approximately N times.
 Space Complexity :- O(1)
 */



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[] Array = new int[size];
        System.out.println("-: Enter the value one by one :- ");
        setData(Array,size);
        System.out.print("Enter the value of 'K' :- ");
        int K = sc.nextInt();
        bruteForceApproach(Array,size,K);
    }

    private static void bruteForceApproach(int[] array, int size,int k) {
        int[] ans = new int[2];
        boolean found = false;
        Arrays.fill(ans,-1);
        for(int i=0;i<size;i++){
            for(int j = i+1;j<size;j++){
                if(array[i]+array[j] == k){
                    ans[0] = i;
                    ans[1] = j;
                    found = true;
                }
            }
        }
        if(found==true){
            System.out.println(" Sum is equal to the target :- 'yes' ");
        }
        else{
            System.out.println(" Sum is equal to the target :- 'no' ");
        }

        System.out.println("Pairs :- [ "+ans[0]+" ,"+ans[1]+" ]");
    }

    private static void setData(int[] array, int size) {
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
    }
}