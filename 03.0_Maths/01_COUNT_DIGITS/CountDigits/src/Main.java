

//                                                   Count Digits

// Time complexity 0(d)


import java.util.Scanner;

public class Main implements Count_Digits{
static Scanner sc = new Scanner(System.in);
    @Override
    public int count(int num) {
        int Count=0;
        int x = num;
        while(x!=0){
            x = x/10;
            Count++;
        }
        return Count;
    }

    public static void main(String[] args) {

          System.out.println("Enter the number : ");
          int Number = sc.nextInt();
          if(Number<10){
              System.out.println("Total Number Of Digits is "+1);
          }
          else {
              Main a = new Main();
              int ans = a.count(Number);
              System.out.println("Total Number Of Digits is " + ans);
          }
    }
}