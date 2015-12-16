package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Person {
    private final String name;
    private final String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;

    }


    public String age() {
        return age;
    }

    public String name() {
        return name;
    }
}
