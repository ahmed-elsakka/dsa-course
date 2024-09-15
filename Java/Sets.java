import java.util.Set;
import java.util.HashSet;

public class Sets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple");
        
        System.out.println(set);
        
        // Remove
        set.remove("Banana");
        System.out.println("After removing Banana: " + set);
        
        // Contains
        System.out.println("Contains Orange? " + set.contains("berry"));
        
        // Size
        System.out.println("Size of set: " + set.size());
        
        // Clear
        set.clear();
        System.out.println("After clearing: " + set);
	}

}
