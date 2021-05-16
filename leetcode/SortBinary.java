package leetcode;

public class SortBinary {
    public int[] sortBinary(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int left = 0, right = nums.length-1;
        while (left < right) { // 左右越过
            if (nums[left] == 1) left++;
            if (nums[right] == 0) right--;
            if (nums[left] == 0 && nums[right] == 1) {
                swap(nums, left, right);
                // swap后left一定是1，right一定是0所以left++和right--由下一个loop完成
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        SortBinary test = new SortBinary();
        int[] sort = test.sortBinary(new int[] {0,0,0,1,1,1,0,1,0});
        for (int s: sort) {
            System.out.print(s);
        }
    }
}
