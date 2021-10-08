package OA.amazon.ParkingDilemma;

import java.util.Arrays;

// sliding windows
public class Solution {
    public static int parkingDilemma(int[] cars, int k) {
        Arrays.sort(cars);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cars.length-k+1; i++) {
            res = Math.min(res, cars[i+k-1] - cars[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cars = {12,6,5,2};
        int k = 3;
        System.out.println(Solution.parkingDilemma(cars, k)); // 5
    }
}
