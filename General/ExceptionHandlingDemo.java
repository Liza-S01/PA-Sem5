public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Exception Handling (try-catch-finally) ===");

        demonstrateArithmeticException();

        System.out.println("\n-----------------------------------------------\n");

        demonstrateArrayIndexOutOfBoundsException();

        System.out.println("\n-----------------------------------------------\n");

        demonstrateMultipleExceptions();
    }

    public static void demonstrateArithmeticException() {
        System.out.println("--- Scenario 1: ArithmeticException ---");
        int numerator = 100;
        int denominator = 0;

        try {
            System.out.println("Attempting to divide " + numerator + " by " + denominator + "...");
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.err.println("Caught ArithmeticException: " + ex.getMessage());
            System.out.println("Handled: Cannot divide a number by zero!");
        } finally {
            System.out.println("Finally block executed for Scenario 1 (Cleanup/Resource release).");
        }
    }

    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("--- Scenario 2: ArrayIndexOutOfBoundsException ---");
        int[] numbers = { 10, 20, 30, 40, 50 };
        int invalidIndex = 10;

        try {
            System.out.println("Array size is: " + numbers.length);
            System.out.println("Attempting to access index: " + invalidIndex);
            int value = numbers[invalidIndex];
            System.out.println("Value at index " + invalidIndex + ": " + value);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
            System.out.println("Handled: Index is outside the valid range [0, " + (numbers.length - 1) + "]!");
        } finally {
            System.out.println("Finally block executed for Scenario 2.");
        }
    }

    public static void demonstrateMultipleExceptions() {
        System.out.println("--- Scenario 3: Multiple Catch & Custom Throw ---");
        String input = null;

        try {
            if (input == null) {
                throw new NullPointerException("Input string is null!");
            }
            int parsed = Integer.parseInt(input);
            System.out.println("Parsed number: " + parsed);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.println("Caught Exception: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Generic Exception caught: " + ex.getMessage());
        } finally {
            System.out.println("Finally block always executes, even after exceptions.");
        }
    }
}
