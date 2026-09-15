import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexNegationDuplicatesDisappeared {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int[] arr = nums.clone();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {

                duplicates.add(Math.abs(arr[i]));
            } else {

                arr[index] = -arr[index];
            }
        }

        return duplicates;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        int[] arr = nums.clone();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                disappeared.add(i + 1);
            }
        }

        return disappeared;
    }

    public static void main(String[] args) {
        int[] numsWithDups = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Array for Duplicates: " + Arrays.toString(numsWithDups));
        List<Integer> duplicates = findDuplicates(numsWithDups);
        System.out.println("Duplicate numbers: " + duplicates);

        int[] numsWithMissing = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("\nArray for Disappeared: " + Arrays.toString(numsWithMissing));
        List<Integer> disappeared = findDisappearedNumbers(numsWithMissing);
        System.out.println("Disappeared numbers: " + disappeared);
    }
}
