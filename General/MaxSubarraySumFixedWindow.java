import java.util.Arrays;

public class MaxSubarraySumFixedWindow {

    public static int findMaxSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid array length or window size k.");
        }

        int currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }

        int maxSum = currentWindowSum;
        int maxStartIndex = 0;

        for (int i = k; i < arr.length; i++) {

            currentWindowSum += arr[i] - arr[i - k];

            if (currentWindowSum > maxSum) {
                maxSum = currentWindowSum;
                maxStartIndex = i - k + 1;
            }
        }

        System.out.println("Subarray with max sum: " + Arrays.toString(Arrays.copyOfRange(arr, maxStartIndex, maxStartIndex + k)));
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Window size k: " + k);

        int maxSum = findMaxSubarraySum(arr, k);
        System.out.println("Maximum sum of contiguous subarray of size " + k + " is: " + maxSum);
    }
}
