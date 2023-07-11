
/*
                                             Find the number that appears once, and the other numbers twice
Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Examples 1:
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.

Example 2:
Input Format: arr[] = {4,1,2,1,2}
Result: 4
Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */


/*
Better Approach(Using Hashing): "It's applicable only positive number"

Intuition:
In the previous approach, we were finding the occurrence of an element using linear search.
We can optimize this using hashing technique. We can simply hash the elements along with their occurrences in the form of (key, value) pair. Thus, we can reduce the cost of finding the occurrence and hence the time complexity.

Now, hashing can be done in two different ways, and they are the following:

Array hashing(not applicable if the array contains negatives or very large numbers)
Hashing using the map data structure

Array hashing:
In order to hash using an array, we need to first find the maximum element(say maxElement) to get the range of the hash array. The index of the hash array will represent the elements of the given array and the value stored in that index will be the number of occurrences. Now, the size of the array must be maxElement+1 as we need to hash the maxElement itself.

: Approach :
The steps are as follows:
~ First, we will find the maximum element(say maxElement) to know the size of the hash array.
~ Then we will declare a hash array of size maxElement+1.
~ Now, using another loop we will store the elements of the array along with their frequency in the hash array. (i.e. hash[arr[i]]++)
~ After that, using another loop we will iterate over the hash array, and try to find the element for which the frequency is 1, and finally, we will return that particular element.

Note: While searching for the answer finally, we can either use a loop from 0 to n(i.e. Size of the array) or use a loop from 0 to maxElement. So, the time complexity will change accordingly.

Now, using array hashing it is difficult to hash the elements of the array if it contains negative numbers or a very large number. So to avoid these problems, we will be using the map data structure to hash the array elements.
 */

/*
Time Complexity: O(N)+O(N)+O(N), where N = size of the array
               Reason: One O(N) is for finding the maximum, the second one is to hash the elements and the third one is to search the single element in the array.

Space Complexity: O(maxElement+1) where maxElement = the maximum element of the array.
 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Size Of Array :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("-: Enter the value one by one :-");
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        int maxElement = Integer.MIN_VALUE;
        // Find the maximum element:
        for(int i : array){
            maxElement = Math.max(maxElement,i);
        }
        betterApproach(array,size,maxElement);
    }

    private static void betterApproach(int[] array, int size,int maxElement) {
        // Declare hash array of size maxElement+1
        // And hash the given array:
        int[]hashing = new int[maxElement+1];
        for(int i=0;i<size;i++){
            hashing[array[i]]++;
        }
        //Find the single element and 'return' or 'print' the answer:-
        for(int i =0; i< maxElement+1;i++){
            if(hashing[i]==1){
                System.out.println("the number that appears once is "+i);
            }
        }
        System.out.println("-: the number that appears once is not present :-");
    }
}