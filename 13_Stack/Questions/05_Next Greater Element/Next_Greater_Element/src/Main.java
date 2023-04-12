

//                                    Next Greater Element using Stack approach

/*
 # Its have Four Form Question by using Stack
  ~ Next Greater Right
      => you see below the code
  ~ Next Greater Left
      => small changes below the code
          line 56
             for(int i=0;i<size;i++)
  ~ Next Small Right
      => small changes below the code
          line 61
              for(int i=size-1;i>=0;i--)
              while(!s.isEmpty() && array[s.peek()]<=array[i])
  ~ Next Small Left
      => small changes below the code
          line 56 61
              for(int i=0;i<size;i++)
              while(!s.isEmpty() && array[s.peek()]>=array[i])
 */












import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void BruteForceApproach(int[]arr){ // Time Complexity :- O(n*n)  and Space Complexity :- O(n)
        int[]nextGreater = new int[arr.length]; // its store the next greater element
        Arrays.fill(nextGreater,-1); // initially filling element by -1
        for(int i=0;i<arr.length-1;i++){  // using nested loop
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<=arr[j]){  // checking the right side greater element present or not
                    nextGreater[i]=arr[j]; //its present then store the that value into the nextGreater
                    break; // be gated the element then stop iterating right side  go next index to find next greater for them.
                }

            }
        }
        for(int i:nextGreater){ // displaying all greater element
            System.out.print(i+" ");
        }
    }
 public  static  void OptimalApproachByUsingStack(int[]array,int size){ //Time Complexity :- O(n) [ 2*n ]
     Stack<Integer>s = new Stack<>(); //using Stack to overcome time complexity
     int[] NextGreater = new int[size];  // its store the next greater element
     for(int i=size-1;i>=0;i--){ // iterating right to left
     while(!s.isEmpty() && array[s.peek()]<=array[i]){ // check current index value is greater than stack top ,so you have remove that top when do not get the grater value.
         s.pop(); // removing top value or index
     }
     if(s.isEmpty()){ // checking stack is empty or not,isEmpty so right side is not any greater element.
         NextGreater[i]= -1; // store -1 value . -1 represent no one element exist
     }
     else{
         NextGreater[i]= array[s.peek()]; // stack is not empty so mean there are present greater element and store that value inside the NextGreater
     }
     s.push(i); // push the current index
     }
     for(int i:NextGreater){ // displaying all greater element
         System.out.print(i+" ");
     }
 }

    public static void main(String[] args) {
        System.out.print("Enter the Size of Array :- ");
        int size = sc.nextInt();
        int[] array =new int[size]; // Array declaration
        for(int i=0;i<size;i++){ // taking array input by user
            array[i]=sc.nextInt();
        }
        System.out.println("\n----------------------------------------------------------------\n");
        System.out.println("\n-----------------------Brute Force Approach---------------------\n");
        // Brute Force Approach
        BruteForceApproach(array); // calling bruteforce approach
        System.out.println("\n----------------------------------------------------------------\n");
        System.out.println("\n------------------Optimal Approach By Using Stack-----------------\n");
        // Optimal Approach By Using Stack
        OptimalApproachByUsingStack(array,size); // calling optimal approach
        System.out.println("\n----------------------------------------------------------------\n");


    }
}