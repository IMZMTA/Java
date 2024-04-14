import java.util.HashMap;
import java.util.Set;

public class HashMAP {

    public static void main(String[] args) {
        
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        //Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        
        System.out.println(hm.get("UK"));

        //ContainsKey - O(1) checks whether map contains key or not
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("In"));

        //Remove - O(1)
        int val = hm.remove("China");
        System.out.println(val);
        System.out.println(hm);
        System.out.println(hm.remove("hm"));

        //Size - O(n)
        System.out.println(hm.size());

        //Is Empty
        System.out.println(hm.isEmpty());

        //Clear function
        hm.clear();
        System.out.println(hm);

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("UK", 60);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key : " + k + ", Value : " + hm.get(k));
        }

    }
}