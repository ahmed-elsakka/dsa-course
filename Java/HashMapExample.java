import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, Integer> scores = new HashMap<>();

        // Adding key-value pairs
        scores.put("Alice", 95);
        scores.put("Bob", 85);
        scores.put("Charlie", 90);

        // Retrieving values
        int aliceScore = scores.get("Alice");
        System.out.println("Alice's score: " + aliceScore);

        // Removing a key-value pair
        scores.remove("Bob");
        System.out.println("HashMap after removing Bob: " + scores);

        // Checking if a key is present
        if (scores.containsKey("Charlie")) {
            System.out.println("Charlie's score is present.");
        }

        // Checking if a value is present
        if (scores.containsValue(90)) {
            System.out.println("Score 90 is present.");
        }

        // Getting the size of the HashMap
        int size = scores.size();
        System.out.println("Size of the HashMap: " + size);

        // Adding a new key-value pair
        scores.put("David", 88);
        System.out.println("HashMap after adding David: " + scores);

        // Iterating over the HashMap
        System.out.println("Iterating over the HashMap:");
        for (String key : scores.keySet()) {
            int value = scores.get(key);
            System.out.println(key + "'s score: " + value);
        }

        // Clearing the HashMap
        scores.clear();
        System.out.println("HashMap after clearing: " + scores);
    }
}
