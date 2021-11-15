package mianjing.amazon_oa.BalancedString;

// array delta brute force
// 这题应该可以用dp但不会写
public class Solution {
    public int balancedString(String s) {
        // cc
        char[] chars = s.toCharArray();
        int count = 0;

        for (int i = 2; i <= chars.length-1; i+=2) {
            if (isBalanced(s, 0, i-1) && isBalanced(s, i, chars.length-1))
                count++;
        }
        return count;
    }

    private boolean isBalanced(String s, int begin, int end) {
        int parentDelta = 0, squareDelta = 0, wildcard = 0;

        for (int i = begin; i <= end; i++) {
            char c = s.charAt(i);
            if (c == '(') parentDelta++;
            if (c == ')') parentDelta--;
            if (c == '[') squareDelta++;
            if (c == ']') squareDelta--;
            if (c == '?') wildcard++;
        }

        int remains = wildcard - Math.abs(parentDelta) - Math.abs(squareDelta);
        if ((remains >= 0) && (remains % 2 == 0)) // remove && remains % 2 == 0?
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Should be 0: " + sol.balancedString("(((?"));
        System.out.println("Should be 1: " + sol.balancedString("(())(?"));
        System.out.println("Should be 0: " + sol.balancedString("[[))()"));

        System.out.println("Should be 1: " + sol.balancedString("(?]["));
        System.out.println("Should be 1: " + sol.balancedString("[](?"));
        System.out.println("Should be 1: " + sol.balancedString("][(?"));
        // System.out.println("Should be 2: " + sol.balancedString("[(?][??["));
        System.out.println("Should be ?: " + sol.balancedString("[(?][??[??"));
    }
}

// time: O(n^2)