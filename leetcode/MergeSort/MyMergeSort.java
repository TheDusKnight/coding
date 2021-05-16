package leetcode.MergeSort;

import java.util.*;

// 没有reuse helper
public class MyMergeSort {
   public List<Integer> mergeSort(List<Integer> array) {
       // cc
       if (array == null || array.size() <= 1) return array;
       return mergeSort(array, 0, array.size() - 1);
   } 

   private List<Integer> mergeSort(List<Integer> array, int left, int right) {
       // cc
       List<Integer> res = new ArrayList<Integer>();
       if (left == right) {
           res.add(array.get(left));
           return res;
       }

       int mid = left + (right - left) / 2;
       List<Integer> leftRes = mergeSort(array, left, mid);
       List<Integer> rightRes = mergeSort(array, mid+1, right);
       merge(leftRes, rightRes, res);
       return res;
   }

   private void merge(List<Integer> leftRes, List<Integer> rightRes, List<Integer> res) {
       int leftIndex = 0;
       int rightIndex = 0;
       while (leftIndex < leftRes.size() && rightIndex < rightRes.size()) {
           if (leftRes.get(leftIndex++) < rightRes.get(rightIndex++)) {
               res.add(leftRes.get(leftIndex));
           } else {
               res.add(rightRes.get(rightIndex));
           }
       }
       // add remaining to res list
       while (leftIndex < leftRes.size()) {
           res.add(leftRes.get(leftIndex++));
       }
       while (rightIndex < rightRes.size()) {
           res.add(rightRes.get(rightIndex++));
       }
   }
   public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,1,3,9,-4));
       MergeSort instance = new MergeSort();
       System.out.println(instance.mergeSort(list));
   }
}
