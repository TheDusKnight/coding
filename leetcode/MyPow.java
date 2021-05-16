package leetcode;

// S1: brute force: primitive recursion or while to do n times x -> O(n)
// S2: recursion binary reduction
// S3: recursion reuse
public class MyPow {
    // public int myPow(int x, int n) {
    //     // cc
    //     if (n <= 0) throw new IllegalArgumentException();
    //     int res = x;
    //     while (n-- > 1) {
    //         res = res*x;
    //     }
    //     return res;
    // }

    // public int myPow(int x, int n) {
    //     // cc
    //     if  (n <= 0) throw new IllegalArgumentException();
    //     if (n == 1) return x;

    //     return myPow(x, n/2) * myPow(x, n-n/2);
    // }

    public long myPow(int x, int n) {
        // cc
        if (n <= 0) throw new IllegalArgumentException();
        if (n == 1) return x;

        long tmp = myPow(x, n/2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }

    public static void main(String[] args) {
        int x = 2, n = 50;
        MyPow test = new MyPow();
        System.out.println(test.myPow(x, n));
    }
}
// time: 