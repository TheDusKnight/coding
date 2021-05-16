package leetcode.MergeSort;

import java.util.*;

// 这种写法不好，因为没有reuse同一个helper array,空间复杂度高
public class MergeSort {
	public ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
		// Corner case
		if (array == null || array.size() <= 1) {
			return array;
		}
		return mergeSort(array, 0, array.size() - 1);
	}

	private ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right) { // overloading
		ArrayList<Integer> res = new ArrayList<>();
        // base case, 只有到root node时会触发
		if (left == right) {
			res.add(array.get(left));
			return res;
		}

		int mid = left + (right - left) / 2;
		ArrayList<Integer> leftRes = mergeSort(array, left, mid);
		ArrayList<Integer> rightRes = mergeSort(array, mid + 1, right);
		merge(leftRes, rightRes, res);
		return res;
	}

	private void merge(ArrayList<Integer> leftRes, ArrayList<Integer> rightRes, List<Integer> res) {
		int leftIndex = 0;
		int rightIndex = 0;
		while(leftIndex < leftRes.size() && rightIndex < rightRes.size()) {
			if (leftRes.get(leftIndex) < rightRes.get(rightIndex)) {
				res.add(leftRes.get(leftIndex++));
			} else {
				res.add(rightRes.get(rightIndex++));
			}
		}
		// remaining elements on left side
		while (leftIndex < leftRes.size()) {
			res.add(leftRes.get(leftIndex++));
		}
		// remaining elements on right side
		while (rightIndex < rightRes.size()) {
			res.add(rightRes.get(rightIndex++));
		}
		// return
    }

    public static void main(String[] args) {
        MergeSort merge = new MergeSort();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(6, 4, 2, 0, 1, 3, 5, 7));
        System.out.println(merge.mergeSort(array));
    }
}

// Time: O(nlogn) + O(n) = O(nlogn)
// Space: O(n) + O(logn) = O(n) [系统栈空间]