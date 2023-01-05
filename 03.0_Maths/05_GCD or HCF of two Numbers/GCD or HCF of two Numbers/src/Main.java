

//                                                       GCD or HCF of two Numbers



import java.util.Scanner;
public class Main implements GCD_OR_HCF{

    static Scanner sc = new Scanner(System.in);



    //----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public int gcd_or_hcf(int num1, int num2) {        // Time Complexity  0(min(num1,num2))            first method brute force approach

       int ans = Math.min(num1,num2);

       while(ans>0){
           if(num1%ans==0 && num2%ans==0){
               break;
           }
           ans--;
       }
        return ans;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public int By_euclid___gcd(int num1, int num2) { // basic version  its optimize method and it's called Euclid algorithm.

        while(num1!=num2){
            if(num1>num2){
                num1 = num1-num2;
            }
            else {
                num2 = num2-num1;
            }
        }
        return num1;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public int Optimize_Euclid_algorithm_gcd(int num1, int num2) {
        if(num2==0){
            return num1;
        }
        return Optimize_Euclid_algorithm_gcd(num2,num1%num2);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {

        System.out.printf("\n\nEnter the value of N1 and N2 :-");
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();
        Main a = new Main();
        System.out.println("\nGCD or HCF is "+a.gcd_or_hcf(N1,N2));
        System.out.println("\n\n-: By Euclid algorithm :-");
        System.out.println("\nGCD or HCF is "+a.By_euclid___gcd(N1,N2));
        System.out.println("\n\n-: By Euclid algorithm (Optimize version) :-");
        System.out.println("\nGCD or HCF is "+a.Optimize_Euclid_algorithm_gcd(N1,N2));


    }
}