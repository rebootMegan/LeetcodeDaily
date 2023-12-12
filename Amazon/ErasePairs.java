package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class ErasePairs {
    public String solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray())  {
            // the resulting string is the shortest possible and, in case of multiple options, the lexicographically smallest.
            //This condition checks whether the character at the top of the stack can be matched later in the string (i.e., there is another occurrence of it after the current character c).
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), s.indexOf(c) + 1) != -1) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
