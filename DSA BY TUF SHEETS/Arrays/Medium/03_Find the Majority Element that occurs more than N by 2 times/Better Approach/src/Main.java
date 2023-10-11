

/*
                                            "Find the Majority Element that occurs more than N/2 times"
(Using HashMap)

Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array.
You may consider that such an element always exists in the array.



Example 1:
Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution.

Example 2:
Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}

Result: 2

Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

Result: 4
 */
/*
Intuition:
Use a better data structure to reduce the number of look-up operations and hence the time complexity. Moreover, we have been calculating the count of the same element again and again – so we have to reduce that also.

: Approach :
- Use a hashmap and store as (key, value) pairs. (Can also use frequency array based on the size of nums)
- Here the key will be the element of the array and the value will be the number of times it occurs.
- Traverse the array and update the value of the key. Simultaneously check if the value is greater than the floor of N/2.
   - If yes, return the key
   - Else iterate forward.
 */
/*
--------------------
Complexity Analysis:-
--------------------
Time Complexity:-   O(N*logN) + O(N), where N = size of the given array.
Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times. If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

Space Complexity:-  O(N) as we are using a map data structure.
 */


import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int  n = sc.nextInt();
        int[] array = new int[n];
        setData(array);
        int  N =  n/2;
        System.out.println("Element that occurs more than "+ N + " times is "+betterApproach(array,N));

    }

    private static int betterApproach(int[] array,int N) {
        //declaring a map
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<array.length;i++){
            //storing the elements with its occurnce:
            int count = hm.getOrDefault(array[i],0);
                hm.put(array,count+1);
        }
        //searching for the majority element:
        for(Map.Entry<Integer,Integer> key : hm.entrySet()){
            if(key.getValue()>N){
                return key.getKey();
            }
        }
        return -1;
    }

    private static void setData(int[] array) {
          for(int i=0;i<array.length;i++){
              array[i] = sc.nextInt();
          }
    }
}