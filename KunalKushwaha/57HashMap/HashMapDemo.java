
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Hello", 0);
        map.put("World", 1);

        System.out.println(map.get("Hello"));

        System.out.println(map.containsKey("Hi"));

        System.out.println(map.getOrDefault("Hi", -1));

        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(11);
        set.add(19);
        set.add(12);

        System.out.println(set);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(11);
        treeSet.add(19);
        treeSet.add(12);

        System.out.println(treeSet);
    }
}
