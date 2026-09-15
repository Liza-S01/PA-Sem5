import java.util.Arrays;

public class FirstAndLastOccurrenceBinarySearch {

    public static int findFirstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int firstIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                firstIndex = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return firstIndex;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastIndex = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lastIndex;
    }

    public static int countFrequency(int[] nums, int target) {
        int first = findFirstOccurrence(nums, target);
        if (first == -1) return 0;
        int last = findLastOccurrence(nums, target);
        return (last - first + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6 };
        int target = 5;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);
        int freq = countFrequency(nums, target);

        System.out.println("First Occurrence Index: " + first);
        System.out.println("Last Occurrence Index: " + last);
        System.out.println("Total Frequency: " + freq);
    }
}
