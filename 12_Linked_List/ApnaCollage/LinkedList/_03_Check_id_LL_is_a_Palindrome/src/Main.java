// Q) Find & Remove Nth node from End.
//Using Iterative Approach 0(n)
public class Main {
    public static class Node{
        int data; 
        Node next; // reference variable ,its point to object 
        public Node(int data){ //Constructor
            this.data=data;
            this.next=null; 
        }
    }

    public void addFirst(int data){ // Time complexity :- 0(1)  constant time for adding
        // step1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        // step2 = newNode next = head
        newNode.next=head; //Link
        // step3 =  head = newNode

        head = newNode;
    }

    public void addLast(int data){ // Time Complexity :- 0(1) constant time
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void addMiddle(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        // i == idx-1 ; temp->prev
        newNode.next = temp.next;
        temp.next=newNode;
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
        System.out.println("null");
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public Node findMid(Node head){ // helper function
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow; // slow is my midNode
    }
   public boolean checkPalindrone(){
       if(head == null || head.next == null) {
           return true;
       }
       // step-1 find mid
       Node midNode = findMid(head);
       // step-2 reverse 2nd half
       Node prev = null;
       Node curr = midNode;
       Node next;
       while(curr!=null){ // half of the LL reverse
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr=next;
       }
       Node right = prev; //right half head
       Node left = head;
       // step-3 check left half & right half

       while(right!=null){
           if(left.data != right.data){
               return false;
           }
           left = left.next;
           right = right.next;
       }
       return true;
   }


    public static void main(String[] args) {
        Main ll = new Main();
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(4);
     //   ll.addLast(4);


        ll.print(); // 4-> 5 -> 5-> 4
        System.out.println(ll.checkPalindrone());
    }}
