import java.util.ArrayList;
import java.util.List;

public class RecursionPatterns {

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciTail(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibonacciTail(n - 1, b, a + b);
    }

    public static void printHeadRecursion(int n) {
        if (n == 0) return;
        printHeadRecursion(n - 1);
        System.out.print(n + " ");
    }

    public static void printTailRecursion(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printTailRecursion(n - 1);
    }

    public static List<String> generateSubstrings(String str) {
        List<String> substrings = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    public static void generateSubsequences(String str, int index, String current, List<String> result) {
        if (index == str.length()) {
            result.add(current.isEmpty() ? "\"\" (empty)" : current);
            return;
        }

        generateSubsequences(str, index + 1, current + str.charAt(index), result);

        generateSubsequences(str, index + 1, current, result);
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Fibonacci Patterns ===");
        int n = 7;
        System.out.println("Fibonacci(" + n + ") [Tree Recursion]: " + fibonacci(n));
        System.out.println("Fibonacci(" + n + ") [Tail Recursion]: " + fibonacciTail(n, 0, 1));

        System.out.println("\n=== 2. Head vs Tail Recursion (N = 5) ===");
        System.out.print("Head Recursion (Ascending): ");
        printHeadRecursion(5);
        System.out.println();

        System.out.print("Tail Recursion (Descending): ");
        printTailRecursion(5);
        System.out.println();

        System.out.println("\n=== 3. Substrings vs Subsequences for \"abc\" ===");
        String s = "abc";
        System.out.println("Substrings (Contiguous): " + generateSubstrings(s));

        List<String> subsequences = new ArrayList<>();
        generateSubsequences(s, 0, "", subsequences);
        System.out.println("Subsequences (Relative order preserved): " + subsequences);
    }
}
