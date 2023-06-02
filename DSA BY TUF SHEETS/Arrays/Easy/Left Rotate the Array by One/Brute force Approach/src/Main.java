
//                                        Left Rotate the Array by One

/*
Time Complexity: O(n),  as we iterate through the array only once.

Space Complexity: O(n), as we are using another array of size, same as the given array.
 */
/*
Brute force Approach
Intuition:
The rotated array has just a difference that its first element is present at the last index of the array.
So if we can just store the element at the first index and then shift all the elements towards the left and at last put the stored element at the last index. We will get th rotated array.

Approach:
We can take another dummy array of the same length and then shift all elements in the array toward the left and then at the last element store the index of 0th index of the array and print it.
 */
import java.util.Scanner;
public class Main {

    public static void Brut_Force_Approach(int[]array){
        if(array.length== 0){
            return;
        }
        int size = array.length;
        int[]temp = new int[size];
        for(int i=1;i<size;i++){
            temp[i-1]=array[i];
        }
        temp[size-1]= array[0];
        System.arraycopy(temp, 0, array, 0, size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array :- ");
        int size = sc.nextInt();
        int[]array =new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        Brut_Force_Approach(array);
        System.out.println("-: Left Rotate the Array by One :-");
        for(int i: array){
            System.out.print(i+" ");
        }
    }
}