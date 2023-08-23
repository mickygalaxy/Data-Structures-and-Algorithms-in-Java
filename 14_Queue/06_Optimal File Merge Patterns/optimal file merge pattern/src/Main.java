
//                                                    Optimal File Merge Patterns

//Given n number of sorted files, the task is to find the minimum computations done to reach the Optimal Merge Pattern.
//When two or more sorted files are to be merged all together to form a single file, the minimum computations are done to reach this file are known as Optimal Merge Pattern.
/*
Examples:
Given 3 files with sizes 2, 3, 4 units. Find an optimal way to combine these files
Input: n = 3, size = {2, 3, 4}
Output: 14
 */
/*
Approach:

Node represents a file with a given size also given nodes are greater than 2

1) Add all the nodes in a priority queue (Min Heap).{pq.poll = file size}
2) Initialize count = 0 // variable to store file computations.
3) Repeat while (size of priority Queue is greater than 1)
    a) int weight = pq.poll(); pq.pop;//pq denotes priority queue, remove 1st smallest and pop(remove) it out
    b) weight+=pq.poll()  && pq.pop(); // add the second element and then pop(remove) it out
    c) count +=weight;
    d) pq.add(weight) // add this combined cost to priority queue;
4) count is the final answer
 */
/*
Time Complexity: O(nlogn)
Auxiliary Space: O(n)
 */


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the total file :- ");
        int total = sc.nextInt();
        int[]files = new int[total];
        setData(files,total);
        Arrays.sort(files);
        System.out.println("Minimum Cost is "+ minimumCost(files,total));
    }

    private static int minimumCost(int[] files, int total) {
        // create a min heap
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for(int i: files){
            // add sizes to priorityQueue
            pq.add(i);
        }
        int minimumCoat = 0;
        while (pq.size()>1){
            // pop two smallest size element
            // from the min heap
            int cost = pq.poll() + pq.poll();
            // add the current computations
            // with the previous one's
            minimumCoat+=cost;
            // add new combined file size
            // to priority queue or min heap
            pq.add(cost);
        }
        return minimumCoat;
    }

    private static void setData(int[] files, int total) {
        for(int i=0;i<total;i++){
            files[i] = sc.nextInt();
        }
    }
}
