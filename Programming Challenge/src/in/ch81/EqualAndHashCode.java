package in.ch81;

public class EqualAndHashCode {
    public static void main(String[] args) {
        Person p1 = new Person("Abu",30,"I790");
        Person p2 = new Person("Abu",30,"I790");

        //Equal Method compare each and every value
        if(p1 == p2){
            System.out.println("Equal");
        }
        else if (p1.equals(p2)) {
            System.out.println("Extreme Equal");
        }else {
            System.out.println("Not Equal");
        }

        //HashCode
        //Every same equals generate a same HashCode
        //But every same HashCode doesn't means they are equal
        if(p1.hashCode()==p2.hashCode()) {
            if (p1.equals(p2)) {
                System.out.println("Equals");
            }else{
                System.out.println("Not Equals");
            }
        }
    }
}
