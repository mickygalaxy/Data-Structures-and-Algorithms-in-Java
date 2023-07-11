

//                                    Find the number that appears once, and the other numbers twice


/*
Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Examples 1:
Input Format: arr[] = {2,2,1,3,3}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.

Example 2:
Input Format: arr[] = {4,1,2,1,2,3,3}
Result: 4
Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */
/*
                                                 -: Hashing using the map data structure :-
Intuition:
The intuition will be the same as the array hashing. The only difference here is we will use the map data structure for hashing instead of using another array for hashing.

: Approach :
The steps are as follows:
~ First, we will declare a map.
~ Now, using a loop we will store the elements of the array along with their frequency in the map data structure.
~ Using another loop we will iterate over the map, and try to find the element for which the frequency is 1, and finally, we will return that particular element.
 */
/*

Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
Reason: We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map). So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, the time complexity will be O(N) + O(M).

Note: The time complexity will be changed depending on which map data structure we are using. If we use unordered_map in C++, the time complexity will be O(N) for the best and average case instead of O(N*logM). But in the worst case(which rarely happens), it will be nearly O(N2).

Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.
 */

import java.util.HashMap;
import java.util.Map;
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
        betterApproach(array,size);
    }

    private static void betterApproach(int[] array, int size) {
        // Create a HashMap to store the count of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        // Iterate over the array
        for (int i = 0; i < size; i++) {
            if (map.containsKey(array[i])) {
                // If the element already exists in the map, increment its count
                map.put(array[i], count + 1);
            } else {
                // If the element does not exist in the map, add it with a count of 1
                map.put(array[i], count);
            }
        }

        // Iterate over the map entries
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // If the count is 1, print the corresponding element
                System.out.println("the number that appears once is "+entry.getKey());
            }
        }
        System.out.println("-: the number that appears once is not present :-");
    }
}