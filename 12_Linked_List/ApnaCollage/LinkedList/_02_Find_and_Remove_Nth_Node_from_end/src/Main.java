
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
    public void deleteNthfromEnd(int n){
        // calculate size;
        int size =0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n ==size){
            head = head.next; // removeFirst
            return;
        }
        // size-n
        int i =1;
        int indToFind = size-n;
        Node prev = head;
        while(i<indToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
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
    public static void main(String[] args) {
   Main ll = new Main();
   ll.addFirst(2);
   ll.addFirst(1);
   ll.addLast(4);
   ll.addLast(5);
   ll.addMiddle(2,3);
   ll.print();
   ll.deleteNthfromEnd(3);
   ll.print();
    }
}