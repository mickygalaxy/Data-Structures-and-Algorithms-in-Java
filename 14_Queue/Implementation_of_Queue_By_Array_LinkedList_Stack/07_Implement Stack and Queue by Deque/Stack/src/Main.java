

//                                                            Implementation of Stack By Deque

/*
 ~ Time Complexity ~

Push    :- O(1)
PoP     :- O(1)
Peek    :- O(1)
isEmpty :- O(1)
 */



import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static class Stack{
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data){
            dq.addLast(data);
        }

        public void pop(){
            dq.removeLast();
        }

        public int peek(){
            return dq.getLast();
        }
        public boolean isEmpty(){
            return dq.isEmpty();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
          System.out.println("peek = "+s.peek());
           s.pop();
        }
    }
}