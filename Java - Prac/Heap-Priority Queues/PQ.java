import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    static class Student implements Comparable<Student> {
    
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }

    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // for descending order

        
        pq.add(3); //O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        pq.add(5);
        
        while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" "); //O(1)
            pq.remove(); //O(log n)
        }

        // PriorityQueue<Student> ps = new PriorityQueue<>();
        PriorityQueue<Student> ps = new PriorityQueue<>(Comparator.reverseOrder());

        ps.add(new Student("AA", 10));
        ps.add(new Student("AB", 1));
        ps.add(new Student("CA", 15));
        ps.add(new Student("AD", 4));
        ps.add(new Student("FA", 3));

        System.out.println();
        while (!ps.isEmpty()) {
            System.out.println(ps.peek().name+ "->" + ps.peek().rank);
            ps.remove();
        }
    }
}
