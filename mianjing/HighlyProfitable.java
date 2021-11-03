package mianjing;

// 
public class HighlyProfitable {
    int res = 0;
    public int profitable(int[] arr, int k) {
        // cc

        dfs(arr, k, 1, 1);
        return res;
    }

    private void dfs(int[] arr, int k, int count, int idx) {
        if (count == k) {
            res++;
        }
        if (idx >= arr.length || count > k) return;

        if (arr[idx] <= arr[idx-1]) {
            dfs(arr, k, 1, idx+1);
            return;
        }

        count++;
        dfs(arr, k, count, idx+1);
        if (count > k) {
            dfs(arr, k, count-1, idx+1);
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[] {4,2,3,5,7};
        int[] arr = new int[] {4,2,3,5,7,9};
        int k = 3;
        HighlyProfitable highlyProfitable = new HighlyProfitable();
        System.out.println(highlyProfitable.profitable(arr, k));
    }
}
