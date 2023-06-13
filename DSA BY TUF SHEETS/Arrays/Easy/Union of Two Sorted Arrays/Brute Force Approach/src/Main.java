
//                                                          Union of Two Sorted Arrays
/*
Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
The union of two arrays can be defined as the common and distinct elements in the two arrays.

NOTE: Elements in the union should be in ascending order.

Examples:

Example 1:
Input:
n = 5,m = 5.
arr1[] = {1,2,3,4,5}
arr2[] = {2,3,4,4,5}
Output:
 {1,2,3,4,5}

Explanation:
Common Elements in arr1 and arr2  are:  2,3,4,5
District Elements in arr1 are : 1
District Elements in arr2 are : No distinct elements.
Union of arr1 and arr2 is {1,2,3,4,5}

Example 2:
Input:
n = 10,m = 7.
arr1[] = {1,2,3,4,5,6,7,8,9,10}
arr2[] = {2,3,4,4,5,11,12}
Output: {1,2,3,4,5,6,7,8,9,10,11,12}

Explanation:
Common Elements in arr1 and arr2  are:  2,3,4,5
District Elements in arr1 are : 1,6,7,8,9,10
District Elements in arr2 are : 11,12
Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}
 */


/*
 Time complexity :- O(n+m)
 Space Complexity :- O(n+m)
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the first array
        int size1 = sc.nextInt();
        int[] array1 = new int[size1];

        // Read the elements of the first array
        setData(array1, size1, sc);

        // Read the size of the second array
        int size2 = sc.nextInt();
        int[] array2 = new int[size2];

        // Read the elements of the second array
        setData(array2, size2, sc);

        // Calculate the size of the union array
        int size = size1 + size2;

        // Create the union array
        int[] union = new int[size];

        // Perform the union operation
        performUnion(union, array1, array2, size1, size2);
        Arrays.sort(union);
        // Display the union array
        getData(union);

        // Close the scanner
        sc.close();
    }

    private static void performUnion(int[] union, int[] array1, int[] array2, int size1, int size2) {
        int index = 0;

        // Copy elements from array1 to the union array
        for (int i = 0; i < size1; i++) {
            union[index] = array1[i];
            index++;
        }

        // Copy elements from array2 to the union array
        for (int i = 0; i < size2; i++) {
            union[index] = array2[i];
            index++;
        }
    }

    private static void getData(int[] union) {
        // Display the elements of the union array
        for (int i : union) {
            System.out.print(i + " ");
        }
        System.out.println(); // Print a new line after displaying the array
    }

    private static void setData(int[] array, int size, Scanner sc) {
        // Read the elements of the array from user input
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
    }
}
