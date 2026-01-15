public class LinearSearchRecursive {
    // Recursive function for Linear Search
    public static int linearSearchRec(int[] arr, int target, int index) {
        // Base case: index out of bounds
        if (index == arr.length) {
            return -1;   // element not found
        }

        // Check current element
        if (arr[index] == target) {
            return index;
        }
        // Recursive call for next index
        return linearSearchRec(arr, target, index + 1);
    }
    public static void main(String[] args) {

        int[] arr = {5, 12, 7, 25, 3};
        int target = 25;

        int result = linearSearchRec(arr, target, 0);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
