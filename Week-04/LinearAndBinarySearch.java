import java.util.Arrays;

public class LinearAndBinarySearch {

    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchIterative(int[] sortedArr, int target) {
        if (sortedArr == null) return -1;
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] sortedArr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (sortedArr[mid] == target) {
            return mid;
        } else if (sortedArr[mid] < target) {
            return binarySearchRecursive(sortedArr, mid + 1, high, target);
        } else {
            return binarySearchRecursive(sortedArr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] unsorted = { 42, 12, 88, 3, 99, 56, 21 };
        int[] sorted = { 3, 12, 21, 42, 56, 88, 99 };
        int target = 56;

        System.out.println("=== 1. Linear Search ===");
        System.out.println("Array: " + Arrays.toString(unsorted));
        System.out.println("Target: " + target);
        int linearIdx = linearSearch(unsorted, target);
        System.out.println("Found at index: " + linearIdx);

        System.out.println("\n=== 2. Binary Search (Iterative & Recursive) ===");
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
        System.out.println("Target: " + target);
        int binIterIdx = binarySearchIterative(sorted, target);
        int binRecIdx = binarySearchRecursive(sorted, 0, sorted.length - 1, target);
        System.out.println("Iterative Binary Search Index: " + binIterIdx);
        System.out.println("Recursive Binary Search Index: " + binRecIdx);
    }
}
