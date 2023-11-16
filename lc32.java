import java.util.Stack;

public class lc32
//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
//        substring
//        .
{
    /**
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * @param s
     * @return
     */
    public  int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for (int i  =0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
