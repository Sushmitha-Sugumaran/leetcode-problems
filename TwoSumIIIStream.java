// 170. Data Structure Design for Two Sum III
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    // --- 1. THE DATA STRUCTURE DESIGN ---
    static class TwoSum {
        private final Map<Integer, Integer> numCounts;

        public TwoSum() {
            numCounts = new HashMap<>();
        }
        
        // Adds a number to the data stream
        public void add(int number) {
            numCounts.put(number, numCounts.getOrDefault(number, 0) + 1);
        }
        
        // Checks if any two stream elements sum up to the target 'value'
        public boolean find(int value) {
            return numCounts.keySet().stream().anyMatch(num1 -> {
                int num2 = value - num1;
                
                if (num1 == num2) {
                    // Duplicate rule: if target needs two of the same number, check count
                    return numCounts.get(num1) >= 2;
                } else {
                    // Different numbers: check if complement exists
                    return numCounts.containsKey(num2);
                }
            });
        }
    }

    // --- 2. THE MAIN METHOD (FOR EXECUTION) ---
    public static void main(String[] args) {
        // Initialize our data structure
        TwoSum tracker = new TwoSum();
        
        System.out.println("--- Stream Initialization ---");
        System.out.println("Adding numbers: 4, 2, 4\n");
        
        // Simulate incoming stream inputs
        tracker.add(4);
        tracker.add(2);
        tracker.add(4);

        System.out.println("--- Executing Queries ---");

        // Test Case 1: Elements are unique and exist (4 + 2 = 6)
        boolean test1 = tracker.find(6);
        System.out.println("Can we find a pair that sums to 6? -> " + test1); // Expected: true

        // Test Case 2: Elements are identical and we have enough duplicates (4 + 4 = 8)
        boolean test2 = tracker.find(8);
        System.out.println("Can we find a pair that sums to 8? -> " + test2); // Expected: true

        // Test Case 3: Elements are identical but we DON'T have enough duplicates (2 + 2 = 4)
        // Note: Even though 4 is in the stream, we are checking if 2 + 2 exists.
        boolean test3 = tracker.find(4);
        System.out.println("Can we find a pair that sums to 4? -> " + test3); // Expected: false

        // Test Case 4: No matching elements exist at all
        boolean test4 = tracker.find(15);
        System.out.println("Can we find a pair that sums to 15? -> " + test4); // Expected: false
    }
}



// output:
// --- Stream Initialization ---
// Adding numbers: 4, 2, 4

// --- Executing Queries ---
// Can we find a pair that sums to 6? -> true
// Can we find a pair that sums to 8? -> true
// Can we find a pair that sums to 4? -> false
// Can we find a pair that sums to 15? -> false
