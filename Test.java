public class Test {
    public static void main(String[] args) {
        /** Arrays.sort() inplace sort */

        /** shallow copy vs deep copy */
        // int[] cool = new int[2];
        // int[] newCool = Arrays.copyOf(cool, cool.length * 2);
        // System.out.println(Arrays.toString(newCool));

        /** method pass by value */
        // int n = 0;
        // foo(n);
        // System.out.println(n);

        /** Math强制类型转换 */
        // System.out.println((int)Math.pow(2, 5));

        /** compare 函数 */
        // String s1 = "a";
        // String s2 = "b";
        // System.out.println(s2.compareTo(s1));

        /** bit operations */
        // System.out.println(12 << 2);
        // System.out.println(12 >> 2);
        // System.out.println((1 << 2) - 1);

        /** substring 左闭右开区间 */
        // System.out.println("123".substring(0, 2));

        /** Difference between Arrays.asList() and List.of() */
        // List<Integer> list = Arrays.asList(1, 2, null); // mutable, allow null
        // list.set(1, 10); // OK
        // List<Integer> list2 = List.of(1, 2, 3); // immutable, doesn't allow null
        // list2.set(1, 10); // Fails with UnsupportedOperationException

        /** char to int两种方法 */
        // System.out.println(Character.getNumericValue('1') + 1);
        // System.out.println('1' - '0' + 1);

        /** int to char */
        // char t = 1 + '0';
        // System.out.println(t);

        /** int to String */
        // String s = 1 + "k";

        /* String to int */
        // System.out.println(Integer.parseInt("55"));
        /* String to Integer */
        System.out.println(Integer.valueOf("55"));
    }

    public static void foo(int n) {
        n++;
    }
}
