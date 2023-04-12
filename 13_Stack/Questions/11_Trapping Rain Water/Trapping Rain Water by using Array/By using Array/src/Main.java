

//                                   Trapping Rain Water Problem

/*
Time Complexity :- O(n)
Space Complexity :- O(n)
 */


import java.util.Scanner;
public class Main {
    static  Scanner sc = new Scanner(System.in);
    static public void setData(int[]array){
       for(int i=0;i<array.length;i++){
        array[i] = sc.nextInt();}
    }

    static public int rainWaterTrapping(int[]array){ // using auxiliary array

        // array[] is height[].
        int ans  = 0; // trappedWater
        // calculate left max boundary - array
        int[]left = new int[array.length];
        int max1 = array[0];
        left[0] = max1;

        for(int i=1;i<array.length;i++){
            if(array[i]>max1){
                max1 = array[i];
                left[i]=max1;
            }
            else{
                left[i]=max1;
            }
        }
        // calculate right max boundary - array
        int[]right = new int[array.length];
        int max2 = array[array.length-1];
        right[array.length-1]=max2;

        for(int j= array.length-2;j>=0;j--){
            if(array[j]>max2){
                max2 = array[j];
                right[j]=max2;
            }
            else{
                right[j]=max2;
            }
        }
//        for(int i=0;i<array.length;i++){
//            System.out.println(right[i]);
//        }

        // waterLevel = min (leftMax boundary , rightMax boundary) and trapped water = waterLevel - height[i]
        for(int i=0;i<array.length;i++){
            ans+=(Math.min(left[i],right[i])-array[i]);
        }

        return ans; // trappedWater
    }


// Time Complexity :- O(n) and Space Complexity :- O(1)
    // Two Pointer Approach
    static public int trap(int[] height) { // Optimize Method
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int size = sc.nextInt();
        int[] array = new int[size];
        setData(array);
        System.out.println(rainWaterTrapping(array));
        System.out.println(trap(array));
    }
}