public class User {

    String email;
    String name;
    String surname;
    String phone;
    String country;
    int userCounter = 0;

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }
}
