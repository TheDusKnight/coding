package leetcode;

public class CheckUnique {
    public static boolean checkUnique(char[] chars) {
        try {
            // cc
            if (chars == null) {
                throw new IllegalArgumentException();
            }
            int[] bitSet = new int[8];
            for (char c : chars) {
                int i = c / 32;
                int j = c % 32; // 注意bitSet反着存
                if ((bitSet[i] & 1 << j) != 0)
                    return false;
                else {
                    bitSet[i] |= 1 << j;
                }
            }
            
        } catch (IllegalArgumentException e) {
            // do something
            System.out.println(e.getMessage());
            e.printStackTrace();
            // Logger.log(e); // Singleton
        } catch (Exception ex) {
            // do sth
            System.out.println(ex.getMessage());
        } // 可以再加个finally用来释放资源之类的

        return true;
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', '+', 'b', 'e' };
        // char[] chars = {'a', 'b', '+', 'e'};
        boolean res = CheckUnique.checkUnique(chars);
        System.out.println(res);
    }
}
