package leetcode.ReservoirSample;

import java.util.Random;

// similar lc398. Random Pick Index
public class Solution {
    public int[] sample (int[] pool, int k) {
        // cc

        // init
        int[] sample = new int[k];
        for (int i = 0; i < k; i++) {
            sample[i] = pool[i];
        }
        // size为k的水库采样
        for (int i = k; i < pool.length; i++) {
            int rand = new Random().nextInt(i+1);
            if (rand < k) {
                sample[rand] = pool[i];
            }
        }

        return sample;
    }
}
