package org.kybprototyping;

/**
 * Provides non-comparison based sorting algorithms.
 */
public final class NoncomparisonSorting {

  private NoncomparisonSorting() {}

  /**
   * <p>
   * Sorts the given {@code arr} under the assumptions below:
   * </p>
   * <ul>
   * <li>All values are unique</li>
   * <li>All values are non-negative</li>
   * </ul>
   * 
   * @param arr array to be sorted
   */
  public static void directAccessArraySort(int[] arr) {
    int arrLength = arr.length;
    int max = findMax(arr); // O(n)

    // O(n)
    int[] temp = new int[max + 1];
    for (int i = 0; i < arrLength; i++) {
      temp[arr[i]] = arr[i];
    }

    // O(max + 1)
    int i = 0;
    for (int j = 0; j < max + 1; j++) {
      if (temp[j] != 0) {
        arr[i] = temp[j];
        i++;
      }
    }

  }

  /**
   * Sorts the given arr under the assumptions below:
   * </p>
   * <ul>
   * <li>All the key values are non-negative</li>
   * </ul>
   * 
   * @param arr array to be sorted
   */
  public static void countingSort(Tuple[] arr) {
    int n = arr.length;
    int max = findMax(arr); // O(n)

    // initialized with zero values.
    int[] countingArr = new int[max + 1]; // O(max + 1) in RAM model
    for (int i = 0; i < n; i++) { // O(n)
      countingArr[arr[i].key()] += 1;
    }

    for (int i = 1; i < max + 1; i++) { // O(max + 1)
      countingArr[i] += countingArr[i - 1];
    }

    Tuple[] temp = new Tuple[n];
    // iterating from the end at this point makes the algorithm stable.
    for (int i = n - 1; i >= 0; i--) { // O(n)
      temp[countingArr[arr[i].key()] - 1] = arr[i];
      countingArr[arr[i].key()]--;
    }

    for (int i = 0; i < n; i++) { // O(n)
      arr[i] = temp[i];
    }
  }

  /**
   * Sorts the given arr under the assumptions below:
   * </p>
   * <ul>
   * <li>All the key values are non-negative</li>
   * </ul>
   * 
   * @param arr array to be sorted
   */
  public static void radixSort(Tuple[] arr) {}

  private static int findMax(int[] arr) {
    int max = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    return max;
  }

  private static int findMax(Tuple[] arr) {
    int max = arr[0].key();

    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i].key()) {
        max = arr[i].key();
      }
    }

    return max;
  }

  static record Tuple(int key, Object value) {
  }

}
