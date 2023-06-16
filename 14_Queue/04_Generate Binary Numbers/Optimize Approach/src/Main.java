

//                                                  Generate Binary Number
 //  Optimal Approach
/*
Time Complexity :- O(num*log(n))
Space Complexity :- O(1)
 */



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number :- ");
        int num = sc.nextInt();
        generateBinaryNumber(num);
    }

    private static void generateBinaryNumber(int n) {
        for (int i = 1; i <= n; i++) {
            String str = "";
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    str = "1" + str;
                } else {
                    str = "0" + str;
                }
                temp = temp >> 1;
            }
            System.out.println(str);
        }
    }
}
/*
@ The method generatePrintBinary takes an integer n as input. This method is static, meaning it belongs to the class itself and can be called without creating an instance of the class.

@ The code initializes a for loop that iterates from 1 to n, inclusive. The loop variable i represents the numbers for which the binary representation will be generated.

@ Inside the loop, a String variable str is declared and initialized as an empty string. This variable will store the binary representation of the current number i.

@ The variable temp is assigned the value of i. This temporary variable will be used for bit manipulation operations in the next step.

@ A while loop is used to generate the binary representation of temp. The loop continues until temp becomes 0, which means all bits have been processed.

@ Inside the while loop, the condition (temp & 1) == 1 is used to check if the least significant bit of temp is 1. The & operator performs a bitwise AND operation, and (temp & 1) gives the value of the least significant bit.

@ If the condition is true, it means the least significant bit is 1, so the code appends "1" to the beginning of the str string using string concatenation.

@ If the condition is false, it means the least significant bit is 0, so the code appends "0" to the beginning of the str string.

@ After appending the appropriate bit to str, the temp variable is right-shifted by 1 (temp = temp >> 1). This shifts all bits to the right by one position, effectively discarding the least significant bit.

@ Steps 15-21 are repeated until all bits of temp have been processed (i.e., until temp becomes 0).

@ Once the binary representation of i is generated and stored in str, it is printed using System.out.println(str).

@ The loop continues until all numbers from 1 to n have been processed, generating and printing their respective binary representations.
 */