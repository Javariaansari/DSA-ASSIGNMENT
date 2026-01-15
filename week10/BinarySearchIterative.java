public class BinarySearchIterative {
    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1; // element not found
    }

    // Main method to test
    public static void main(String[] args) {
        int[] sortedArr = {3, 7, 10, 15, 20, 25}; // must be sorted
        int target = 20;

        int index = binarySearchIterative(sortedArr, target);

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }
}

