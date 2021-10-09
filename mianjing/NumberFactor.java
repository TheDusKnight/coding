package mianjing;

import java.util.ArrayList;
import java.util.List;

// LinkedIn phone
public class NumberFactor {
    public static List<Integer> factor(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                res.add(i);
                res.add(num / i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberFactor.factor(12));
    }
}

// time: O(sqrt(N)); space: O(1);
