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

  public static void countingSort(int[] arr) {
    int n = arr.length;
    int max = findMax(arr); // O(n)

    int[] countingArr = new int[max + 1]; // initialized with zero values. This takes O(n) in RAM
                                          // model.
    for (int i = 0; i < n; i++) { // O(n)
      countingArr[arr[i]] += 1;
    }

    for (int i = 1; i < max + 1; i++) { // O(max + 1)
      countingArr[i] += countingArr[i - 1];
    }

    int[] temp = new int[n];
    for (int i = 0; i < n; i++) { // O(n)
      temp[countingArr[arr[i]] - 1] = arr[i];
      countingArr[arr[i]]--;
    }

    for (int i = 0; i < n; i++) { // O(n)
      arr[i] = temp[i];
    }
  }

  private static int findMax(int[] arr) {
    int max = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    return max;
  }

}
