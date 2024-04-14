package DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class App {

    public static void main(String[] args) {

//        Alien al = new Alien();
//        al.setAid(102);
//        al.setName("Abdul");
//        al.setRollNo(12030);
//        al.setColor("Green");
//
//        Alien a2 = new Alien();
//        a2.setAid(105);
//        a2.setName("Vaidya");
//        a2.setRollNo(12028);
//        a2.setColor("Yellow");

        //Object->inside object

//        FAlien fa = new FAlien();
//        fa.setFname("Imz");
//        fa.setMname("Md Tausif");
//        fa.setLname("Ali");
//
//        Alien a3 = new Alien();
//        a3.setAid(100);
//        a3.setFalien(fa);
//        a3.setName("Aadil");
//        a3.setRollNo(12020);
//        a3.setColor("Greenish Blue");
//
//        Alien fetch = new Alien();

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

//        Session session;
//        try (SessionFactory sf = con.buildSessionFactory()) {
//            session = sf.openSession();
//
//
//            //We have to follow ACID property
//            Transaction tx = session.beginTransaction();
//
////            session.persist(a2);  //session.save(al);-> is deprecated.
////            session.persist(al);
//
//            fetch = (Alien) session.get(Alien.class,102);
//
//            tx.commit();
//            session.close();
//            sf.close();
//
//            System.out.println(fetch);

//            try{
//                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//                try (SessionFactory sfc = conn.buildSessionFactory()) {
//                    session = sfc.openSession();
//
//                    Transaction txc = session.beginTransaction();
//
//                    session.persist(a3);
//                    txc.commit();
//                    session.close();
//                    sfc.close();
//
//                    System.out.println(a3);
//                }
//            }catch (Exception e){
//                System.out.println("Exception : "+ e);
//            }

        //Direct Only No link up
//            Laptop l1 = new Laptop();
//            l1.setLid(101);
//            l1.setLname("Dell");
//
//
//            FAlien fa = new FAlien();
//            fa.setFname("Imz");
//            fa.setMname("Md Tausif");
//            fa.setLname("Ali");
//
//            Alien a3 = new Alien();
//            a3.setAid(100);
//            a3.setFalien(fa);
//            a3.setName("Aadil");
//            a3.setRollNo(12020);
//            a3.setColor("Greenish Blue");
//
//            try{
//                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//                try (SessionFactory sfc = conn.buildSessionFactory()) {
//                    Session session;
//                    session = sfc.openSession();
//
//                    Transaction txc = session.beginTransaction();
//
//                    session.persist(a3);
//                    session.persist(l1);
//                    txc.commit();
//                    session.close();
//                    sfc.close();
//
//                    System.out.println(a3);
//                }
//            }catch (Exception e){
//                System.out.println("Exception : "+ e);
//            }
//
//            //One to One
//            Laptop l1 = new Laptop();
//            l1.setLid(101);
//            l1.setLname("Dell");
//
//
//            FAlien fa = new FAlien();
//            fa.setFname("Imz");
//            fa.setMname("Md Tausif");
//            fa.setLname("Ali");
//
//            Alien a3 = new Alien();
//            a3.setAid(100);
//            a3.setFalien(fa);
//            a3.setName("Aadil");
//            a3.setRollNo(12020);
//            a3.setColor("Greenish Blue");
//            a3.setLaptop(l1);
//
//            try{
//                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//                try (SessionFactory sfc = conn.buildSessionFactory()) {
//                    Session session;
//                    session = sfc.openSession();
//
//                    Transaction txc = session.beginTransaction();
//
//                    session.persist(a3);
//                    session.persist(l1);
//                    txc.commit();
//                    session.close();
//                    sfc.close();
//
//                    System.out.println(a3);
//                }
//            }catch (Exception e){
//                System.out.println("Exception : "+ e);
//            }

//            //One to One //ManyToOne //OneToMany
//            Laptop l1 = new Laptop();
//            l1.setLid(101);
//            l1.setLname("Dell");
//
//
//            FAlien fa = new FAlien();
//            fa.setFname("Imz");
//            fa.setMname("Md Tausif");
//            fa.setLname("Ali");
//
//            Alien a3 = new Alien();
//            a3.setAid(100);
//            a3.setFalien(fa);
//            a3.setName("Aadil");
//            a3.setRollNo(12020);
//            a3.setColor("Greenish Blue");
//            a3.getLaplist().add(l1);
//
//            try{
//                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//                try (SessionFactory sfc = conn.buildSessionFactory()) {
//                    Session session;
//                    session = sfc.openSession();
//
//                    Transaction txc = session.beginTransaction();
//
//                    session.persist(a3);
//                    session.persist(l1);
//                    txc.commit();
//                    session.close();
//                    sfc.close();
//
//                    System.out.println(a3);
//                }
//            }catch (Exception e){
//                System.out.println("Exception : "+ e);
//            }

//            //MaytoMany
//            Laptop l1 = new Laptop();
//            l1.setLid(101);
//            l1.setLname("Dell");
//
//            FAlien fa = new FAlien();
//            fa.setFname("Imz");
//            fa.setMname("Md Tausif");
//            fa.setLname("Ali");
//
//            Alien a3 = new Alien();
//            a3.setAid(100);
//            a3.setFalien(fa);
//            a3.setName("Aadil");
//            a3.setRollNo(12020);
//            a3.setColor("Greenish Blue");
//            a3.getLaplist().add(l1);
//
//            l1.getAl().add(a3);
//
//            try{
//                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//                try (SessionFactory sfc = conn.buildSessionFactory()) {
//                    Session session;
//                    session = sfc.openSession();
//
//                    Transaction txc = session.beginTransaction();
//
//                    session.persist(a3);
//                    session.persist(l1);
//                    txc.commit();
//                    session.close();
//                    sfc.close();
//
//                    System.out.println(a3);
//                }
//            }catch (Exception e){
//                System.out.println("Exception : "+ e);
//            }
//
            try{
                Configuration conn = new Configuration().configure().addAnnotatedClass(Alien.class);

                try (SessionFactory sfc = conn.buildSessionFactory()) {
                    Session session;
                    session = sfc.openSession();

                    Transaction txc = session.beginTransaction();

                    Alien a5 = session.get(Alien.class,100);

//                    System.out.println(a5);
//                    Collection<Laptop> laps = a5.getLaplist();
//
//                    for(Laptop l:laps){
//                        System.out.println(l);
//                    }
//
//                    txc.commit();
//                    session.close();
//                    sfc.close();

                      System.out.println(a5);
//                    Collection<Laptop> laps = a5.getLaplist();
//
//                    for(Laptop l:laps){
//                        System.out.println(l);
//                    }

                    txc.commit();
                    session.close();
                    sfc.close();

                }
            }catch (Exception e){
                System.out.println("Exception : "+ e);
            }
    }
}