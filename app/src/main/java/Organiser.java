import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */
public class Organiser extends Person {

    public ArrayList<Staff> listStaff = new ArrayList<Staff>(100);;

    public Organiser(String name, int age) throws NullPointerException, IllegalArgumentException {
        super(name,age);

        if (name.equals(null)) throw new NullPointerException();
        if (age < 0) throw new IllegalArgumentException();
    }

    public void addStaff(Staff staff){   //there's some fancy for-loop stuff to be used here but I can't remember it
        listStaff.add(staff);
        }

    public void removeStaff(Staff staff){ //same for-loop shenanigans but my brain is ded
        listStaff.remove(staff);
    }
    
    public boolean equals(Object object) {
        if (object instanceof Organiser) {
            return ((Organiser) object).getName().equals(this.getName()) && ((Organiser) object).getAge() == this.getAge();
        } else return false;
    }

    public String toString() {
        int a = getAge();
        String n = getName();

        String s = "Organiser[" + n + ", " + a + "]";
        return s;
    }
}
