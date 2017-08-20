import java.util.Stack;

/**
 * Created by yasin_000 on 21.8.2017.
 */
public class BalancedSymbols {
    boolean isBalanced(String string){
        Stack<String> stack = new Stack<>();
        boolean balanced = true;
        int index = 0;

        while (index < string.length() && balanced){
            String symbol = Character.toString(string.toCharArray()[index]);
            if ("({[".contains(symbol))
                stack.push(symbol);
            else{
                if (stack.isEmpty())
                    balanced = false;
                else{
                    String top = stack.pop();
                    if (!matches(top,symbol))
                        balanced = false;
                }
            }
            index++;
        }
        return stack.isEmpty() && balanced;
    }
    boolean matches(String openP, String closeP){
        String open = "([{";
        String close = ")]}";
        return open.indexOf(openP) == close.indexOf(closeP);
    }
}
