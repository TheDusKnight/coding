package leetcode.MergeSort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class JunitTest {
  @Test
  public void testAssertEquals() {
      int[] array = new int[] {2,4,1,5,3};
      int[] res = new int[] {1,2,3,4,5};
      assertArrayEquals(res, MergeSort2.mergeSort(array));
  }

  @Test
  public void testAssertNull() {
      int[] array = new int[] {};
      int[] res = new int[] {};
      assertArrayEquals(res, MergeSort2.mergeSort(array));
  }
}