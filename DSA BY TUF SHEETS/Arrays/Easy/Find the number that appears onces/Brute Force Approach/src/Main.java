
//                                         Find the number that appears once, and the other numbers twice

//Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

/*
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
Algorithm / Intuition

Naive Approach(Brute-force approach):

Intuition:

For every element present in the array, we will do a linear search and count the occurrence.
If for any element, the occurrence is 1, we will return it.

Approach:
The steps are as follows:

~ First, we will run a loop(say i) to select the elements of the array one by one.
~ For every element arr[i], we will perform a linear search using another loop and count its occurrence.
~ If for any element the occurrence is 1, we will return it.
 */
/*
Time Complexity:-  O(N2), where N = size of the given array.
               Reason: For every element, we are performing a linear search to count its occurrence. The linear search takes O(N) time complexity. And there are N elements in the array. So, the total time complexity will be O(N2).

Space Complexity:-  O(1) as we are not using any extra space.
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
        bruteForceApproach(array,size);
    }

    private static void bruteForceApproach(int[] array, int size) {

        //Run a loop for selecting elements:
        for(int i=0;i<size;i++){
            int count =0;
            int num = array[i];// selected element
            //find the occurrence using linear search:
            for(int j=0;j<size;j++){
                if(num == array[j]){
                    count++;
                }
            }
            if (count == 1){ // if count is 1 means number appear only one time in the array
                System.out.println("the number that appears once is "+num);
            }

        }
        System.out.println("-: the number that appears once is not present :-");
    }
}