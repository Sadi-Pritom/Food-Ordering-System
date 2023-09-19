package entity;

public class Person {
    String name, email, password, number;

    public Person() {
    }

    // value initialization through constructor
    public Person(String[] values) {

        this.name = values[0];
        this.email = values[2];
        this.password = values[3];
        this.number = values[4];
    }

    // setter methods

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // getter methods

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }

}