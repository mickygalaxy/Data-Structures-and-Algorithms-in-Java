
//                                                     Implementation of Queue By Deque

/*
 ~ Time Complexity ~
add        :- O(1)
remove     :- O(1)
Peek       :- O(1)
isEmpty    :- O(1)
 */


import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data){
            dq.addLast(data);
        }

        public void remove(){
            dq.removeFirst();
        }

        public int peek(){
            return dq.getFirst();
        }
        public boolean isEmpty(){
            return dq.isEmpty();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println("peek = "+q.peek());
            q.remove();
        }

    }
}