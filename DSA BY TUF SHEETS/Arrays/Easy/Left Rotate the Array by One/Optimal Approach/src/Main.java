
//                                        Left Rotate the Array by One

/*
Approach:
Here, in the given array :

n = 5,
arr[] = {1,2,3,4,5}
At first, we have to shift the array towards the left so, we store the value of the first index in a variable (let it be x).

Then we iterate the array from the 0th index to the n-1th index(why n-1 i will explain it below)

And then store the value present in the next index to the current index like this :

arr[i] = arr[i+1]
And to prevent its segmentation fault we will iterate it till n-1.

At last, put the value of variable x in the last index of the array.
 */

/*
Time Complexity: O(n),   as we iterate through the array only once.
Space Complexity: O(1),  as no extra space is used
 */

import java.util.Scanner;
public class Main {

    public static void Optimal_Approach(int[]array){
        if(array.length== 0){
            return;
        }
        int size = array.length;
        int temp = array[0];// storing the first element of array in a variable
        for(int i=1;i<size;i++){
            array[i-1]=array[i];
        }
        array[size-1] = temp;// assigned the value of variable at the last index
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array :- ");
        int size = sc.nextInt();
        int[]array =new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        Optimal_Approach(array);
        System.out.println("-: Left Rotate the Array by One :-");
        for(int i: array){
            System.out.print(i+" ");
        }
    }
}