import java.io.Serializable;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */
public class Person implements Serializable {

    private String name;
    private int age;

    public Person(String name, int age) throws NullPointerException, IllegalArgumentException {
        this.name = name;
        this.age = age;

        if (name.equals(null)) throw new NullPointerException();
        if (age < 0) throw new IllegalArgumentException();
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object object) {

        if (object instanceof Person) {
            return ((Person) object).name.equals(this.name) && ((Person) object).age == this.age;
        } else return false;
    }

    public String toString() {
        int a = getAge();
        String n = getName();

        String s = "Person[" + n + ", " + a + "]";
        return s;
    }
}
