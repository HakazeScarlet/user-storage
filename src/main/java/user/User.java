package user;

public class User {

    private final String email;
    private final String name;
    private final String surname;
    private final String phone;
    private final String country;
    private final String password;

    public User(String email, String name, String surname, String phone, String country, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.country = country;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }
}
