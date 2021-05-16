package leetcode;

public class RemoveChar {
    public String removeChar(String s) {
        if (s == null || s.length()== 0) return s;
        
        char[] c = s.toCharArray();
        int slow = 0, fast = 0;
        while (fast < s.length()) {
          // 如果不等于target则保留
          if (c[fast] != 'o') {
            c[slow] = c[fast];
            slow++;
          }
          fast++;
        }
        String res = new String(c, 0, slow); // String.vauleOf(c);
        return res;
    }

    public static void main (String[] args) {
        String s = "bigoog";
        RemoveChar remove = new RemoveChar();
        String res = remove.removeChar(s);
        System.out.println(res);
    }
}