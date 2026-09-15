import java.util.Arrays;

public class MinSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        int startIdx = -1, endIdx = -1;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIdx = left;
                    endIdx = right;
                }
                currentSum -= nums[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No subarray found with sum >= " + target);
            return 0;
        }

        System.out.print("Minimal Subarray: [");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(nums[i] + (i == endIdx ? "" : ", "));
        }
        System.out.println("]");

        return minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };

        System.out.println("Target: " + target);
        System.out.println("Array: " + Arrays.toString(nums));
        int minLen = minSubArrayLen(target, nums);
        System.out.println("Minimum length: " + minLen);
    }
}
