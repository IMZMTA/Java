import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedAndTreeHM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",100);
        lhm.put("China", 50);
        lhm.put("US", 80);

        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 50);
        hm.put("US", 80);

        System.out.println(hm);
        System.out.println(lhm);

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",100);
        tm.put("China", 50);
        tm.put("US", 80);

        System.out.println(tm);
    }
}
