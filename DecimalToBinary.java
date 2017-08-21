/**
 * Created by yasin_000 on 21.8.2017.
 */
public class DecimalToBinary {
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
    String baseConverter(int decNumber,int base){
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        char [] digits = "0123456789ABCDEF".toCharArray();
        while (decNumber > 0){
            int rem = decNumber % base;
            stack.push(rem);
            decNumber = decNumber/base;
        }
        String binString = "";
        while (!stack.isEmpty())
            binString += digits[stack.pop()];
        return binString;
    }
}
