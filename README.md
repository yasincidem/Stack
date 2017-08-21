# Stack
![](https://www.tutorialspoint.com/data_structures_algorithms/images/stack_representation.jpg)
### # LIFO(Last-In-First-Out)
## Examples
* Stacks of plates
* Trains
* Vending Machines
* Expression Evaluation
* Matching delimiters
* Navigating a maze
* Map coloring
* Many more examples

## Videos
[freeCodeCamp-Stacks ](https://www.youtube.com/watch?v=Gj5qBheGOEo)

## Representations
Wrapper around a built-in list object
Array-based, bounded or expandable (All operations in Θ(1) except search and access)

![](https://lh4.googleusercontent.com/O8yuUkkJRBQrWAELm-tVLxWFIM9QwdOibRD_PnE8tACmPZrlR394iT_yS7sXPwr39F-1kzqSYY-DL8Y=w1366-h627)

Linked (All operations in Θ(1) except search and access)

![](https://lh3.googleusercontent.com/C8pwEREUQPiGMbxp-EYF6FsT1g9qL4PKrfW1H9_yRf8Ykw9X1AKhuOSeEPwcwHeqd5MVaDhz_jsvVBo=w1366-h627)

## Stacks in Java

The Java Core API has a stack class in the package java.util but you should avoid it since it subclasses Vector and thus has a bunch of non-stack operations (this is a major design flaw in the library), and it is (perhaps unnecessarily) synchronized making it slow (though always thread-safe).

Regardless, you should learn how to build a stack ADT from scratch, because:

* This is the only way for you to really learn how stacks work
* You need coding practice, especially with linked structures
* You need to know how to code things up when you find yourself in a very restrictive environment that doesn't have a collections library.

`

    public interface Stack {

    /**
     * Adds the given item to the top of the stack.
     */
    void push(Object item);

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    Object pop();

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    Object peek();

    /**
     * Returns the number of items currently in the stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty();
    }

`
## The Trivial Wrapper Implementation

One way to make our own stack is to make a wrapper around the existing LinkedList class.
`

    public class SimpleStack implements Stack {
       private LinkedList<Object> list = new LinkedList<Object>();

       public void push(Object item) {list.addFirst(item);} //push()
       public Object pop() {return list.removeFirst();}  //pop()
       public Object peek() {return list.getFirst();} //peek()
       public int size() {return list.size();}
       public boolean isEmpty() {return list.isEmpty();}
    }

`
This is a common design pattern and all developers are expected to know how to do this. Terminology associated with this technique:

* "The stack wraps the list"
* "The list is being adapted to use in a stack context"
* "The stack delegates to the list"
* "The list interface is being narrowed to that of a stack"

## A Bounded Array Implementation

Things to note here:

* The capacity is set at creation time
* Pushes have a precondition that the stack isn't already full
* Pushing on a full stack is a state exception, not an argument exception
* The field for the current size doubles as the index of the next item to be pushed, and
* When popping, we take care to nullify the newly unused slot in the array to prevent a possible memory leak

`

    public class BoundedStack implements Stack{
    private Object[] array;
    private int size = 0;

    public BoundedStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full stack");
        }
        array[size++] = item;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from empty stack");
        }
        Object result = array[size-1];
        array[--size] = null;
        return result;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty stack");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    }

`

## A Linked Implementation

`

    /**
    * An implementation of the stack interface using singly-linked
    * nodes.
    */
    public class LinkedStack implements Stack {
    private class Node {
        public Object data;
        public Node next;
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;

    public void push(Object item) {
        top = new Node(item, top);
    }

    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }
    }

`
![](https://lh5.googleusercontent.com/ZQM4oYzwHg6SWz4I0nUON7_cTMdZCaDAyrQ635QUfXGOJl-IWStqWq4kM5_mvdO-hzqvkNG96BR2keQ=w1366-h676)
