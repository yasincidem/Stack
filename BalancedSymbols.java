import java.util.Stack;

/**
 * Created by yasin_000 on 21.8.2017.
 */
public class BalancedSymbols {
     //////////////////////////////////////////////
     ////https://www.hackerrank.com/challenges/balanced-brackets
     ////https://interactivepython.org/runestone/static/pythonds/BasicDS/BalancedSymbols(AGeneralCase).html
     ////https://leetcode.com/problems/valid-parentheses/discuss/
     ////
     /////////11111111111//////////////////////
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
    
    ////////22222222222222222//////////////////////////
    boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q);
        }
        return p.isEmpty();
    }
    
    ///////////3333333333333333////////////////////////
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.isEmpty();
    }
    
    ////////44444444444444////////////////////////////////
    boolean isValid(String string){
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
