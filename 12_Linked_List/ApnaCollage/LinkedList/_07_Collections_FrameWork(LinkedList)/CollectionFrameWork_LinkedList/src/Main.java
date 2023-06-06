import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer>ll = new LinkedList<>();
        //-----------------------------------------------------------
        // add the element
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);     // add(last)
        ll.addFirst(1);    // add(first)
        ll.add(1,2);// add(position index,value)
        System.out.println(ll);
        //-------------------------------------------------------------
        // remove the element
        ll.remove(3); // remove(given the index)
        System.out.println(ll);
        ll.removeFirst(); // remove(starting element)
        System.out.println(ll);
        ll.removeLast(); // remove(Last element)
        System.out.println(ll);

    }
}