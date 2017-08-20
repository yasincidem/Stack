import java.util.Stack;

/**
 * Created by yasin_000 on 21.8.2017.
 */
public class BalancedSymbols2 {
    boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
