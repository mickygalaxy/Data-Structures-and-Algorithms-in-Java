
//                                                 Factorial of a Number






import java.util.Scanner;

public class Main implements Iterative{

    static Scanner sc = new Scanner(System.in);

    @Override
    public int Factorial(int n) {

        int ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;


    }

    public static void main(String[] args)
    {   System.out.printf("Enter the number:- ");
        int number = sc.nextInt();
        Main a = new Main();
        System.out.printf("%d Factorial is %d",number,a.Factorial(number));
    }
}