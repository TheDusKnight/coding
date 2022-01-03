package leetcode._0772_BasicCalculatorIII;

import java.util.HashMap;
import java.util.Stack;

// stack，follow-up开头带负号怎么办
class Solution {
    HashMap<Character, Integer> optrMap;
    public int calculate(String s) {
        // cc

        int len = s.length();
        optrMap = new HashMap<>();
        optrMap.put('+', 1); optrMap.put('-', 1);
        optrMap.put('*', 2); optrMap.put('/', 2);
        Stack<Integer> numSt = new Stack<>();
        Stack<Character> optrSt = new Stack<>();
        int i = 0;
        addOptr(numSt, optrSt, s, i, '(');
        while (i < len) { // O(N)
            char ch = s.charAt(i);
            if (optrMap.containsKey(ch) || ch == '(' || ch == ')') {
                addOptr(numSt, optrSt, s, i, ch); // O(N)
                i++;
            } else if (ch >= '0' && ch <= '9') {
                int val = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    val = val * 10 + (s.charAt(i++) - '0');
                numSt.push(val);
            } else if (ch == ' ') i++;
            else throw new RuntimeException("contains invalid character");
        }
        addOptr(numSt, optrSt, s, i, ')');

        return numSt.pop();
    }

    private void addOptr(Stack<Integer> numSt, Stack<Character> optrSt, String s, int i, char optr) {
        if (optr == '(') {
            optrSt.push(optr);
            if (leadingMinus(s, i)) numSt.push(0);
        } else if (optr == ')') {
            while (true) {
                if (optrSt.isEmpty())
                    throw new RuntimeException("missing '(");
                char top = optrSt.peek();
                if (top == '(') {
                    optrSt.pop();
                    break;
                }
                calculate(numSt, optrSt); // 结账无脑算
            }
        } else { // optrMap.contains()
             while (true) {
                if (optrSt.isEmpty()) break;
                char top = optrSt.peek();
                Integer topWei = optrMap.get(top);
                if (topWei == null || topWei < optrMap.get(optr)) break;
                calculate(numSt, optrSt);
             }
             optrSt.push(optr); // stack算完再把新的运算符放入stack!
        }
    }

    private void calculate(Stack<Integer> numSt, Stack<Character> optrStack) {
        int num2 = numSt.pop(), num1 = numSt.pop();
        char optr = optrStack.pop();
        numSt.push(cal(num1, num2, optr));
    }

    private int cal(int num1, int num2, char optr) {
        switch(optr) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: throw new RuntimeException();
        }
    }

    private boolean leadingMinus(String s, int i) {
        if (i == 0 && s.charAt(i) == '-') return true;
        for (int j = i+1; j < s.length(); j++) {
            if (s.charAt(j) != ' ') {
                if (s.charAt(j) == '-') return true;
                else return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "1+(-1+2)";
        Solution sol = new Solution();
        System.out.println(sol.calculate(s));
    }
}

// time: O(N); space: O(N);

