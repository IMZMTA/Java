package in.ch82;

public class TestArray {
    public static void main(String[] args) {
        ArrayOperations opr = new ArrayOperations(new int[]{10,2,30,4,5,75});
        ArrayOperations.Statistics s = opr.new Statistics();
        System.out.println(s.mean());
        System.out.println(s.median());
    }
}
