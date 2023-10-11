




/*
Optimal Approach: Moore’s Voting Algorithm:
Intuition:
If the array contains a majority element, its occurrence must be greater than the floor(N/2).
Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the count of elements and the element itself for which we are tracking the count.

After traversing the whole array, we will check the element stored in the variable.
If the question states that the array must contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if the stored element is the majority element or not.
If not, then the array does not contain any majority element.
 */
/*
Approach:
-< Initialize 2 variables:
    -< Count –  for tracking the count of element
    -< Element – for which element we are counting
-< Traverse through the given array.
  -< If Count is 0 then store the current element of the array as Element.
  -< If the current element and Element are the same increase the Count by 1.
  -< If they are different decrease the Count by 1.
-< The integer present in Element should be the result we are expecting
 */

/*
Time Complexity:-  O(N) + O(N), where N = size of the given array.
Reason: The first O(N) is to calculate the count and find the expected majority element. The second one is to check if the expected element is the majority one or not.

Note: If the question states that the array must contain a majority element, in that case, we do not need the second check. Then the time complexity will boil down to O(N).
 */




// Moore vote algorithm.

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        setData(array,size);
        int N = size/2;
        System.out.println("Element that occurs more than "+ N + " times is "+ optimalSolution(array,size,N));
    }

    private static int optimalSolution(int[] array, int size, int N) {

   // 1 1 1 2 4 2 1 1 1 1
   // output :- 1
   int count = 0;
   int element = 0;
   //applying the algorithm
   for(int i=0;i<size;i++){
      if(count == 0){
          count++;
          element = array[i];
      }
      else if(element == array[i]){
          count++;
      }
      else{
          count--;
      }
   }

   //checking if the stored elemen
        // is the majority element:
        int freq = 0;
    for(int i=0;i<array.length;i++){
        if(array[i] == element){
            freq++;
        }
    }
    if(freq>N){
        return element;
    }
     return -1;
    }

    private static void setData(int[] array, int size) {
        for (int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
    }
}