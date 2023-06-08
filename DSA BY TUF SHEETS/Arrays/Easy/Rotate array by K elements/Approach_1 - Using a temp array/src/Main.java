

//                                                Rotate array by K elements
/*
Rotate array by K elements

Problem Statement: Given an array of integers, rotating array of elements by k elements either left or right.

Examples:

Example 1:
Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
Output: 6 7 1 2 3 4 5
Explanation: array is rotated to right by 2 position .

Example 2:
Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left
Output: 9 10 11 3 7 8
Explanation: Array is rotated to right by 3 position.
 */
/*

Approach 1: Using a temp array

For Rotating the Elements to right
 Step 1: Copy the last k elements into the temp array.
 Step 2: Shift n-k elements from the beginning by k position to the right
 Step 3: Copy the elements into the main array from the temp array.
------------------------------- or -----------------------------------
For Rotating the Elements to left
 Step 1: Copy the first k elements into the temp array.
 Step 2: Shift n-k elements from last by k position to the left
 Step 3: Copy the elements into the main array from the temp array.
 */
/*
# Time Complexity: O(n)
# Space Complexity: O(k) since k array element needs to be stored in temp array
 */
import java.util.Scanner;
public class Main {
    public static void approachFirst(int[]array,int k){
        int j = k;
        while(j!=0){
            for(int i=array.length-1;i>=1;i--){
                int temp = array[i];
                array[i]=array[i-1];
                array[i-1]=temp;
            }
            j--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array:- ");
        int size = sc.nextInt();
        int[]array = new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the K element:- ");
        int k = sc.nextInt();
        approachFirst(array,k);
        System.out.println("display the array :- ");
        for(int i : array){
            System.out.print(i+" ");
        }
    }
}