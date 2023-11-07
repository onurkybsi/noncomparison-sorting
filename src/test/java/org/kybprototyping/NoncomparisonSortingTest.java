package org.kybprototyping;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.kybprototyping.NoncomparisonSorting.Tuple;

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
    Tuple[] arr = new Tuple[] {new Tuple(9, "value91"), new Tuple(2, "value21"),
        new Tuple(2, "value22"), new Tuple(9, "value92"), new Tuple(3, "value3"),
        new Tuple(4, "value4"), new Tuple(2, "value23"), new Tuple(5, "value5")};

    // when
    NoncomparisonSorting.countingSort(arr);

    // then
    assertEquals(new Tuple(2, "value21"), arr[0]);
    assertEquals(new Tuple(2, "value22"), arr[1]);
    assertEquals(new Tuple(2, "value23"), arr[2]);
    assertEquals(new Tuple(3, "value3"), arr[3]);
    assertEquals(new Tuple(4, "value4"), arr[4]);
    assertEquals(new Tuple(5, "value5"), arr[5]);
    assertEquals(new Tuple(9, "value91"), arr[6]);
    assertEquals(new Tuple(9, "value92"), arr[7]);
  }

}
