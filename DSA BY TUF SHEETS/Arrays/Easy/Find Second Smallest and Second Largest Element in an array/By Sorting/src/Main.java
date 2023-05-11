
//                      Find Second Smallest and Second-Largest Element in an array

/*
it is a Brute Force Approach

Approach:
~ Sort the array in ascending order
~ The element present at the second index is the second-smallest element
~ The element present at the second index from the end is the second-largest element

 * Time Complexity :- O(nlog(n))
 * Space Complexity :- O(n)

 */

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("[Enter the Size of Array] :- ");
        int n = sc.nextInt();
        int[] Array = new int[n];
        for(int i=0;i<n;i++){
            Array[i] = sc.nextInt();
        }
        Arrays.sort(Array);
        System.out.println("Second Smallest is "+Array[1]+"\n"+"Second Largest is "+Array[n-2]);
        }
    }