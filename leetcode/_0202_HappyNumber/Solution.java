package leetcode._0202_HappyNumber;

// slow fast龟兔赛跑查环
class Solution {
    public boolean isHappy(int n) {
        
        int slow = n, fast = getNext(n);
        while(fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }
    
    private int getNext(int n) {
        int val = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            val += digit * digit;
        }
        return val;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
    }
}

// time: O(log(N)) 使用math分析; spae: O(1);
