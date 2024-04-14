package in.ch79;

public class TestEmployee {

    public static void main(String[] args) {

        Employee e1 = new Employee("Aashu",32,5000);
        System.out.println(e1.getEmployeeDetails());
        e1.setName("Nivedita");
        System.out.println(e1.getEmployeeDetails());
    }

}
