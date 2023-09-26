

/*
                                                          Sort an array of 0s, 1s and 2s
                                                          ------------------------------
Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions.
( Expected: Single pass-O(N) and constant space).

-------------------------------------
---- Examples ----
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Output: [0]
--------------------------------------



// using Dutch National flag algorithm.
/*
Algorithm / Intuition
---------------------
This problem is a variation of the popular Dutch National flag algorithm.

This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

-arr[0….low-1] contains 0. [Extreme left part]
-arr[low….mid-1] contains 1.
-arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array

The middle part i.e. arr[mid….high] is the unsorted segment. So, hypothetically the array with different markers will look like the following:
 */
/*
Approach:

Note: Here in this tutorial we will work based on the value of the mid pointer.

The steps will be the following:

~ First, we will run a loop that will continue until mid <= high.
~ There can be three different values of mid pointer i.e. arr[mid]
    - If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
    - If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
    - If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
    - In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
~ Finally, our array should be sorted.
 */
/*
Time Complexity:-  O(N), where N = size of the given array.
Reason: We are using a single loop that can run at most N times.
Space Complexity:- O(1) as we are not using any extra space.
 */
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[]array = new int[size];
        setData(array);
        optimalApproach(array,size);
        displayData(array,size);
    }

    private static void optimalApproach(int[] array, int size) {
        int low = 0;
        int mid = 0;
        int high = size - 1;
        while (mid <= high) {
            if (array[mid] == 0) {
                int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                mid++;
                low++;
            } else if (array[mid] == 1) {
                mid++;
            } else {
                int temp = array[mid];
                array[mid] = array[high];
                array[high] = temp;
                high--;
            }
        }
    }

    private static void displayData(int[] array, int size) {
        for (int i: array){
            System.out.println(i+" ");
        }
    }

    private static void setData(int[] array){
        for (int i=0;i<array.length;i++){
            array[i] = sc.nextInt();
        }
    }
}