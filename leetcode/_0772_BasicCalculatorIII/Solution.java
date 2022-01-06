package leetcode._0772_BasicCalculatorIII;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// stack，follow-up开头带负号怎么办
class Solution {
    String s;
    int len;
    Stack<Integer> numSt;
    Stack<Character> signSt;
    Map<Character, Integer> signMap;
    public int calculate(String s) {
        // cc
        
        this.s = s;
        len = s.length();
        numSt = new Stack<>(); signSt = new Stack<>();
        signMap = new HashMap<>();
        signMap.put('+', 1); signMap.put('-', 1);
        signMap.put('*', 2); signMap.put('/', 2);
        int i = 0;
        
        addSign('(', i);
        while (i < len) { // O(N);
            char c = s.charAt(i);
            if (signMap.containsKey(c) || c == '(' || c == ')') {
                addSign(c, i++); // O(N);
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i)))
                    num = num*10 + (s.charAt(i++) - '0');
                numSt.push(num);
            } else if (c == ' ') i++;
            else throw new IllegalArgumentException();
        }
        addSign(')', i);
        
        return numSt.pop();
    }
    
    private void addSign(char sign, int idx) {
        if (sign == '(') {
            signSt.push(sign);
            if (leadingMinus(idx)) numSt.push(0);
        } else if (sign == ')') {
            while (true) {
                if (signSt.isEmpty()) throw new RuntimeException("missisng '('");
                char top = signSt.peek();
                if (top == '(') {
                    signSt.pop();
                    break;
                }
                calculate(); // 结账无脑算
            }
        } else { // signMap.contains()
            while (true) {
                if (signSt.isEmpty()) break;
                Integer val = signMap.get(signSt.peek());
                if (val == null || val < signMap.get(sign)) break;
                calculate();
            }
            signSt.push(sign); // stack算完再把新的运算符放入stack!
        }
    }
    
    private void calculate() {
        int num2 = numSt.pop(), num1 = numSt.pop();
        char sign = signSt.pop();
        numSt.push(cal(num1, num2, sign));
    }
    
    private int cal(int num1, int num2, char sign) {
        switch(sign) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: throw new RuntimeException();
        }
    }
    
    private boolean leadingMinus(int i) {
        if (i == 0 && s.charAt(i) == '-') return true;
        for (int idx = i+1; idx < len; idx++) {
            if (s.charAt(idx) != ' ') {
                if (s.charAt(idx) == '-') return true;
                else return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String s = "1+(-1+2)";
        // String s = "1+(1)";
        String s = "1";
        Solution sol = new Solution();
        System.out.println(sol.calculate(s));
    }
}

// time: O(N); space: O(N);

