



//                                                           doubly linked list


public class Main {

    public class Node{
        int data;
        Node next; 
        Node prev; 

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
public static Node head;
public static Node tail;
public static int size;
/*
Basic Operations
Insertion − Adds an element at the beginning of the list.
Deletion − Deletes an element at the beginning of the list.
Insert Last − Adds an element at the end of the list.
Delete Last − Deletes an element from the end of the list.
Insert After − Adds an element after an item of the list.
 */
// add First
 public void addFirst(int data){
     Node newNode = new Node(data);
     size++;
     if(head==null){
         head=tail=newNode;
         return;
     }
     newNode.next = head;
     head.prev = newNode;
     head = newNode;
 }

 // add Last

    public void addLast(int data) {
     Node newNode = new Node(data);
     size++;
    if(head==null){
        head=tail=newNode;
        return;}

    Node temp = head;
    while(temp.next!=null){
        temp=temp.next;
    }
    temp.next=newNode;
    newNode.prev = temp;
    newNode.next = null;

        }



        //print
    public void print(){
       Node temp = head;
       while(temp != null){
           System.out.print(temp.data + "<->");
           temp = temp.next;
       }
        System.out.println("null");
    }





// remove
public int removeFirst(){
     if(head==null){
         System.out.println("Dll is empty");
         return Integer.MIN_VALUE;
     }
     if(size==1){
         int val = head.data;
         head = tail = null;
         return val;

     }
     int val = head.data;
     head = head.next;
     head.prev = null;
    size--;
     return val;

}

// remove last
public int removeLast(){
    if(head==null){
        System.out.println("Dll is empty");
        return Integer.MIN_VALUE;
    }
    if(size==1){
        int val = head.data;
        head = tail = null;
        return val;

    }
    Node temp = head;
    while(temp.next!=null){
        temp = temp.next;
    }
    int val = temp.data;
    tail = temp.prev;
    tail.next = null;
    return val;
}
// Reverse the doubly LinkedList
    public void reverseDll(){
     Node curr = head;
     Node prev = null;
     Node next;
     while(curr!=null){
         next=curr.next;
         curr.next = prev;
         curr.prev = next;
         prev = curr;
         curr = next;
     }
     head = prev;
    }




    public static void main(String[] args) {
    Main doublyLL = new Main();
    doublyLL.addFirst(3);
    doublyLL.addFirst(2);
    doublyLL.addFirst(1);
    doublyLL.print();
    System.out.println(size);
    doublyLL.removeFirst();
    doublyLL.print();
    System.out.println(size);
    doublyLL.addLast(5);
    doublyLL.print();
    doublyLL.removeLast();
    doublyLL.print();
        doublyLL.addFirst(5);
        doublyLL.addFirst(4);
        doublyLL.addFirst(6);
        doublyLL.print();
    doublyLL.reverseDll();
    doublyLL.print();

    }
}
