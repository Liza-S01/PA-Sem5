public class MaxVowelsInSubstring {

    public static int maxVowels(String s, int k) {
        if (s == null || s.length() < k || k <= 0) return 0;

        int currentVowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
        }

        int maxVowelCount = currentVowelCount;

        for (int i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }

            if (isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }

            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
            if (maxVowelCount == k) {
                return k;
            }
        }

        return maxVowelCount;
    }

    private static boolean isVowel(char ch) {
        char lower = Character.toLowerCase(ch);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println("String: \"" + s1 + "\", k = " + k1);
        System.out.println("Max vowels in substring of size " + k1 + ": " + maxVowels(s1, k1));

        String s2 = "leetcode";
        int k2 = 3;
        System.out.println("\nString: \"" + s2 + "\", k = " + k2);
        System.out.println("Max vowels in substring of size " + k2 + ": " + maxVowels(s2, k2));
    }
}
