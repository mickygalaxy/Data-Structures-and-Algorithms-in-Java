//                            Move all Zeros to the end of the array

/*
Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

Examples:

Example 1:
Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

Example 2:
Input: 1,2,0,1,0,4,0
Output: 1,2,1,4,0,0,0
Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order



Brute Force

Approach and thought process:
Here, our 1st task is to put non-negative elements in the front of the array, So we can create a new temporary array and update indices of this temp array from starting with non-negative elements and while doing this we can count the number of Zeros also, So we will count the number of zeros and fill remaining indices of temp array with zero.

Let’s see the algorithm:
@ Create a temp array of length input array.
@ Traverse through array and if a non-negative elements encounter then put this element in the temp array at zero index and increment index.
@ Fill the zeros in remaining places of temp array.

 */
/*
Time Complexity :- O(n)
Space Complexity :- O(n)
 */

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]array = new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        bruteForce(array,size);
        System.out.println("-: OutPut :-");
        for(int i : array){
            System.out.print(i+" ");
        }
    }

    private static void bruteForce(int[] array,int size) {
        int[]temp = new int[size];
        int k=0;
        int i=0;
        while(i!= size){
            if(array[i]!=0){
            temp[k++]= array[i];
            }
            i++;
        }
        while(k!= size){
            temp[k++]=0;
        }
        System.arraycopy(temp, 0, array, 0, size);
    }
}