/**
 * Created by yasin_000 on 21.8.2017.
 */
public class MinStack {

    Node top;
    int size = 0;

    public void push(int x) {
        size++;
        if(top == null) {
            top = new Node(x);
        }
        else {
            Node temp = new Node(x);
            temp.next = top;
            temp.min = Math.min(top.min, x);
            top = temp;
        }
    }

    public void pop() {
        if(top == null) {
            System.out.println("Stack empty!");
            return;
        }

        top = top.next;
        size--;
    }

    public int top() {
        if(top == null) {
            System.out.println("Stack empty!");
            return Integer.MAX_VALUE;
        }

        return top.value;
    }

    public int min() {
        if(top == null) {
            System.out.println("Stack empty!");
            return Integer.MAX_VALUE;
        }
        return top.min;
    }

}

class Node {
    int value;
    int min;
    Node next;

    Node(int x) {
        value = x;
        next = null;
        min = x;
    }
}