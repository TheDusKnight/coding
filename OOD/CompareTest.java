package OOD;

import java.util.Comparator;
import java.util.PriorityQueue;
public class CompareTest {
    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String l1, String l2) {
            return l1.compareTo(l2);
        }
        
        // @Override
        // public int compare(String s1, String s2) {
        //     return s1.compareTo(s2);
        // }
    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o2-o1;
        //     }
        // }); 

        int k = 100;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> (o2-o1));

        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(0);
        queue.offer(3);
        queue.offer(4);
        queue.offer(7);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.print(cur+" ");
        }
    }
}