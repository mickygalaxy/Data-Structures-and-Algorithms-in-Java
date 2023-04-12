


//                                         Palindrome LinkedList

/*
Time Complexity : o(n)
Space Complexity: o(n)
 */

import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);

    static  class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static boolean checkPalindrome(Node head){
        Stack<Integer>s = new Stack<>();
        Node slow = head;
        boolean isPalindrome = true;
        while(slow!=null){
            s.push(slow.data);
            slow= slow.next;

        }

        while(head!=null){
           int i = s.pop();
           if(i==head.data){
             isPalindrome = true;
           }
           else{
               isPalindrome = false;
               break;
           }
           head = head.next;

    }
        return isPalindrome;
    }

    public static boolean check(Node head){ // only small change that is compression steps reduces
        Node slow = head;
        Node fast = head.next;
        Stack<Integer> s = new Stack<>();
        boolean isPalindrome = true;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            s.push(slow.data);
            slow = slow.next;
        }
        s.push(slow.data);
        head = slow;
        while(head!=null){
            int i = s.pop();
            if(i==head.data){
                isPalindrome = true;
            }
            else{
                isPalindrome = false;
                break;
            }
            head = head.next;

        }
        return isPalindrome;

    }




    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(1);
        head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
  System.out.println(checkPalindrome(head));
  System.out.println(check(head));
    }

}