import java.io.Serializable;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */
public class Staff extends Person {

    public Staff(String name, int age) throws NullPointerException, IllegalArgumentException {
        super(name,age);

        if (name.equals(null)) throw new NullPointerException();
        if (age < 0) throw new IllegalArgumentException();
    }

    public boolean equals(Object object) {
        if (object instanceof Staff) {
            return ((Staff) object).getName().equals(this.getName()) && ((Staff) object).getAge() == this.getAge();
        } else return false;
    }

    public String toString() {
        int a = getAge();
        String n = getName();

        String s = "Staff[" + n + ", " + a + "]";
        return s;
    }
}
