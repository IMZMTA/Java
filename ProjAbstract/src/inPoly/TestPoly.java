package inPoly;



public class TestPoly {
    public static void main(String[] args) {

        Child ch = new Child(); //Same
//        Child cp = (Child) new Parent(); //Upcasting
//        Parent pc = new Parent(); //Cannot be created
        Parent pa = new Child(); //Down casting

        //Down Down Casting
        Object ref = new Child();
//        Object rep = new Parent(); //Cannot be created

        //Function
        castCase(ch);

//        castCase(pc);
//        castCase(pa);

    }


    private static void castCase(Parent p){

        p.start();
        if(p instanceof Child) {
            ((Child) p).run();
        }
    }
}
