

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
                                                                 ~~~ Using Map ~~~

Our aim is to find the common elements in arr1 and arr2, and the distinct elements of arr1,arr2.
Use a Single map to find the frequencies of elements in arr1 and arr2.

As we are using only a single map the common element in arr1 and arr2 are treated as a single element for finding frequency,
so there would be no duplicates.

Why not unordered_map?
In unordered_map the keys are stored in random order, while in the map the keys are stored in sorted order (ascending order by default).
As we require elements of the union to be in ascending order, using a map is preferable.

We can also use unordered_map, but after finding the union of arr1 and arr2, we need to sort the union vector to get the elements of the union in sorted order.
 */
/*
Time Complexity : O( (m+n)log(m+n) ) . Inserting a key in map takes logN times, where N is no of elements in map. At max map can store m+n elements {when there are no common elements and elements in arr,arr2 are distntict}. So Inserting m+n th element takes log(m+n) time. Upon approximation across insertion of all elements in worst it would take O((m+n)log(m+n) time.

Using HashMap also takes the same time, On average insertion in unordered_map takes O(1) time but sorting the union vector takes O((m+n)log(m+n))  time. Because at max union vector can have m+n elements.

Space Complexity : O(m+n) {If Space of Union ArrayList is considered}

O(1) {If Space of union ArrayList is not considered}
 */



import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println("\n----------------------------------------\n");
        ArrayList<Integer> Union = FinfUnion(array1,array2,size1,size2);
        System.out.println("-: Union of arr1 and arr2 :- [ arr1 u arr2 ]");
        for (int val: Union)
            System.out.print(val+" ");
    }


    private static ArrayList<Integer> FinfUnion(int[] array1, int[] array2, int n, int m) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        /*
         the expression getOrDefault(arr1[i], 0) + 1 retrieves the value associated with arr1[i] from the map and increments it by 1.
         If the key arr1[i] is not present in the map, it returns the default value 0 and then increments it by 1.
         */
        for(int i=0;i<n;i++){
           frequency.put(array1[i],frequency.getOrDefault(array1[i],0)+1);
        }
        for(int i=0;i<m;i++){
            frequency.put(array2[i],frequency.getOrDefault(array2[i],0)+1);
        }
          /*
           The method keySet() is used to retrieve a set view of all the keys contained in the map. The method signature is as follows:-
            " Set<K> keySet() "

            Here, K represents the type of keys in the map, and the method returns a Set containing all the keys.

           In the code snippet you provided, freq.keySet() is likely used to retrieve a set of keys from the freq map,
           where freq is an instance of a map (such as HashMap or TreeMap) that represents the frequency count of elements.

           For example, if freq is a HashMap<String, Integer> representing the frequency count of strings,
            freq.keySet() will return a Set<String> containing all the unique strings (keys) present in the map.
         */
        return new ArrayList<>(frequency.keySet());
    }

    private static void setData(int[] array, int size, Scanner sc) {
        // Read the elements of the array from user input
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
    }
}