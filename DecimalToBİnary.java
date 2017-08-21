/**
 * Created by yasin_000 on 21.8.2017.
 */
public class DecimalToBİnary {
    static String divideby2(int decNumber){
        StackLinkedList<Integer> stack = new StackLinkedList<>();

        while (decNumber > 0){
            int rem = decNumber % 2;
            stack.push(rem);
            decNumber = decNumber/2;
        }
        String binString = "";
        while (!stack.isEmpty())
            binString += Integer.toString(stack.pop());
        return binString;
    }
}
