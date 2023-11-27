import java.util.Scanner;
abstract class LinearSerach{
     interface Search{
        void LSearch(int[] array, int value); 
    }
        } 

public class Main extends LinearSerach implements LinearSerach.Search {
    @Override
    public void LSearch(int[] array, int value) {
        for(int i =0;i<array.length;i++){
            if(array[i]==value){
                System.out.println("index - "+i+" ");
                return;
            }
        }
        System.out.println(-1+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:-");
        int n = sc.nextInt();
        int[]a = new int[n];
        System.out.println("Enter the element:-");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the Search value  :-");
        int value=sc.nextInt();
        Main Obj = new Main();
        Obj.LSearch(a,value);

    }
}
