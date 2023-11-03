package org.kybprototyping;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class NoncomparisonSortingTest {

  @Test
  void directAccessArraySort_Should_Sort_Give_Arr() {
    // given
    int[] arr = new int[] {14, 65, 31, 9, 1, 5, 3, 12, 6};

    // when
    NoncomparisonSorting.directAccessArraySort(arr);

    // then
    assertArrayEquals(new int[] {1, 3, 5, 6, 9, 12, 14, 31, 65}, arr);
  }

}
