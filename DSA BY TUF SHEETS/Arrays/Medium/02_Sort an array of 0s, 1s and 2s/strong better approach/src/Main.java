


/*
                                                          Sort an array of 0s, 1s and 2s
                                                          ------------------------------
Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions.
( Expected: Single pass-O(N) and constant space).

-------------------------------------
---- Examples ----
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Output: [0]
--------------------------------------

/*

 */

/*
Algorithm / Intuition
---------------------
---------------------

Keeping count of values

Intuition: Since in this case there are only 3 distinct values in the array so it’s easy to maintain the count of all, Like the count of 0, 1, and 2.
           This can be followed by overwriting the array based on the frequency(count) of the values.

Approach:-

~ Take 3 variables to maintain the count of 0, 1 and 2.
~ Travel the array once and increment the corresponding counting variables
~ ( let’s consider count_0 = a, count_1 = b, count_2 = c )
~ In 2nd traversal of array, we will now over write the first ‘a’ indices / positions in array with ’0’, the next ‘b’ with ‘1’ and the remaining ‘c’ with ‘2’.
 */

/*
Complexity Analysis:-
-------------------
-------------------
Time Complexity:-   O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0’s, 1’s, 2’s, and second O(N) for placing them correctly in the original array.

Space Complexity:-  O(1) as we are not using any extra space.
 */





import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[]array = new int[size];
        setData(array);
        strongBetterApproach(array,size);
        displayData(array,size);
    }

    private static void displayData(int[] array, int size) {
        for (int i: array){
            System.out.println(i+" ");
        }
    }

    private static void strongBetterApproach(int[] array, int size) {

           int[] count = new int[4];

           for(int i:array){
               count[i]++;
           }

           int i = 0;
           int j = 0;
           while (i<4){
               if(count[i]!=0){
               while (count[i]!=0){
                   array[j++] = i;
                   count[i]--;
               }}
               i++;
           }
    }

    private static void setData(int[] array){
       for (int i=0;i<array.length;i++){
           array[i] = sc.nextInt();
       }


    }
}