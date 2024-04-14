import java.util.*;

public class HshSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(4);
        set.add(2);
        set.add(1);
        set.add(2);

        System.out.println(set);

        if(set.contains(2)){
            System.out.println("Contains");
        }
        set.remove(2);
        if(set.contains(2)){
            System.out.println("Contains");
        }
        if(set.contains(6)){
            System.out.println("Containing");
        }

        //Iterators on HashSet -> 2 ways

        //Iterator - 1st ways
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //Advanced Loops -2nd Ways
        for(Integer i : set){
            System.out.println(i);
        }

        //LINKED HASH SET - is an Ordered Set
        //LHS < HS && LHM < HM -> on Performance because extra operations are performed on both LHS and LHM

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(8);
        lhs.add(3);
        lhs.add(4);
        lhs.add(1);

        System.out.println(lhs);

        //TreeSet uses TreeMap  -> Soreted Order(Ascending Or Descending).It uses a self balancing binary search tree.Implementation is through Red Black BST.

        //Red Black Tree -> Tree Map -> Tree Set

        //Null valuse are not allowed but in HashSet and LinkedHashSet null values are allowed. due to sorting 

        //insert,remove,contains becomes O(log n)
        //HashSet > LinkedHashSet > TreeSet on performance optimised

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(8);
        ts.add(3);
        ts.add(4);
        ts.add(1);

        System.out.println(ts);
    }
}
