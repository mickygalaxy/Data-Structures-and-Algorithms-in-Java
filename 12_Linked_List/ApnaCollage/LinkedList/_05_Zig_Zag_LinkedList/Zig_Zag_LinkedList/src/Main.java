
//                         Zig- Zag Linked List

public class Main {

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){ // Time complexity :- 0(1)  constant time for adding
        // step1 = create new node
        Node newNode = new Node(data);

        if(head==null){
            head = tail = newNode;
            return;
        }
        // step2 = newNode next = head
        newNode.next=head; //Link
        // step3 =  head = newNode

        head = newNode;
    }

    public void print(){ // Time Complexity :- 0(n) its taking linear time.
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){ // traverse the node one by one upto be not get the next=null.
            System.out.print(temp.data+"->"); // print the data
            temp = temp.next; // temp is increment the by one node for print next node
        }
        System.out.println("null");}


    public void zigzag(){
        // find middle
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid =slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;
        // alt-marge - zig-zag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }
    public Node head;
    public Node tail;
    public static void main(String[] args) {
Main ll = new Main();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}