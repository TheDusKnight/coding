package leetcode._0078_Subsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 第二类搜索树bfs写法
// 类似dfs答案出来leaf node
public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // corner case
        if (nums == null) {
            return result;
        }
        int length = nums.length;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        int level = 0;

        queue.offer(new ArrayList<>(temp)); // (ArrayList) temp.clone()
        int size;

        while (level < length) {
           size = queue.size();
            // 把每一层solution-so-far poll出啦，加或不加下一个元素
            while(size-- > 0) {
                temp = queue.poll();
                queue.offer(new ArrayList<>(temp));
                temp.add(nums[level]);
                queue.offer(new ArrayList<>(temp));
            }
            // 下一个index加或不加
            level++;
        }
        result = (List) queue; // result就是最后一层所有leave node
        return result;
    }
}
