package org.kybprototyping;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class NoncomparisonSortingTest {

  @Test
  void directAccessArraySort_Should_Sort_Given_Arr() {
    // given
    int[] arr = new int[] {14, 65, 31, 9, 1, 5, 3, 12, 6};

    // when
    NoncomparisonSorting.directAccessArraySort(arr);

    // then
    assertArrayEquals(new int[] {1, 3, 5, 6, 9, 12, 14, 31, 65}, arr);
  }

  @Test
  void countingSort_Should_Sort_Given_Arr() {
    // given
    int[] arr = new int[] {9, 2, 2, 9, 3, 4, 2, 5};

    // when
    NoncomparisonSorting.countingSort(arr);

    // then
    assertArrayEquals(new int[] {2, 2, 2, 3, 4, 5, 9, 9}, arr);
  }

}
