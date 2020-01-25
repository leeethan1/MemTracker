import java.io.Serializable;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */
public class Staff extends Person {

    public Staff(String name) throws NullPointerException, IllegalArgumentException {
        super(name);

        if (name.equals(null)) throw new NullPointerException();
    }

    public boolean equals(Object object) {
        if (object instanceof Staff) {
            return ((Staff) object).getName().equals(this.getName());
        } else return false;
    }

    public String toString() {
        String n = getName();

        String s = "Staff[" + n + "]";
        return s;
    }
}
