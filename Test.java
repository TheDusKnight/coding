import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        int tmp = 5 % 2;
        int[] cool = new int[2];
        int[] newCool = Arrays.copyOf(cool, cool.length * 2);

        // System.out.println(s2.compareTo(s1));
        // System.out.println(Arrays.toString(newCool));
        // System.out.println((s1.charAt(0) - 'a'));
        // int[][] array = new int[2][];
        // int len = array[0].length;
        // System.out.println(Arrays.toString(array));
        // String temp = array.toString();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // map.put(1,4);
        // System.out.println(map.get(0));
        // System.out.println(12 << 2);
        // System.out.println(12 >> 2);
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println("123".substring(0, 2));


        // char to int两种方法
        System.out.println(Character.getNumericValue('1') + 1);
        // System.out.println('1' - '0' + 1);

        // int to char
        // char t = 1 + '0';
        // System.out.println(t);
        
        // int to String
        // String s = 1 + "k";
        
    }

}
