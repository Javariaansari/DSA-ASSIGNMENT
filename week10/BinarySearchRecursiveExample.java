public class BinarySearchRecursiveExample {
    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        // Base case: element not found
        if (low > high) return -1;
        // Find mid index
        int mid = (low + high) / 2;

        // Check if mid element is target
        if (arr[mid] == target) return mid;

        // Recursive search in left or right half
        if (target < arr[mid])
            return binarySearchRecursive(arr, low, mid - 1, target);
        else
            return binarySearchRecursive(arr, mid + 1, high, target);
    }
    
    public static void main(String[] args) {
        int[] sortedArr = {2, 4, 7, 10, 15, 20};
        int target = 7;

        int result = binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
