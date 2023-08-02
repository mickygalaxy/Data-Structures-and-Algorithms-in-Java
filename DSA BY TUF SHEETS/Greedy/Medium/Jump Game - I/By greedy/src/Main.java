
//                                                                 Jump Game

/*
-: Problem :-
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
 1 <= nums.length <= 10^4
 0 <= nums[i] <= 10^5

Time Complexity :- O(n)
Space Complexity :- O(1)

 */


import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size =sc.nextInt();
        int[] nums = new int[size];
        System.out.println("-: Enter the maximum 'Jump' each index :- ");
        for(int i=0;i<size;i++){
            nums[i] = sc.nextInt();
        }
        boolean ans = optimalApproach(nums,size);
        if(ans){
            System.out.println("< yes, its reach the last index >");
        }else{
            System.out.println("< No, it's not reach the last index >");
        }

    }

    private static boolean optimalApproach(int[] nums, int size) {
        int reachable = 0;
        for (int i=0; i<size; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}

/*
nums = [2,3,1,0,4]

   reachable = 0;

   for i = 0
     if( 0 > 0 )  not true
     reachable = max( 0 , 0+2)  =  max(0,2) = 2;

  for i = 1
    if( 1>2) not true
    reachable = max(2,1+3) = max(2,4) = 4;

  for i = 2
    if( 2> 4) not true
    reachable = max(4, 2) = 4

  for i = 3
    if( 3 > 4 ) not true
    reachable  = max (4, 1+0) = 4

  for i = 4
    if(4> 4) not true
    reachable = max(4,5) = 5

    end of the loop its return true......

 */