import java.util.Stack;

/**
 * Created by yasin_000 on 20.8.2017.
 */
public class SimpleBalancedParentheses {
     boolean isBalanced(String string){
        if (!(string.length()%2 == 0))
            return false;

        Stack<String> stack = new Stack<>();
        boolean balanced = true;
        int index = 0;

        while(index < string.length() && balanced){
            String symbol = Character.toString(string.toCharArray()[index]);
            if (symbol.equals("(")){
                stack.push(symbol);
            }else{
                if (stack.isEmpty()){
                    balanced = false;
                }else {
                    stack.pop();
                }
            }
            index++;
        }
        return balanced && stack.isEmpty();
    }
}
