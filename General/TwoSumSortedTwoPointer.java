import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumSortedTwoPointer {

    public static List<int[]> findPairsWithTargetSum(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) return pairs;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                pairs.add(new int[]{ arr[left], arr[right] });

                int currentLeft = arr[left];
                int currentRight = arr[right];

                while (left < right && arr[left] == currentLeft) left++;
                while (left < right && arr[right] == currentRight) right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] sortedArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
        int target = 10;

        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
        System.out.println("Target Sum: " + target);

        List<int[]> pairs = findPairsWithTargetSum(sortedArr, target);

        System.out.println("Pairs that sum to " + target + ":");
        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
