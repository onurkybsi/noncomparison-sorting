package org.kybprototyping;

/**
 * Provides non-comparison based sorting algorithms.
 */
public final class NoncomparisonSorting {

  private NoncomparisonSorting() {
    throw new UnsupportedOperationException("This class is not initiable!");
  }

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
    int n = arr.length;
    int max = findMax(arr); // O(n)

    // O(n)
    int[] temp = new int[max + 1];
    for (int i = 0; i < n; i++) {
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
   * Sorts the given {@code arr} under the assumptions below:
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
    // iterating from the end at this point makes the algorithm 'stable'.
    for (int i = n - 1; i >= 0; i--) { // O(n)
      temp[countingArr[arr[i].key()] - 1] = arr[i];
      countingArr[arr[i].key()]--;
    }

    for (int i = 0; i < n; i++) { // O(n)
      arr[i] = temp[i];
    }
  }

  /**
   * Sorts the given {@code arr} under the assumptions below:
   * </p>
   * <ul>
   * <li>All the key values are non-negative</li>
   * </ul>
   * 
   * @param arr array to be sorted
   */
  public static void radixSort(Tuple[] arr) {
    int maxDigit = findMaxDigit(arr);

    for (int i = 1; i <= maxDigit; i++) {
      countingSortByDigit(arr, i);
    }
  }

  private static void countingSortByDigit(Tuple[] arr, int digitFromLeft) {
    int n = arr.length;
    int divider = (int) Math.pow(10, digitFromLeft);

    int[] countingArr = new int[10];
    for (int i = 0; i < n; i++) {
      countingArr[(arr[i].key() / divider) % 10] += 1;
    }

    for (int i = 1; i < 10; i++) {
      countingArr[i] += countingArr[i - 1];
    }

    Tuple[] temp = new Tuple[n];
    for (int i = n - 1; i >= 0; i--) {
      temp[countingArr[(arr[i].key() / divider) % 10] - 1] = arr[i];
      countingArr[(arr[i].key() / divider) % 10]--;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = temp[i];
    }
  }

  private static int findMax(int[] arr) {
    int max = arr[0];

    for (int i = 0; i < arr.length; i++)
      if (max < arr[i])
        max = arr[i];

    return max;
  }

  private static int findMax(Tuple[] arr) {
    int max = arr[0].key();

    for (int i = 0; i < arr.length; i++)
      if (max < arr[i].key())
        max = arr[i].key();

    return max;
  }

  private static int findMaxDigit(Tuple[] arr) {
    int maxDigit = 0;

    for (int max = findMax(arr); max > 0; max /= 10)
      maxDigit++;

    return maxDigit;
  }

  static record Tuple(int key, Object value) {
  }

}
