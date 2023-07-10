

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
Better Approach (using Hashing):
        Intuition:-
        ~ Using the hashing technique, we will store the frequency of each element of the given array. Now, the number( i.e. between 1 to N) for which the frequency will be 0, will be returned. Refer to the article link to know more about hashing.

        Approach:-
        The algorithm steps are as follows:
        ~ The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
        ~ Now, for each element in the given array, we will store the frequency in the hash array.
        ~ After that, for each number between 1 to N, we will check the frequencies. And for any number, if the frequency is 0, we will return it.


Dry run:

Assume the given array = {1,3} and N = 3. The hash array will look like the following:

0  1  2  3  <- index
0  1  0  1  <- value

We can clearly see that for index 2 the frequency is 0 and so 2 is our answer.
*/

/*
Time Complexity:-  O(N) + O(N) ~ O(2*N),  where N = size of the array+1.
                   Reason: For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N).

Space Complexity:-  O(N), where N = size of the array+1. Here we are using an extra hash array of size N+1.
 */
import java.util.Arrays;
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
        betterSolution(array,N);
    }

    private static void betterSolution(int[] array, int n) {

        int[]hashing = new int[n+1];
        Arrays.fill(hashing,0);
        boolean found = false;
        for(int i : array){
            hashing[i] = 1;
        }
        for(int i=1;i<=n;i++){
            if(hashing[i]==0){
                System.out.println(i+" - not present ");
                found = true;
            }
        }
        if(!found) {
            System.out.println("-: All numbers are present :-");
            System.out.println("-----------------------------------------------------------------------------------");
        }
        else {
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}