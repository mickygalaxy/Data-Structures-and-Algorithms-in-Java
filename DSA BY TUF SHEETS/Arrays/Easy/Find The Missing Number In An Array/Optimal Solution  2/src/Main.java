
/*
//                                                     Find the missing number in an array


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

XOR Approach:

Intuition:
Two important properties of XOR are the following:

XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

Now, let’s XOR all the numbers between 1 to N.
xor1 = 1^2^…….^N

Let’s XOR all the numbers in the given array.
xor2 = 1^2^……^N (contains all the numbers except the missing one).

Now, if we again perform XOR between xor1 and xor2, we will get:
xor1 ^ xor2 = (1^1)^(2^2)^……..^(missing Number)^…..^(N^N)

Here all the numbers except the missing number will form a pair and each pair will result in 0 according to the XOR property. The result will be = 0 ^ (missing number) = missing number (according to property 2).

So, if we perform the XOR of the numbers 1 to N with the XOR of the array elements, we will be left with the missing number.


Approach:
The steps are as follows:

~ We will first run a loop(say i) from 0 to N-2(as the length of the array = N-1).
~ Inside the loop, xor2 variable will calculate the XOR of array elements
   i.e. xor2 = xor2 ^ a[i].
   And the xor1 variable will calculate the XOR of 1 to N-1 i.e. xor1 = xor1 ^ (i+1).
~ After the loop ends we will XOR xor1 and N to get the total XOR of 1 to N.
~ Finally, the answer will be the XOR of xor1 and xor2.

Dry run:

Assume the given array is: {1, 2, 4, 5} and N = 5.
XOR of (1 to 5) i.e. xor1 = (1^2^3^4^5)
XOR of array elements i.e. xor2 = (1^2^4^5)
XOR of xor1 and xor2 = (1^2^3^4^5) ^ (1^2^4^5)
			= (1^1)^(2^2)^(3)^(4^4)^(5^5)
			= 0^0^3^0^0 = 0^3 = 3.
The missing number is 3.
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
        optimalSolutionSecond(array,N);
    }

    private static void optimalSolutionSecond(int[] a, int N) {
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        if((xor1 ^ xor2) == 0) {
            System.out.println("-: All numbers are present :-");
            System.out.println("-----------------------------------------------------------------------------------");
        }
        else {
            System.out.println((xor1 ^ xor2)+" - not present");
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }
}