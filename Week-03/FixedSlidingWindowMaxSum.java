import java.util.Arrays;

public class FixedSlidingWindowMaxSum {

    public static int maxSubArraySum(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input or window size");
        }

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 200, 300, 400 };
        int k = 2;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Window Size (k): " + k);
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(nums, k));
    }
}
