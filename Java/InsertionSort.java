public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
    }
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
