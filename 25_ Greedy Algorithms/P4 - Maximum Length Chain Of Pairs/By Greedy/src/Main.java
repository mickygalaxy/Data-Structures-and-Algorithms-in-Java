
//                                                            Maximum Length of Pair Chain  ( By greedy )

/*
 you are given 'n' Pairs of numbers. In every pair, the first number is always smaller than the second number. A pair ( c , d ) can come after pair ( a , b), if "( b < c)".
~@ Find the longest chain which can be formed a given set of pairs.

--- or ---

You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.


Example :

Input: pairs = [[1,2],[2,3],[3,4]]

Output: 2

Explanation: The longest chain is [1,2] -> [3,4].



💥 Algorithm 💥 By " Greedy "

👉  Read the total number of chains from the user.

👉 Create a 2D array called Chains to store the chain pairs.

👉 Prompt the user to enter the chain pairs and populate the Chains array.

👉 If the total number of chains is not zero, proceed with the next steps.     Otherwise, return 0 as there are no chains.

👉Sort the Chains array in ascending order based on the second element of each chain pair.

👉Initialize variables: longestChain to 0 and prev_chainEndingPoint to -1000000000.

👉Iterate over the remaining chain pairs starting from the first pair.

          -> If the first element of the current chain pair is greater than the chainEndingPoint, it means a new chain can be formed.

                 -> Increment the longestChain counter.

                 -> Update the chainEndingPoint to the second element of the current chain pair.



👉Return the value of longestChain, which represents the length of the longest chain.

----------------------------------------------------------------------------------------

💥 Explanation 💥



 👉 find the longest chain in a set of chain pairs. It takes input from the user, stores the chain pairs in a 2D array, and sorts them based on the end points of each chain. The sorting step is crucial because it ensures that we process the chain pairs in ascending order of their end points, which allows us to find non-overlapping chains efficiently.



👉 By iterating through the sorted chain pairs, the code checks if a new chain can be formed by comparing the start point of the current pair with the chainEndingPoint. If it is greater, it means the current chain does not overlap with the previous chain, so the longestChain counter is incremented, and the chainEndingPoint is updated accordingly.



👉 Finally, the code returns the value of longestChain, which represents the length of the longest chain found in the given set of chain pairs.



🔴  This algorithm has a time complexity of O(n log n), where n is the total number of chains. The sorting step dominates the complexity, and the subsequent iteration over the sorted array takes linear time. 🔴



⚫ The space complexity is O(1), This is because the function only uses a few variables, and the size of these variables is constant.

 ~ The space complexity can be analyzed as follows:

 ~  The Chains array takes up n x 2 bytes of space.

 ~ The longestChain variable takes up 4 bytes of space.

 ~ The chainEndingPoint variable takes up 4 bytes of space.

 ⚫



⏳ Time Complexity :- O(n log n )

⏳ Space Complexity :- O(1)


 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Total NUmber Of Chains :-");
        int totalChain = sc.nextInt(); // Read the total number of chains from the user
        int[][] Chains = new int[totalChain][totalChain]; // Create a 2D array to store the chain pairs
        System.out.println("Enter the Chain Pair ( start , end ) :- ");
        setData(Chains,totalChain); // Prompt the user to enter the chain pairs and populate the array
        if (totalChain != 0) {
            System.out.println("Longest Chain :- "+longestChain(Chains,totalChain)); // Find the length of the longest chain and print it
        } else {
            System.out.println("Longest Chain :- "+0); // If there are no chains, print 0
        }
    }
    private static int longestChain(int[][] Chains, int totalChain) {
        Arrays.sort(Chains, Comparator.comparingInt(o->o[1])); // Sort the chain pairs based on the second element (end point)
        int longestChain = 0; // Initialize the length of the longest chain to 0
        int prev_chainEndingPoint =  -1000000000; // Set the initial ending point.
        for(int i=0;i<totalChain;i++){
                if(Chains[i][0]>prev_chainEndingPoint){ // If the start point of the current chain pair is greater than the chain ending point
                 longestChain++; // Increment the length of the longest chain
                 prev_chainEndingPoint = Chains[i][1];} // Update the chain ending point to the end point of the current chain pair
            }
        return longestChain; // Return the length of the longest chain
    }

    private static void setData(int[][] Chains, int totalChain) {
        for(int i=0;i<totalChain;i++){
            Chains[i][0] = sc.nextInt();
            Chains[i][1] = sc.nextInt();
        }
    }

}