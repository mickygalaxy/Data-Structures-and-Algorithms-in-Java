
//                                             Palindrome Numbers

// Time Complexity 0(d)

import java.util.Scanner;

public class Main implements palindrome { 
    static Scanner sc = new Scanner(System.in);
    @Override
    public Boolean ItsPalindrome(int n) {
        int rev=0;
        int num = n;

        while(num!=0){ 
            rev = rev*10+num%10;
            num=num/10;
        }
        if(rev!=n){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Enter the any number :- ");
        int number = sc.nextInt();
        Main a = new Main();
        Boolean ans =  a.ItsPalindrome(number);
        if (ans) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a palindrome");
        }
    }
}
