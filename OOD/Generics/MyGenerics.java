package OOD.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyGenerics {
    List<String> list = new ArrayList<>();
    List<String> list2 = list;
    String[] arr;

    public MyGenerics() {
        list2.add("hello");
        arr = new String[] {"Bob", "Cat"};
    }

    public static void main(String[] args) {
        MyGenerics myGenerics = new MyGenerics();
        System.out.println(myGenerics.list.get(0));
        Arrays.sort(myGenerics.arr);
    }
}
