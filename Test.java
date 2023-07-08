
/** check boolean可以不写== true or == false，但check null必须写 */
/** getOrDefault如果返回新的数据结构，记得要put回去否则不会保存在HashMap或HashSet里!! */
/** LinkedList remove API input为int是remove by index，input为Object是remove by Element */
import java.util.*;

class Node {
    int key;
    int val;
    Node next;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class Test {
    public static void main(String[] args) {
        /**
         * Arrays.sort() inplace sort array, 注意如果array type是primitive 不能改写comparator 函数
         */
        /** Arrays.sort() 如何反向sort？class才能用lambda表达式反响sort，将int[]换成Integer[] */

        /** Collections.sort() inplace sort List */

        /** shallow copy vs deep copy */
        // int[] cool = new int[2];
        /** copyOf必须有长度 */
        // int[] newCool = Arrays.copyOf(cool, cool.length * 2);
        // System.out.println(Arrays.toString(newCool));
        // clone可以叫shallow copy也可以叫deep copy，但它的本质是call array dereference后的第一层

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

        /** create array of arrayList */
        // List<Integer>[] tmp = new List[3];
        // for (int i = 0; i < tmp.length; i++) { // 另一种写法：Arrays.setAll(tmp, element ->
        // new ArrayList<>());
        // tmp[i] = new ArrayList<>();
        // }

        /** 反转arrayList */
        // Collections.reverse(tmp);

        /** convert arrayList to array使用toArray方法 */

        /**
         * 不存在convert List<Integer> to int[]的简单方法，toArray()的array对象必须是Object type。int[]
         * array = list.stream().mapToInt(i->i).toArray();
         */

        /** convert list of array to array of array */
        // List<int[]> list = new ArrayList<>(); //
        // 这种方法能成功的原因在于toArray()的array对象必须是Object type
        // int[][] array = list.toArray(new int[2][]); // 返回类型和传入类型match

        /** HashSet转ArrayList */
        // List<Integer> list = new ArrayList<>().addAll(hashSet);

        /** computeIfAbsent */
        // java8之前。从map中根据key获取value操作可能会有下面的操作
        // Object key = map.get("key");
        // if (key == null) {
        // key = new Object();
        // map.put("key", key);
        // }
        // java8之后。上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
        // Object key2 = map.computeIfAbsent("key", k -> new Object());

        /** bit operations */
        // System.out.println(12 << 2);
        // System.out.println(12 >> 2);
        // System.out.println((1 << 2) - 1);
        // System.out.println(5 ^ 7);

        // int to bits
        // System.out.println("i: " + String.format("%32s",
        // Integer.toBinaryString(2)).replaceAll(" ", "0"));

        /** substring 左闭右开区间 */
        // System.out.println("123".substring(0, 2));

        /** Difference between Arrays.asList() and List.of() */
        // Integer[] nums = {1,2,3}; // nums不能是int[]，必须是Integer[]
        // List<Integer> list = Arrays.asList(nums);
        // List<Integer>[] res = new List[200];
        // List<Integer> list = Arrays.asList(1, 2, null); // mutable, allow null
        // list.set(1, 10); // OK
        // List<Integer> list2 = List.of(1, 2, 3); // immutable, doesn't allow null
        // list2.set(1, 10); // Fails with UnsupportedOperationException

        /** char to int两种方法 */
        // System.out.println(Character.getNumericValue('1') + 1);
        // System.out.println('1' - '0' + 1);

        /** int to char */
        // char t = 1 + '0'; // sb.append的时候一定要注意类型转换
        // System.out.println(t);

        /** int to String */
        // String s = 1 + "k";
        // String k = String.valueOf(1) + "k";

        /* String to int */
        // System.out.println(Integer.parseInt("55"));
        /* String to Integer */
        // System.out.println(Integer.valueOf("55"));

        /** 使用Random，注意bound是exclude */
        // Random rand = new Random();
        // System.out.println(rand);

        /** convert hashmap values to ArrayList */
        // new ArrayList<>(map.vaues());

        // System.out.println(Integer.toBinaryString(-2147483648+1));
        // System.out.println(Integer.toBinaryString(99));
        // System.out.println(Integer.toBinaryString(49));
        // System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        // System.out.println(Math.abs(Integer.MIN_VALUE));
        // System.out.println(-1/2);

        // System.out.println(1 << 2);

        // Integer[] intergers = new Integer[3];
        // int[] a = new int[3];
        // a[0]++;
        // System.out.println(a[0]);
        // System.out.println('R' - 'A' + 1);

        // System.out.println(foo(12));

        // System.out.println(0 ^ 0);
        // System.out.println(getString(-9872631));
        // System.out.println(key);

        // Node node = new Node();
        // System.out.println(node.key);

        // double x = 1.0 / 10;
        // double y = 1 - 9.0 / 10;
        // double z = 1.0 / 0;
        // System.out.println(x);
        // System.out.println(y);
        // System.out.println(z);

        // System.out.println(String.format(Locale.US, "%03d", 21));

        List<String> list = Arrays.asList("1", null, "3");
        for (String s : list) {
            System.out.println(s);
        }
    }

    // public static int foo(int n) {
    // System.out.println(key);
    // }

    private static String getString(int input) {
        boolean isNegative = false;
        if (input < 0) {
            isNegative = true;
            input = -input;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (input > 0) {
            int digit = input % 10;
            input /= 10;
            sb.append((char) (digit + '0'));
            count++;
            if (count % 3 == 0)
                sb.append(',');
        }

        if (isNegative)
            sb.append('-');
        return sb.reverse().toString();
    }

}
