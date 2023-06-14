

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
                                                               ~~~ Two Pointers ~~~
Solution 1 and 2 work for the unsorted arrays also, The arrays arr1 and arr2 are sorted, can we use this property to reduce the time Complexity?

Using the property that the arrays are sorted we can bring down the time complexity from

O((m+n)log(m+n))    TO    O(m+n).
Approach:

Take two pointers let’s say i,j pointing to the 0th index of arr1 and arr2.
Create a empty vector for storing the union of arr1 and arr2.
From solution 2 we know that the union is nothing but the distinct elements in arr1 + arr2
Let’s traverse the arr1 and arr2 using pointers i and j and insert the distinct elements found into union vector.
While traversing, we may encounter three cases.

arr1[ i ] == arr2[ j ]
Here we found a common element, so insert only one element in the union. Let’s insert arr[i] in union and increment i.

NOTE: There may be cases like the element to be inserted is already present in the union, in that case, we are inserting duplicates which is not desired. So while inserting always check whether the last element in the union vector is equal or not to the element to be inserted. If equal we are trying to insert duplicates, so don’t insert the element, else insert the element in the union. This makes sure that we are not inserting any duplicates in the union because we are inserting elements in sorted order.
arr1[ i ]  < arr2[ j ]
arr1[ i ] < arr2[ j ] so we need to insert arr1[ i ] in union.IF last element in  union vector is not equal to arr1[ i ],then insert in union else don’t insert. After checking Increment i.
arr1[ i ] > arr2[ j ]
arr1[ i ] > arr2[ j ] so we need to insert arr2[ j ] in union. IF the last element in the union vector is not equal to arr2[ j ], then insert in the union, else don’t insert. After checking Increment j. After traversing if any elements are left in arr1 or arr2 check for condition and insert in the union.
 */

/*
Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct.

Space Complexity : O(m+n) {If Space of Union ArrayList is considered}

O(1) {If Space of union ArrayList is not considered}
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the size of the first array
        System.out.print("\n\nEnter the Size of First Array :- ");
        int size1 = sc.nextInt();
        int[] array1 = new int[size1];
        System.out.println(":- Enter the data :-");
        // Read the elements of the first array
        setData(array1, size1, sc);
        System.out.println("\n----------------------------------------\n");
        // Read the size of the second array
        System.out.print("Enter the Size of Second Array :- ");
        int size2 = sc.nextInt();
        int[] array2 = new int[size2];
        System.out.println(":- Enter the data :-");
        // Read the elements of the second array
        setData(array2, size2, sc);
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println("\n----------------------------------------\n");
        ArrayList<Integer> Union = FinfUnion(array1, array2, size1, size2);
        System.out.println("-: Union of arr1 and arr2 :- [ arr1 u arr2 ]");
        for (int val : Union)
            System.out.print(val + " ");
    }

    private static ArrayList<Integer> FinfUnion(int[] array1, int[] array2, int size1, int size2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < size1 && j < size2) {
            if (array1[i] <= array2[j]) {
                if (union.size() == 0 || union.get(union.size()-1) != array1[i]) {
                    union.add(array1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != array2[j])
                    union.add(array2[j]);
                j++;
            }
        }
        while (i < size1) // IF any element left in arr1
        {
            if (union.get(union.size() - 1) != array1[i])
                union.add(array1[i]);
            i++;
        }
        while (j < size2) // If any elements left in arr2
        {
            if (union.get(union.size() - 1) != array2[j])
                union.add(array2[j]);
            j++;
        }
            return union;

    }
    private static void setData(int[] array, int size, Scanner sc) {
        // Read the elements of the array from user input
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
    }
}