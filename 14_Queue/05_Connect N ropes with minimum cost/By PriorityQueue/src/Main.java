
//                                                        Connect n ropes with minimum cost

//Given are N ropes of different lengths, the task is to connect these ropes into one rope with
//minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
//Sample Input 1 : N = 4, arr = [4 3 2 6]
//Sample Output 1 : 29
//Sample Input 2 : N = 2, arr = [1 2 3]
//Sample Output 2 : 9

/*                                                           -: Time and Space Complexity :-
Building the priority queue: Adding all the ropes to the priority queue takes O(N log N) time, where N is the total number of ropes. The addAll method has a time complexity of O(N), but each insertion into the priority queue takes O(log N) time, resulting in a total time complexity of O(N log N).

Merging the ropes: The while loop runs until there is only one rope left in the priority queue. In each iteration, two ropes are removed and one rope is added back to the priority queue. Since the size of the priority queue decreases by one in each iteration, the loop runs for (N - 1) times. The removal and addition of ropes take O(log N) time. Therefore, the time complexity of the while loop is O((N - 1) log N).

Hence, the overall time complexity of the code is O(N log N + (N - 1) log N), which can be simplified to O(N log N).

The space complexity of the given code is as follows:

Integer array Ropes: It requires O(N) space to store the lengths of the ropes.

PriorityQueue pq: The space required by the priority queue depends on the number of ropes, but it is limited to O(N) since we are storing N ropes.

Additional space: The space required for variables and method calls is insignificant compared to the space used by the priority queue and the array.

Therefore, the overall space complexity of the code is O(N).

~# time complexity is O(N log N)
~ # space complexity is O(N).
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total ropes : ");
        int total = sc.nextInt();
        Integer[] Ropes = new Integer[total];
        System.out.println("\t-: Enter the length of rope :- ");
        for(int i=0;i<total;i++){
            Ropes[i]=sc.nextInt();
        }
       System.out.println("Minimum Cost is "+minimumCost(Ropes,total));
    }

    private static int minimumCost(Integer[] ropes, int total) {
        // Create a priority queue to store the ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add all the ropes to the priority queue
        pq.addAll(Arrays.asList(ropes).subList(0, total));
        // Variable to store the minimum cost
        int minimum_cost =0;
        // Combine the ropes until only one rope is left in the priority queue
        while(pq.size()!=1){
            // Take the two smallest ropes from the priority queue
            int ans = pq.remove() + pq.remove();
            // Add the combined rope to the priority queue
            minimum_cost+=ans;
            // Increment the minimum cost by the combined length of the ropes
            pq.add(ans);
        }
        // Return the minimum cost
        return minimum_cost;
    }
}
/*

-: Explanation :-

@ The program prompts the user to enter the total number of ropes.
@ An array Ropes of Integer objects is created to store the lengths of the ropes.
@ The program then asks the user to enter the length of each rope and stores the values in the Ropes array.
@ The minimumCost method is called with the Ropes array and the total number of ropes as arguments.
@ In the minimumCost method, a PriorityQueue named pq is created. This priority queue is used to store the ropes in ascending order of their lengths.
@ The addAll method is used to add all the ropes from the Ropes array to the priority queue.
@ The variable minimum_cost is initialized to 0.
@ The program enters a loop that continues until there is only one rope left in the priority queue.
@ Inside the loop, the two smallest ropes are removed from the priority queue using the remove method and their lengths are added together.
@ The sum of the two lengths is stored in the ans variable.
@ The combined rope length is added back to the priority queue using the add method.
@ The minimum_cost variable is incremented by the combined length of the two ropes.
@ After the loop ends, the final minimum_cost is returned.
@ The program prints the minimum cost to the console.
 */