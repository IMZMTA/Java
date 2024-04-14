package DemoHibernate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Alien")//Same entity , class and table name
//@Table(name = "Alien")//Different table name, but same entity and class
public class Alien {//POJO

    @Id
    private int aid;
//    @Column(name = "Name")
    private FAlien falien;
    private String name;
//    @Transient//For excluding field
    private int rollNo;
    private String color;
//    @OneToOne
//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    @OneToMany
//    @OneToMany(mappedBy = "al")
//    private List<Laptop> laplist = new ArrayList<>();
//
//    public List<Laptop> getLaplist() {
//        return laplist;
//    }
//
//    public void setLaplist(List<Laptop> laplist) {
//        this.laplist = laplist;
//    }

//    @ManyToMany(mappedBy = "al") (//fetch = FetchType.LAZY)->Default //LadyLoading
    @ManyToMany(mappedBy = "al",fetch = FetchType.EAGER) //EagerLoading
    private List<Laptop> laplist = new ArrayList<>();

    public List<Laptop> getLaplist() {
        return laplist;
    }

    public void setLaplist(List<Laptop> laplist) {
        this.laplist = laplist;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FAlien getFalien() {
        return falien;
    }

    public void setFalien(FAlien falien) {
        this.falien = falien;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    @Override
//    public String toString() {
//        return "Alien[" +
//                "aid=" + aid +
//                ", name='" + name + '\'' +
//                ", rollNo=" + rollNo +
//                ", color='" + color + '\'' +
//                ']';
//    }


    @Override
    public String toString() {
        return "Alien{" + "aid=" + aid + ", falien=" + falien + ", name='" + name + '\'' + ", rollNo=" + rollNo + ", color='" + color + '\'' + '}';
    }
}
