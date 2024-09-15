import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }


    public void delete(String word) {
        TrieNode node = root;
        Stack<Pair<TrieNode, Character>> stack = new Stack<>();

        // Traverse the word and keep track of the path
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return;  // Word doesn't exist
            }
            stack.push(new Pair<>(node, c));  // Push the current node and character to the stack
            node = node.children.get(c);
        }

        if (!node.isWord) {
            return;  // Word doesn't exist
        }

        // Unmark the last node as the end of a word
        node.isWord = false;

        // Cleanup unnecessary nodes
        while (!stack.isEmpty()) {
            Pair<TrieNode, Character> pair = stack.pop();
            TrieNode parent = pair.getKey();
            char charToRemove = pair.getValue();

            // If the current node has no children and is not a word, remove the child from the parent
            if (node.children.isEmpty() && !node.isWord) {
                parent.children.remove(charToRemove);
            } else {
                // If the node has children or represents another word, stop the cleanup
                break;
            }

            // Move back to the parent node for the next iteration
            node = parent;
        }
    }

    // Pair class to store a TrieNode and its associated character
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
