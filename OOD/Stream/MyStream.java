package OOD.Stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args) {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n1 = 0;
    int n2 = 1;

    public Integer get() {
        int n3 = n1 + n2;
        n1 = n2;
        n2 = n3;

        return n1;
    }
}

