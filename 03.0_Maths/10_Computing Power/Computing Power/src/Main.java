

//                                                                            Computing Power

import java.util.Scanner;
public class Main implements Computing_Power{

    static Scanner sc = new Scanner(System.in);
    @Override
    public void naiveSolution(int x, int n) { // Time Complexity 0(n)
        int ans =1;
        for(int i=0;i<n;i++){
            ans*=x;
        }
        System.out.println(ans);
    }

    @Override
    public int power(int x, int n) {
        if(n == 0){
            return 1;
        }
        int temp = power(x,n/2); // Recursive call
        temp = temp*temp;
        if(n%2==0){
            return temp;
        }
        else {
            return temp*x;
        }

    }

    public static void main(String[] args) {
     System.out.printf("Enter the value of 'x' and 'n' :- ");
     int x = sc.nextInt();
     int n = sc.nextInt();
     Main Obj = new Main();
     System.out.println("------------------------------------------------------");
     System.out.println("-: First Method :-");
     Obj.naiveSolution(x,n);
     System.out.println("------------------------------------------------------");
     System.out.println("-: Second Method :-");
     System.out.println(Obj.power(x,n));

    }
}