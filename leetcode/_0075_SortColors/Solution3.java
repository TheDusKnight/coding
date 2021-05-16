package leetcode._0075_SortColors;

// count sort
public class Solution3 {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        
        for (int num: nums) {
            arr[num]++;
        }

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}

// time: O(n)
// space: O(1)