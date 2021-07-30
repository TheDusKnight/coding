package leetcode;

public class XueHua {
    public static void xueHua(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        
        for (int i = 1; i <= n; i++) {
            int front = n-i;
            while (front-- > 0) {
                System.out.print(" ");
            }
            int center = i;
            while (center-- > 0) {
                System.out.print("*");
                System.out.print(" ");
            }
            int end = n-i;
            while (end-- > 1) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        for (int i = n-1; i >= 1; i--) {
            int front = n-i;
            while (front-- > 0) {
                System.out.print(" ");
            }
            int center = i;
            while (center-- > 0) {
                System.out.print("*");
                System.out.print(" ");
            }
            int end = n-i;
            while (end-- > 1) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        XueHua.xueHua(3);
    }
    
}
