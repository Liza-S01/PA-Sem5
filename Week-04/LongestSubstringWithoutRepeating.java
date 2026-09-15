import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                bestStart = left;
            }
        }

        System.out.println("Longest Substring: \"" + s.substring(bestStart, bestStart + maxLength) + "\"");
        return maxLength;
    }

    public static void main(String[] args) {
        String[] testCases = { "abcabcbb", "bbbbb", "pwwkew", "abcdef" };

        for (String test : testCases) {
            System.out.println("Input String: \"" + test + "\"");
            int len = lengthOfLongestSubstring(test);
            System.out.println("Length: " + len + "\n");
        }
    }
}
