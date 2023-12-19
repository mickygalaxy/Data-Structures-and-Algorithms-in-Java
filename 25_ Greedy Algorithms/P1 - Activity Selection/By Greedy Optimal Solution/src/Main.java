
//                                                                  Activity Selection  ( By Greedy )

/*
-: Algorithm :-
This problem can be solved using a greedy algorithm. Here's the algorithm:

@ Sort the activities in ascending order of their finish times. 
@ Select the first activity from the sorted list as the first selected activity.
@ For each remaining activity in the sorted list:
    ~ If the start time of the current activity is greater than or equal to the finish time of the previously selected activity,
              select the current activity and update the previously selected activity to the current one.
    ~ Otherwise, ignore the current activity and continue to the next one.
@ Repeat step 3 until all activities have been considered.
 */
/*
 -: Time and Space Complexity :-
 # when already sorted according to end-time.
    Time  :- O(n)
    Space :- O(1) or O(n)
 # when already sorted according to end-time.
    Time  :- O(n*log(n))
    Space :- O(n)
 */

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the total activity :-");
          int totalActivity = sc.nextInt();
          int[]start = new int[totalActivity];
          int[]end   = new int[totalActivity];
          SetTime(start,end,totalActivity);
          if(isSortedArray(end,totalActivity)) {
              optimalSolution1(start, end, totalActivity);
          }
          else{
              optimalSolution2(start,end,totalActivity);
          }
    } 

    private static void optimalSolution1(int[] start, int[] end, int totalActivity) { // Time Complexity :- O(n) when array are already sorted
        int count=1;
        int select = end[0];
        ArrayList<Integer> Activity = new ArrayList<>();  // Space Complexity :- O(n) using arraylist to store activity when to show the activity.
        Activity.add(0);
        for(int i=1;i<totalActivity;i++){
            if(start[i]>=select){
                count++;
                select = end[i];
                Activity.add(i);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Maximum number of activities that can be performed by a single person :- "+count);
        System.out.println("-------------------------------------------------------------------------------");
        for (int i: Activity){
            System.out.println("Activity - "+i);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void optimalSolution2(int[] start, int[] end, int totalActivity) { // Time Complexity :- O(n*log(n) when array are not sorted
        int count=1;
        // Sorting
        int[][]Activities = new int[totalActivity][3];
        for(int i=0;i<totalActivity;i++){
            Activities[i][0] = i; // index storing because after sorting to find original array index of activity
            Activities[i][1] = start[i];
            Activities[i][2] = end[i];
        }
        // lambda function -> shot form
        Arrays.sort(Activities, Comparator.comparingDouble(o -> o[2]));
        // end time basis sorted
        int lastEnd = Activities[0][2];
        ArrayList<Integer> Activity = new ArrayList<>();  // Space Complexity :- O(n) using arraylist to store activity when to show the activity.
        Activity.add(Activities[0][0]);
        for(int i=1;i<totalActivity;i++){
            if(Activities[i][1]>=lastEnd){
                //Activity select
                count++;
                lastEnd = Activities[i][2];
                Activity.add(Activities[i][0]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Maximum number of activities that can be performed by a single person :- "+count);
        System.out.println("-------------------------------------------------------------------------------");
        for (int i: Activity){
            System.out.println("Activity - "+i);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }


    private static void SetTime(int[] start, int[] end, int totalActivity) {
        System.out.println("s-e"); // start( s )  &  end( e )
        for(int i = 0;i<totalActivity;i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
    }

    private static boolean isSortedArray(int[] array, int n) {
        if(n == 1 || n == 0) return true;
        return array[n-2] <= array[n-1] && isSortedArray(array, n-1);
    }
}
