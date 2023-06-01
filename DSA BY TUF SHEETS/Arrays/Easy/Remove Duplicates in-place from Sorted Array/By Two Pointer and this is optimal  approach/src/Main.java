

//                                                     Remove Duplicates in-place from Sorted Array
/*
Two pointers

Intuition: We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till we don’t get a number arr[j] which is different from arr[i]. As we got a unique number we will increase the i pointer and update its value by arr[j].

-: Approach :-
@ Take a variable i as 0;
@ Use a for loop by using a variable ‘j’ from 1 to length of the array.
@ If arr[j] != arr[i], increase ‘i’ and update arr[i] == arr[j].
@ After completion of the loop return i+1, i.e size of the array of unique elements.
 */
/*
Time Complexity :- O(n)
Space Complexity :- O(1)
 */

import java.util.Scanner;
public class Main {
    public static int By_Two_Pointer(int[] array){
        int i=0;
        for(int j = 1;j<array.length;j++){
            if(array[i]!=array[j]){
                array[i+1] = array[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of array :- ");
        int Size = sc.nextInt();
        int[] array = new int[Size];
        for(int i=0;i<Size;i++){
            array[i] = sc.nextInt();
        }
        int index = By_Two_Pointer(array);
        for(int i=0;i<index;i++){
            System.out.println(array[i]+" ");
        }

    }
}