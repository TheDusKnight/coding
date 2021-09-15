package leetcode.MergeSort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class JunitTest {
  MergeSort mergeSort = new MergeSort();

  @Test
  public void testAssertEquals() {
      int[] array = new int[] {2,4,1,5,3};
      int[] res = new int[] {1,2,3,4,5};
      assertArrayEquals(res, mergeSort.sortArray(array));
  }

  @Test
  public void testAssertNull() {
      int[] array = new int[] {};
      int[] res = new int[] {};
      assertArrayEquals(res, mergeSort.sortArray(array));
  }
}