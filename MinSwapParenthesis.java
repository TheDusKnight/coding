import java.util.Stack;

public class MinSwapParenthesis {
    public static int swapString(String s) {
        // cc

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
        }
        if (count != 0) return -1;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String s = "())(()";
        System.out.println(MinSwapParenthesis.swapString(s));
    }
}
