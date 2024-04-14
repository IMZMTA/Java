package inPolymorph;

public class TestPoly {
    public static void main(String[] args) {

        Child ch = new Child(); //Same
//        Child cp = (Child) new Parent(); //Upcasting
        Parent pc = new Parent(); //Same
        Parent pa = new Child(); //Down casting

        //Down-Down Casting
        Object ref = new Child();
        Object rep = new Parent();

        //Function
        castCase(ch);

//        ch.run();

//        castCase(pc);
//        castCase(pa);

    }

    private static void castCase(Parent p){
//        p.start();

        Child c = (Child) p;
        ((Child) p).run(); //Depends on object calling or Constructor rather than Reference so Overriding is run time polymorphism
        //And access modifier of CHILD should equal or give more access to Child than parents but vice-versa can't be done.
        // i.e Access Level cannot be more restrictive than overridden method's access level.
        c.start();
    }
}
