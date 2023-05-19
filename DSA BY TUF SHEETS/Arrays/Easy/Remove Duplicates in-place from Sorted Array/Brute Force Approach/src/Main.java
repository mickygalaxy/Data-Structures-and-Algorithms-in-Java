
//                                         Brute Force Method

//                             Remove Duplicates in-place from Sorted Array
// Time Complexity :- O(n*n)
// Space Complexity :- O(1)



import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void SetData(int[]a,int n){
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
    }

    private static void duplicate_Remove(int[]array,int n){
        for(int i=0;i<n-1;i++){
            if(array[i]==array[i+1]){
                int j = i+1;
                while(j!=n-1){
                    array[j]=array[j+1];
                    array[j+1] = Integer.MIN_VALUE;
                    j++;
                }

            }
        }
    }

    private static void getData(int[]a,int n){
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        int size = sc.nextInt();
        int[]array = new int[size];
        SetData(array,size);
        duplicate_Remove(array,size);
        getData(array,size);
       // if(array[3]==Integer.MIN_VALUE)  array[3] = 5;
        // getData(array,size);
    }
}