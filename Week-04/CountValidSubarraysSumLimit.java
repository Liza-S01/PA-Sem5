import java.util.Arrays;

public class CountValidSubarraysSumLimit {

    public static int countSubarraysWithSumAtMostK(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit < 0) return 0;

        int left = 0;
        int currentSum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > limit && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int limit = 4;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum Limit: " + limit);

        int totalValidSubarrays = countSubarraysWithSumAtMostK(nums, limit);
        System.out.println("Total contiguous subarrays with sum <= " + limit + ": " + totalValidSubarrays);

    }
}
