//                                         Right Rotate the Array by 'k' steps
//         Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

/*
Time Complexity :- O(n)
Space Complexity :- O(1)
 */
import java.util.Optional;
import java.util.Scanner;
public class Main {

        public static void rotate(int[] array, int k) {
            int size = array.length;
            k = k%size;
            reverse(array,0,size-1);
            reverse(array,0,k-1);
            reverse(array,k,size-1);
        }
        public static void reverse(int[]array,int s,int e){
            while(s<=e){
                int temp = array[s];
                array[s] = array[e];
                array[e] = temp;
                s++;
                e--;
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array :- ");
        int size = sc.nextInt();
        int[]array =new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the Number of  time steps to Rotate :- ");
        int k = sc.nextInt();
        rotate(array,k);
        System.out.println("-: Right Rotate the Array by 'k' steps :-");
        for(int i: array){
            System.out.print(i+" ");
        }
    }
}