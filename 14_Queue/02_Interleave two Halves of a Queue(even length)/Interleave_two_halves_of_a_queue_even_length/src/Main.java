
//                                        Interleave  two halves of a Queue


/*
Time Complexity :- O(n)
Space Complexity :- O(n)
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static  void Solution(Queue<Integer> q){
        int size = q.size()/2;
        Queue<Integer> temp = new LinkedList<>(); // temp is FirstHalf
        for(int i =0;i<size;i++){
            temp.add(q.remove());
        }
        while(!temp.isEmpty()){
               // After the for loop, the code enters a while loop that continues until the temporary queue temp becomes empty.
              // Inside the while loop, it first removes an element from temp using temp.remove(). This element is then added back to the original queue q using q.add().
             //  Next, it removes an element from the front of the original queue q using q.remove(). This removed element is discarded (not used or added anywhere).
            //Steps 5 and 6 effectively alternate between adding an element from temp to q and removing an element from q, which rearranges the elements in q in a specific pattern.
            q.add(temp.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of queue :- ");
        int size = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        while(size-->0){
            int val;
            q.add(val = sc.nextInt());
        }
        Solution(q);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}