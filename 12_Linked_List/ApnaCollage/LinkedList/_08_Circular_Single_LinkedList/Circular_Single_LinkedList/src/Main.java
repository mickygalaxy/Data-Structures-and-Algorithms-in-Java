import java.util.Scanner;

public class Main {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
//    class DoublyNode {
//           Node node;
//           DoublyNode prev;
//           public DoublyNode(int data){
//               new Node(data);
//              this.prev=null;
//           }
//    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null && tail==null){
            head = tail = newNode;
            return;
        }

    }

    private static Node head;
    private static Node tail;
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);



    }
}