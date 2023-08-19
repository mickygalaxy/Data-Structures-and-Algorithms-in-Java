
// Binary Search

//Time Complexity :- O(log(n))
//Space Complexity :- O(1)


import java.util.Scanner;
abstract class BinarySerach{
    interface Search{
        int BSearch(int[] array, int value);
    }
}
public class Main extends BinarySerach implements BinarySerach.Search {
    @Override
    public int BSearch(int[] array, int value) {
        int left =0;
        int right = array.length-1;

        while(left<=right){
            int mid = (left+(right-1))/2;
            if(array[mid]==value){
                return mid;
            } else if (array[mid]<value) {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:-");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the element:-");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the Search value  :-");
        int value = sc.nextInt();
        Main Obj = new Main();
        System.out.println("index ->" +Obj.BSearch(a, value));
    }}
