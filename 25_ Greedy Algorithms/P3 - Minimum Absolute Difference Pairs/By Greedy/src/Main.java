
//                                                   " Minimum Absolute Difference Pairs " ( by Greedy )

// @ Minimum sum of absolute difference of pairs of two arrays @
/*
Given two arrays a[] and b[] of equal length n. The task is to pair each element of array 'a' to an element in array 'b', such that sum S of absolute differences of all the pairs is minimum.
Suppose, two elements a[i] and a[j] (i != j) of a are paired with elements b[p] and b[q] of b respectively,
then p should not be equal to q.
 */
/*
Examples:

Input :  a[] = {3, 2, 1}
         b[] = {2, 1, 3}
Output : 0
Explanation :
 1st pairing: |3 - 2| + |2 - 1| + |1 - 3|
         = 1 + 1 + 2 = 4
 2nd pairing: |3 - 2| + |1 - 1| + |2 - 3|
         = 1 + 0 + 1 = 2
 3rd pairing: |2 - 2| + |3 - 1| + |1 - 3|
         = 0 + 2 + 2 = 4
 4th pairing: |1 - 2| + |2 - 1| + |3 - 3|
         = 1 + 1 + 0 = 2
 5th pairing: |2 - 2| + |1 - 1| + |3 - 3|
         = 0 + 0 + 0 = 0
 6th pairing: |1 - 2| + |3 - 1| + |2 - 3|
         = 1 + 2 + 1 = 4
 Therefore, 5th pairing has minimum sum of
 absolute difference.

Input :  n = 4
         a[] = {4, 1, 8, 7}
         b[] = {2, 3, 6, 5}
Output : 6
 */
/*
The solution to the problem is a simple greedy approach. It consists of two steps.
Step 1 : Sort both the arrays in O (n log n) time.
Step 2 : Find absolute difference of each pair of corresponding elements (elements at same index) of both arrays and add the result to the sum S. The time complexity of this step is O(n).
Hence, the overall time complexity of the program is O(n log n).
 */
/*
Time Complexity :- O(n*log(n))
Space Complexity :- O(n)
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of Array :- ");
        int size = sc.nextInt();
        int[] A = new int[size];
        int[] B = new int[size];
        System.out.println("-: Enter The Data For Array 'A' :-");
        setData(A,size); // Read data for array A
        System.out.println("-: Enter The Data For Array 'B' :-");
        setData(B,size); // Read data for array B
        System.out.println("Sum of absolute differences of all the pairs is minimum :- "+optimalApproach(A,B,size));
    }

    private static int optimalApproach(int[] a, int[] b, int size) {
        Arrays.sort(a); // Sort array A in ascending order
        Arrays.sort(b);// Sort array B in ascending order
        int minDifference=0;
        for(int i=0;i<size;i++){
            // Calculate the sum of absolute differences between corresponding elements of arrays A and B
            minDifference += Math.abs(a[i]-b[i]);
        }
        return minDifference;
    }

    private static void setData(int[] arr, int size) {
        for(int i=0;i<size;i++){
            arr[i]  = sc.nextInt(); // Read data for each element of the array
        }
    }
}