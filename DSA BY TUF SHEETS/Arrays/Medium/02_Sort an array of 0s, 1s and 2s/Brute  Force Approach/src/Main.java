

//                                        ---- Sort an array of 0s, 1s and 2s ----

/*
Problem Statement: Given an array consisting of only 0s, 1s, and 2s.
Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

 --------------------------------
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Output: [0]
-----------------------------------


Time Complexity :- O( n^2 )  or  [when use merge sort then its complexity :- O(n*log(n))
Space Complexity :- O(1)

 */




import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the data only [0 , 1 , 2]");
        setData(array,size);
        System.out.println("-: after sort the data :-");
        bruteForceApproach(array,size);
        getData(array,size);

    }

    private static void getData(int[] array, int size) {

        for(int i : array){
            System.out.print(i+" ");
        }

    }

    private static void bruteForceApproach(int[] array, int size) {
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                if(array[i]>array[j]){
                     int temp = array[i];
                     array[i] = array[j];
                     array[j] = temp;
                }
            }
        }
    }

    private static void setData(int[] array, int size) {
         for(int i=0;i<size;i++){
             array[i] = sc.nextInt();
         }
    }
}