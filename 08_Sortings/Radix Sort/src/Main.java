
//                                                  Radix Sort 
/*
~ Radix Sort ~
Similar to Counting sort and Bucket sort, this sorting algorithm also assumes some kind of
information about the input elements. Suppose that the input values to be sorted are from base d.
That means all numbers are d-digit numbers.
In Radix sort, first sort the elements based on the last digit [the least significant digit]. These
results are again sorted by second digit [the next to the least significant digit]. Continue this process
for all digits until we reach the most significant digits. Use some stable sort to sort them by last
digit. Then stable sort them by the second least significant digit, then by the third, etc. If we use
Counting sort as the stable sort, the total time is O(nd) ≈ O(n).

Algorithm: 
1) Take the least significant digit of each element.
2) Sort the list of elements based on that digit, but keep the order of elements with the
same digit (this is the definition of a stable sort).
3) Repeat the sort with each more significant digit.


The speed of Radix sort depends on the inner basic operations. If the operations are not efficient
enough, Radix sort can be slower than other algorithms such as Quick sort and Merge sort. These
operations include the insert and delete functions of the sub-lists and the process of isolating the
digit we want. If the numbers are not of equal length then a test is needed to check for additional
digits that need sorting. This can be one of the slowest parts of Radix sort and also one of the
hardest to make efficient.
Since Radix sort depends on the digits or letters, it is less flexible than other sorts. For every
different type of data, Radix sort needs to be rewritten, and if the sorting order changes, the sort
needs to be rewritten again. In short, Radix sort takes more time to write, and it is very difficult to
write a general purpose Radix sort that can handle all kinds of data.
For many programs that need a fast sort, Radix sort is a good choice. Still, there are faster sorts,
which is one reason why Radix sort is not used as much as some other sorts.
Time Complexity: O(nd) ≈ O(n), if d is small.
 */
// this is a stable Algorithm.
/*
Time Complexity :- O(d*(n+b)) 0r O(n)
Space Complexity :- O(n+k)
 */
import java.util.Scanner;

public class Main {

    // This method sorts an array of integers by counting the number of occurrences of each unique integer.
// The count is stored in an auxiliary array and the sorting is done by mapping the count as an index of the auxiliary array.
    static void countingSort(int[] array, int n, int exp) {

        // Create an auxiliary array of size 10.
        int[] count = new int[10];

        // Iterate through the array and increment the count at the corresponding index in the auxiliary array for each unique integer.
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Calculate the cumulative sum of the auxiliary array.
        for (int i = 1; i < 10; i++) { 
            count[i] += count[i - 1];
        }

        // Iterate through the array in reverse order and store the element at the corresponding index in the auxiliary array in the output array.
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to the input array.
        System.arraycopy(output, 0, array, 0, n);
    }

    // This method sorts an array of integers using the radix sort algorithm.
    public static void radixSort(int[] array, int n) {

        // Find the maximum element in the array.
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Iterate through the exponents from 1 to the maximum value.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, n, exp);
        }
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of array :- ");
        int Size = sc.nextInt();
        int[] array = new int[Size];
        for(int i=0;i<Size;i++){
            array[i] = sc.nextInt();
        }
        radixSort(array,array.length);
        System.out.println("-: After Sorting :-");
        for(int i: array){
            System.out.print(i+" ");
        }
    }
}
