
//                      Find Second Smallest and Second-Largest Element in an array

/*
Approach:
~ Find the smallest and largest element in the array in a single traversal
~ After this, we once again traverse the array and find an element that is just greater than the smallest element we just found.
~ Similarly, we would find the largest element which is just smaller than the largest element we just found
~ Indeed, this is our second smallest and second-largest element.

 * Time Complexity :- O(n)
 * Space Complexity :- O(1)

 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    protected static void BetterSolution(int[] array,int n){ // this function have two parameters, its take array and size of array.
        int largest = Integer.MIN_VALUE; // this hold the maximum value
        int second_largest = Integer.MIN_VALUE; // this hold the second maximum value
        int smallest = Integer.MAX_VALUE; // this hold the minimum value
        int second_smallest = Integer.MAX_VALUE; // this hold the second minimum value

        for(int i=0;i<n;i++){ // iterating each index to find largest and smallest value in the array
            if(array[i]>=largest) largest = array[i];
            if(array[i]<=smallest) smallest = array[i];
        }

        for(int i=0;i<n;i++){ // iterating each index to find second largest and second smallest in the array
            if(array[i]!=largest && array[i] >second_largest) second_largest = array[i];
            if(array[i]!=smallest && array[i]<second_smallest) second_smallest = array[i];
        }
        System.out.println("Second Smallest is "+second_smallest+"\n"+"Second Largest is "+second_largest); // printing the second smallest & second largest
    }
    public static void main(String[] args) {

        System.out.print("[Enter the Size of Array] :- ");
        int n = sc.nextInt(); // Take the input size of array by dynamically by at runtime
        int[] Array = new int[n]; // declare the array with size and its integer type
        for(int i=0;i<n;i++){ // iterate each index for take the input value by user and that index hold the value.
            Array[i] = sc.nextInt(); // nextInt() is function for taking integer type value & sc is an object of class Scanner.
        }
        BetterSolution(Array,n);// calling the function for find second-smallest and second-largest.
    }
}