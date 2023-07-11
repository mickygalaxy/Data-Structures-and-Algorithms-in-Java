

/*
                                              Find the number that appears once, and the other numbers twice.

Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Examples 1:
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.

Example 2:
Input Format: arr[] = {4,1,2,1,2}
Result: 4
Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */
/*
Optimal Approach(Using XOR):

Intuition:

Two important properties of XOR are the following:

XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

Here all the numbers except the single number appear twice and so will form a pair. Now, if we perform XOR of all elements of the array, the XOR of each pair will result in 0 according to the XOR property 1. The result will be = 0 ^ (single number) = single number (according to property 2).

So, if we perform the XOR of all the numbers of the array elements, we will be left with a single number.

Approach:
We will just perform the XOR of all elements of the array using a loop and the final XOR will be the answer.
Dry run:

Assume the given array is: [4,1,2,1,2]
XOR of all elements = 4^1^2^1^2
      = 4 ^ (1^1) ^ (2^2)
      = 4 ^ 0 ^ 0 = 4^0 = 4
Hence, 4 is the single element in the array.
 */
/*
Time Complexity: O(N), where N = size of the array.
               Reason: We are iterating the array only once.

Space Complexity: O(1) as we are not using any extra space.
 */
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter the Size Of Array :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("-: Enter the value one by one :-");
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        optimalSolution(array,size);
    }

    private static void optimalSolution(int[] array, int size) {
        int xor = 0;
        for(int i=0;i<size;i++){
            xor = xor ^array[i];

        }
        System.out.println("the number that appears once is "+ xor);
    }
}