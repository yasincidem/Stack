import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasin_000 on 22.8.2017.
 */
public class MinStack2 {
    List<Integer> records;
    List<Integer> mins;

    MinStack2(){
        records = new ArrayList<>();
        mins = new ArrayList<>();
    }

    public void push(int x){
        records.add(x);
        if (mins.isEmpty() || x <= mins.get(mins.size() - 1))
            mins.add(x);
    }

    public int pop(){
        if (records.isEmpty())
            throw new IllegalStateException("Stack is empty");
        int top = records.remove(size() - 1);
        if (!mins.isEmpty() && top == mins.get(mins.size() - 1))
            mins.remove(mins.size() - 1);
        return top;
    }

    public int peek(){
        if (records.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return records.get(size() - 1) ;
    }

    public int getMin(){
        if (!records.isEmpty())
            return mins.get(mins.size() - 1);
        return -1;
    }

    public int size(){
        return records.size();
    }
}
