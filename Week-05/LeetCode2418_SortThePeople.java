import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Map<Integer, String> heightToName = new HashMap<>();
        for (int i = 0; i < n; i++) {
            heightToName.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] result = new String[n];
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[idx++] = heightToName.get(heights[i]);
        }

        return result;
    }
}
