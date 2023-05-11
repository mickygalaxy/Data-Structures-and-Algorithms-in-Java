
//                      Find Second Smallest and Second-Largest Element in an array

/*
Intuition: In the previous solution, even though we were able to bring down the time complexity to O(N), we still needed to do two traversals to find our answer. Can we do this in a single traversal by using smart comparisons on the go?

Approach:
~ We would require four variables: small,second_small, large, and second_large. Variable small and second_small are initialized to INT_MAX while large and second_large are initialized to INT_MIN.

# Second Smallest Algo:

~ If the current element is smaller than ‘small’, then we update second_small and small variables
~ Else if the current element is smaller than ‘second_small’ then we update the variable ‘second_small’
~ Once we traverse the entire array, we would find the second-smallest element in the variable second_small.
~ Here’s a quick demonstration of the same.


# Second Largest Algo:

~ If the current element is larger than ‘large’ then update second_large and large variables
~ Else if the current element is larger than ‘second_large’ then we update the variable second_large.
~ Once we traverse the entire array, we would find the second-largest element in the variable second_large.
~ Here’s a quick demonstration of the same.



 * Time Complexity :- O(n)
 * Space Complexity :- O(1)

 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    static private int secondSmallest(int[] arr, int n)
    {
        if (n < 2)
        {
            return -1;
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++)
        {
            if (arr[i] < small)
            {
                second_small = small;
                small = arr[i];
            }
            else if (arr[i] < second_small && arr[i] != small)
            {
                second_small = arr[i];
            }
        }
        return second_small;
    }
    static private int secondLargest(int[] arr, int n)
    {
        if(n<2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++)
        {
            if (arr[i] > large)
            {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large)
            {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    public static void main(String[] args) {

        System.out.print("[Enter the Size of Array] :- ");
        int n = sc.nextInt(); // Take the input size of array by dynamically by at runtime
        int[] Array = new int[n]; // declare the array with size and its integer type
        for(int i=0;i<n;i++){ // iterate each index for take the input value by user and that index hold the value.
            Array[i] = sc.nextInt(); // nextInt() is function for taking integer type value & sc is an object of class Scanner.
        }
        System.out.println("Second Smallest is "+secondSmallest(Array,n)+"\n"+"Second Largest is "+secondLargest(Array,n));

    }
}