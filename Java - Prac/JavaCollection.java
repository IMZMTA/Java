import java.util.*;

public class JavaCollection {

    public static void main(String[] args) {
        
        //create - only through objects(only) no primitve datatypes same as ArrayList
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        // System.out.println(ll);

        ll.removeLast();
        ll.removeFirst();

        // System.out.println(ll);

        LinkedList<Integer> l1 = new LinkedList<>();

        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(5);
        l1.addFirst(7);
        l1.addFirst(6);

        System.out.println(l1);

        
    }
}
