import java.util.Arrays;
public class SortingAlgorithms {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 4, 1};
        int[] arr2 = {5, 3, 2, 1};
        int[] arr3 = {5, 3, 6, 1};

        System.out.println("Array: "+Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Bubble Sorted array: " + Arrays.toString(arr1));

        System.out.println("Array: "+Arrays.toString(arr2));
        selectionSort(arr2);
        System.out.println("Selection Sorted array: " + Arrays.toString(arr2));

        System.out.println("Array:" +Arrays.toString(arr3));
        insertionSort(arr3);
        System.out.println("Insertion Sorted array: " + Arrays.toString(arr3));
    }
}

