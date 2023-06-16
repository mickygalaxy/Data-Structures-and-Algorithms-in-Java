
//                                                  Generate Binary Number
//  Brute force Approach
/*
Time Complexity :- O(num*log(n))
Space Complexity :- O(num*log(n))
 */
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        generateBinaryNumber(num);

    }

    private static void generateBinaryNumber(int num) {
        for(int i=1;i<=num;i++){
            StringBuilder s = new StringBuilder();
            int n = i;
            while (n!=0){
                int msd = n%2;
                n = n/2;
                s.append(msd);
            }

            System.out.println(revers(s));
        }


    }
    private static StringBuilder revers(StringBuilder s){
        int size = s.length();
        StringBuilder ss = new StringBuilder();
        for(int i=size-1;i>=0;i--){
            ss.append(s.charAt(i));
        }
        s = new StringBuilder(ss.toString());
        return s;
    }
}