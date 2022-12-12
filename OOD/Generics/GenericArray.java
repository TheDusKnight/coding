package OOD.Generics;

public class GenericArray {
    public static void main(String[] args) {
        // 这不是泛型array
        // Pair[] ar = new Pair[2];

        // 不能直接用泛型new，会导致类型擦拭
        Pair<String>[] arr = (Pair<String>[]) new Pair[2];
        arr[0] = new Pair<String>("a", "b");
        // ar[1] = new Pair<Integer>(1, 2);
        System.out.println(arr[0].getFirst());
        // 泛型不能用于显性地引用运行时类型的操作之中，
        // 例如转型，instanceof和new操作（包括new一个对象，new一个数组），
        // 因为所有关于参数的类型信息都在运行时丢失了，
        // 所以任何在运行时需要获取类型信息的操作都无法进行工作。
        // 导致String的信息丢失程序出错
        // Pair<String>[] ps = new Pair<String>[2];
    }
}
