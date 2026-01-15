public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Element found at index i
            }
        }

        return -1;  // Element not found
    }
    public static void main(String[] args) {
        // Updated array values
        int[] arr = {8, 14, 3, 27, 19};
        int target = 27; // Updated target

        int index = linearSearch(arr, target);

        if (index == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found at index: " + index);
        }
    }
}
