import java.util.Arrays;

public class VariableSlidingWindowSubarray {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int longestSubArrayWithSumAtMostK(int[] nums, int k) {
        int left = 0, currentSum = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        int minLen = minSubArrayLen(target, nums);
        System.out.println("Minimum length subarray with sum >= " + target + ": " + minLen);

        int k = 8;
        int maxLen = longestSubArrayWithSumAtMostK(nums, k);
        System.out.println("Longest subarray length with sum <= " + k + ": " + maxLen);
    }
}
