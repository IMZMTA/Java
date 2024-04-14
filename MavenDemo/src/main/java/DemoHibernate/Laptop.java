package DemoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String lname;

//    @ManyToOne
//    private Alien al;
//
//    public Alien getAl() {
//        return al;
//    }
//
//    public void setAl(Alien al) {
//        this.al = al;
//    }

    @ManyToMany
    private List<Alien> al = new ArrayList<>();

    public List<Alien> getAl() {
        return al;
    }

    public void setAl(List<Alien> al) {
        this.al = al;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
