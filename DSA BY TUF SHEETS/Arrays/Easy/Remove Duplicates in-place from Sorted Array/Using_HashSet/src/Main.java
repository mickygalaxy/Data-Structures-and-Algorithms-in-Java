
//                                           (Better Solution)
//                             Remove Duplicates in-place from Sorted Array
/*
Remove Duplicates in-place from Sorted Array
Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.

If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result.
It does not matter what you leave beyond the first k elements.

Note: Return k after placing the final result in the first k slots of the array.

Example 1:

Input: arr[1,1,2,2,2,3,3]

Output: arr[1,2,3,_,_,_,_]

Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.

Example 2:

Input: arr[1,1,1,2,2,3,3,3,3,4,4]

Output: arr[1,2,3,4,_,_,_,_,_,_,_]

Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.
 */



/*
Intuition:- We have to think of a data structure that does not store duplicate elements. So can we use a Hash set?
Ans :-     Yes! We can. As we know HashSet only stores unique elements.

Approach:

@ Declare a HashSet.
@ Run a for loop from starting to the end.
@ Put every element of the array in the set.
@ Store size of the set in a variable K.
@ Now put all elements of the set in the array from the starting of the array.
@ Return K.
 */
/*
Time complexity: O(n*log(n))+O(n)
Space Complexity: O(n)
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
public class Main {
    private static int BetterSolution(int[]array){

        // A LinkedHashSet maintains the insertion order of elements, unlike a regular HashSet.
        // By using a LinkedHashSet, the code will correctly remove duplicates while preserving the original order of elements in the array.
        LinkedHashSet<Integer> set = new LinkedHashSet<>();   // LinkedHashSet<Integer> set = new LinkedHashSet<>()   or   HashSet<Integer> set = new HashSet<>();

        // Add unique elements to the set
        for (int i:array) {        // its take (n) time
            set.add(i);            // its take constant time (1)
        }
        int k=set.size();
        int j=0;
        // Copy unique elements back to the original array
        for(int x : set){         // its take (k) time
            array[j++] = x;
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of 'array' :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);                  // its take (n*log(n)) time
        int newSize = BetterSolution(array);
        for (int i=0;i<newSize;i++){         // its take (n) time
            System.out.println(array[i]+" ");
        }
    }
}
