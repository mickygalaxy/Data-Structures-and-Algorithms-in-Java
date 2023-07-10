
//                                                           Find the missing number in an array


//Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
// Find the number(between 1 to N), that is not present in the given array.

/*
Example 1:
Input Format: N = 5, array[] = {1,2,4,5}
Result: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format: N = 3, array[] = {1,3}
Result: 2
Explanation: In the given array, number 2 is missing. So, 2 is the answer.
 */
/*
Summation Approach:


Intuition:

We know that the summation of the first N numbers is (N*(N+1))/2. We can say this S1. Now, in the given array, every number between 1 to N except one number is present. So, if we add the numbers of the array (say S2), the difference between S1 and S2 will be the missing number. Because, while adding all the numbers of the array, we did not add that particular number that is missing.

Sum of first N numbers(S1) = (N*(N+1))/2
Sum of all array elements(S2) = i = 0n-2a[i]
The missing number = S1-S2


-: Approach :-
The steps are as follows:
We will first calculate the summation of first N natural numbers(i.e. 1 to N) using the specified formula.
Then we will add all the array elements using a loop.
Finally, we will consider the difference between the summation of the first N natural numbers and the sum of the array elements.


Dry run:
- Assume the given array is: {1, 2, 4, 5} and N = 5.
- Summation of 1 to 5 = (5*(5+1))/2 = 15
- Summation of array elements = 12
- So, the difference will be = 15 - 12 = 3.
- And the missing number is also 3.
 */

/*
Time Complexity: O(N), where N = size of array+1.
          Reason: Here, we need only 1 loop to get the sum of the array elements. The loop runs for approx. N times. So, the time complexity is O(N).

Space Complexity: O(1) as we are not using any extra space.
 */
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Enter The Value Of 'N' :- ");
        int N = sc.nextInt();
        int[] array = new int[N-1];
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-: Enter The Value [ 1 to "+N+" ] :- ");
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0; i<N-1;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("-----------------------------------------------------------------------------------");
        optimalSolutionFirst(array,N);
    }

    private static void optimalSolutionFirst(int[] array, int n) {
        int s1 = (n*(n+1))/2;
        int s2 = 0;
        for (int i=0;i<n-1;i++){
            s2+=array[i];
        }
        if((s1-s2) == 0) {
            System.out.println("-: All numbers are present :-");
            System.out.println("-----------------------------------------------------------------------------------");
        }
        else {
            System.out.println((s1-s2)+" - not present");
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }
}