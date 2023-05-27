
//                           Implementation Queue By Java CollectionFrameWork

/*
Time Complexity :-

add()    O(1)
remove() O(1)
peek()   O(1)
 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class QueueB {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println("---------------------------------------");
        Queue<Integer> qq = new ArrayDeque<>();
        qq.add(1);
        qq.add(2);
        qq.add(3);
        qq.add(4);
        while(!qq.isEmpty()){
            System.out.println(qq.peek());
            qq.remove();
        }
    }
}

/*

                                                        "ArrayDeque"

The ArrayDeque class is a part of the Java Collections Framework and implements the Deque interface. It is a resizable, array-based implementation of a double-ended queue (deque), which allows elements to be added or removed from both ends.

Here are some key features and characteristics of the ArrayDeque class:

Data Structure:- ArrayDeque is implemented as a dynamic array, where elements can be efficiently inserted and removed from both ends of the deque.

Resizable Array:- The underlying array of the ArrayDeque class dynamically resizes itself as needed to accommodate the elements.

Null Elements:- Unlike some other collections in Java, ArrayDeque allows null elements to be inserted.

Performance:- ArrayDeque provides constant time performance (O(1)) for the basic operations such as adding/removing elements from both ends, accessing the first and last elements, and checking the size.

Not Thread-safe:- ArrayDeque is not thread-safe for concurrent access from multiple threads. If you need a thread-safe implementation, you can use the ConcurrentLinkedDeque class.

Usage:- ArrayDeque is commonly used in scenarios where a queue-like behavior is required, and elements need to be inserted or removed from both ends efficiently. It can also be used as a stack implementation (using the push and pop methods).
 */
