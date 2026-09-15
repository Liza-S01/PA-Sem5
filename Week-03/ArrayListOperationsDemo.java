import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListOperationsDemo {
    public static void main(String[] args) {
        System.out.println("=== Core ArrayList Operations Practice ===");

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add(2, "Grapes");
        System.out.println("1. After Adding: " + fruits);

        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        System.out.println("2. Retrieved: Index 0 = " + firstFruit + ", Index 2 = " + thirdFruit);

        String oldFruit = fruits.set(1, "Blueberry");
        System.out.println("3. Updated index 1 (was " + oldFruit + "): " + fruits);

        fruits.remove("Orange");
        fruits.remove(0);
        System.out.println("4. After Removing 'Orange' and index 0: " + fruits);

        boolean containsMango = fruits.contains("Mango");
        boolean containsApple = fruits.contains("Apple");
        int indexOfGrapes = fruits.indexOf("Grapes");
        int size = fruits.size();
        boolean isEmpty = fruits.isEmpty();

        System.out.println("5. Verifications:");
        System.out.println("   - Contains 'Mango'? " + containsMango);
        System.out.println("   - Contains 'Apple'? " + containsApple);
        System.out.println("   - Index of 'Grapes': " + indexOfGrapes);
        System.out.println("   - Current size: " + size);
        System.out.println("   - Is list empty? " + isEmpty);

        System.out.print("6. Iteration (Enhanced For-loop): ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        Collections.sort(fruits);
        System.out.println("7. Sorted List: " + fruits);
        fruits.clear();
        System.out.println("   After clear(), isEmpty? " + fruits.isEmpty());
    }
}
