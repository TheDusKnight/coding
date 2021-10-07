package leetcode._0526_BeautifulArrangement;

// dfs
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        if (n <= 0) return -1;
        
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        
        dfs(arr, 0);
        return count;
    }
    
    private void dfs(int[] arr, int idx) {
        if (idx == arr.length) { // 答案出在leave node挂着null
            count++;
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            // 每次确定一个点，检查当前点是否valid，提前剪枝
            if (arr[idx] % (idx + 1) == 0 || (idx + 1) % arr[idx] == 0)
                dfs(arr, idx+1);
            swap(arr, i, idx);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

// time: worst case O(N!);
