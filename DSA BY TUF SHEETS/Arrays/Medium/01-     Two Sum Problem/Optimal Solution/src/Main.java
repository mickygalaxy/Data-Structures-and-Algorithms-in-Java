

/*
                                                 Two Sum : Check if a pair with given sum exists in Array


Problem Statement:
Given an array of integers arr[] and an integer target.

1st variant:-  Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant:-  Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note:- You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

@--> Examples <--@

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.


Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.






 ---> Optimized Approach(using two-pointer) <---

Intuition: In this approach, we will first sort the array and will try to choose the numbers in a greedy way.

We will keep a left pointer at the first index and a right pointer at the last index. Now until left < right, we will check the sum of arr[left] and arr[right]. Now if the sum < target, we need bigger numbers and so we will increment the left pointer. But if sum > target, we need to consider lesser numbers and so we will decrement the right pointer.

If sum == target we will return either “YES” or the indices as per the question.
But if the left crosses the right pointer, we will return “NO” or {-1, -1}.

Approach:

The steps are the following:

~ We will sort the given array first.
~ Now, we will take two pointers i.e. left, which points to the first index, and right, which points to the last index.
~ Now using a loop we will check the sum of arr[left] and arr[right] until left < right.
   If arr[left] + arr[right] > sum, we will decrement the right pointer.
   If arr[left] + arr[right] < sum, we will increment the left pointer.
   If arr[left] + arr[right] == sum, we will return the result.
~ Finally, if no results are found we will return “No” or {-1, -1}.


 Dry Run: Given array, nums = [2,1,3,4], target = 4
First, we sort the array. So nums after sorting are [1,2,3,4]
We take two-pointers, left and right. The left points to index 0 and the right points to index 3.
Now we check if nums[left] + nums[right] == target. In this case, they don’t sum up, and nums[left] + nums[right] > target so that we will reduce right by 1.
Now, left = 0, right=2
Here, nums[left] + nums[right] == 1 + 3 == 4, which is the required target, so we will return the result.

--------------------------------------------------------------------------------------------------------
Time Complexity :- O(N) + O(N*logN), where N = size of the array.
Reason: The loop will run at most N times. And sorting the array will take N*logN time complexity.

Space Complexity :- O(1) as we are not using any extra space.
--------------------------------------------------------------------------------------------------------


 */


import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    static Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the size of array :- ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("-: Enter the data :- ");
        for(int i = 0; i<size; i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the target value :- ");
        int k = sc.nextInt();
        optimalSolution(array,k);

    }

    private static void optimalSolution(int[] array, int k) {
        Arrays.sort(array);
        System.out.println("-: Sorted Array :-");
        getData(array);
        int i = 0;
        int j = array.length-1;
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        boolean flag = false;

        while(i<j){
            if(array[i]+array[j] == k){
                ans[0] = i;
                ans[1] = j;
                flag = true;
                break;
            }else if(array[j]>=k){
                j--;
            }else
            {
                i++;
            }
        }
        if(flag){
            System.out.println("Yes,There exist two numbers such that their sum is equal to the target");
        }else {
            System.out.println("No");
        }
        System.out.println("Indices :- [ "+ans[0]+" , "+ans[1]+" ]");
        System.out.println();System.out.println("-------------------------------------------------------------------------------");

    }

    private static void getData(int[] array) {
        for(int i : array){
            System.out.print(i+" ");
        }

        System.out.println();System.out.println("-------------------------------------------------------------------------------");
    }
}
