
//                                              " Lexicographically the smallest string of length N and sum K "

/*
The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 */
/*
Example 1:
  
Input: n = 3, k = 27
Output: "aay" 
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
Example 2:

Input: n = 5, k = 73
Output: "aaszz"


Constraints:

1 <= n <= 105
n <= k <= 26 * n
 */
/*

Time Complexity :- O(n)
Space Complexity :- O(n)
 */



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Length of String :- ");
        int N = sc.nextInt();
        System.out.print("Enter the Value of 'k' :- ");
        int K = sc.nextInt();
        lexicographicallySmallerString(N,K);
    }

    private static void lexicographicallySmallerString(int n, int k) {
        char[] array = new char[n];
        Arrays.fill(array,'a');
        k = k-n;
        int j = n-1;
        while(k>0){
            if(k<25){
                array[j] = (char)('a' + k);
                k=0;
            } else {
                array[j] = 'z';
                k = k-25;
            }
            j--;
        }
        System.out.println(new String(array));
    }
    /*
             " -------- Explanation of lexicographicallySmallerString(int n, int k) function code ----------- "

~ It starts by creating a character array of length 'n' and fills it with the character 'a'.

~ The value of 'k' is subtracted from 'n' to determine the number of characters that need to be decremented.

~ A variable 'j' is initialized to 'n-1', which represents the index of the last character in the array.

~ The code enters a loop that continues until 'k' is greater than 0.

~ Inside the loop, it checks if 'k' is less than 25. If so, it means that the remaining value of 'k' can be represented by a character other than 'a'. In this case, it assigns the character ('a' + k) to the array at index 'j', effectively decrementing the character.

~ If 'k' is greater than or equal to 25, it means that the remaining value of 'k' requires decrementing the current character to 'z'. So, it assigns 'z' to the array at index 'j' and subtracts 25 from 'k'.

~ After decrementing the character, 'j' is decremented to move to the previous index in the array.

~ Finally, the modified character array is converted into a string and printed as the lexicographically smaller string.
     */
}
