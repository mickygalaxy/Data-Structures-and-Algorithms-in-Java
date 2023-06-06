public class Main {
    public static class Node{
        int data;
        Node next; // reference variable ,its point to object
        public Node(int data){ //Constructor
            this.data=data;
            this.next=null;
        }
    }
    //------------------------------------------------------------------------------------------
    // Method for add in Linked List ( add first & add Last & middle )
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
   //------------------------------------------------------------------------------------------

    // Method for Remove in a LinkedList (remove First & remove Last)
     public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

     }

     public int removeLast(){
        if(size==0){
           System.out.println("LL is empty");
        } else if (size==1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2
         Node prev = head;
         for(int i=0;i<size-2;i++){
            prev = prev.next;
         }
         int val = prev.next.data; // tail.data
         prev.next=null;
         tail = prev;
         size--;
         return val;
     }


   //------------------------------------------------------------------------------------------
    // Method for print
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
        /*
        currNode means temp
        the currNode = currNode.next; statement is changing the value of currNode,
        and doesn't make any change to the list. It doesn't change any attribute of any object.
        So it is not expected to change the list.head value.

        if you change the data of the head at the first iteration it will change the data of the currtNode because both references points to the same object.
        but the statement currNode = currNode.next;
        changes  the value of the currNode to points to the next node, so after the first iteration the two references head and currNode don't points at the same object, because that at the end of the function the head!=null
         */
    }
   //------------------------------------------------------------------------------------------
    // Method for search
      // (search for a Key in a Linked List. Return the position where it is found. if not found, return -1.)
      public int Itr_Search(int key){ //Time Complexity 0(n) linearly iterating
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){ // key found
                return i;
            }
            temp=temp.next;
            i++;
        }
        //key not found
        return -1;
      }

      // Search ( by Recursive )
        // Search for a Key in a Linked List. Return the position where it is found. if not found. return -1.Use Recursion.
    public int helper(Node head,int key){// Time Complexity 0(n) and Space Complexity 0(n) because using call stack occupied
      if(head==null){
          return -1;
      }
      if(head.data==key){
          return 0;
      }
      int idx = helper(head.next,key);
      if(idx==-1){
          return -1;
      }
      return idx+1;
    }
    public int recSearch(int key){
    return helper(head,key);
         }

   // ------------------------------------------------------------------------------------------
     // Reverse a Linked List
             // requirement 3 variables and 4 steps
    public void reverse(){ // Time Complexity 0(n)
        Node curr = tail = head;
        Node prev = null;
        Node next;
        while(curr!=null){
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
        }
        head = prev;
    }


    // ------------------------------------------------------------------------------------------


    public static Node head;
    public static Node tail;
    public static int size;
    public static void main(String[] args) {
    Main ll = new Main();
    ll.print();
    ll.addFirst(2);
    ll.print();
    ll.addFirst(1);
    ll.print();
    ll.addLast(4);
    ll.print();
    ll.addLast(5);
    ll.addMiddle(2,3);
    ll.print(); // 1->2->3->4->5
    System.out.println(ll.size);
    ll.removeFirst();
    ll.print();
    System.out.println(ll.size);
    ll.removeLast();
    ll.print();
    System.out.println(ll.size);
    System.out.println(ll.Itr_Search(3));
    System.out.println(ll.recSearch(4));
    ll.reverse();
    ll.print();
    }
}