/**
 * Created by yasin_000 on 19.8.2017.
 */
public class BasicStack<T> {
    private T [] data;
    private int stackPointer;

    public BasicStack(int capacity){
        data = (T[]) new Object[capacity];
        stackPointer = 0;
    }

    public void push(T newItem){
        if (stackPointer == 0)
            throw new IllegalStateException("No more Stack item");
        // if (size() == data.length)
        //   throw new IllegalStateException("No more Stack item");
        data[stackPointer++] = newItem;
    }

    public T pop(){
        return data[--stackPointer];
    }

    public boolean contains(T item){
        boolean found = false;

        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }

    public T access(T item){
        while (stackPointer > 0){
            T tmpItem = pop();
            if (item.equals(tmpItem))
                return tmpItem;
        }
        throw new IllegalArgumentException("Could not find item");
    }

    public int size(){
        return stackPointer;
    }
}
