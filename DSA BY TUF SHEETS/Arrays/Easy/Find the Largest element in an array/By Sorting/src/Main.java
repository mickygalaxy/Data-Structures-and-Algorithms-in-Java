
// Time Complexity :- O(n log(n))
// Space Complexity :- (n)

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] array = {2,6,3,11,3,1,0,99,33,55};
        int n = array.length;
        Arrays.sort(array);
        System.out.println(array[n-1]);
    }
}