

public class insertionSort extends genericSort {
    @Override
    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                iterations++;
                comparisons++;
                swaps++;
            }
            arr[j + 1] = key;
            swaps++;
        }
    }

    public static void main(String[] args) {
        insertionSort is = new insertionSort();
        is.testRandomValues();
        is.test();
    }
}
