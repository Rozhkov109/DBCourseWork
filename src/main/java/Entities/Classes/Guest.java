package Entities.Classes;

import java.time.LocalDate;

public class Guest {
    private int id = -1;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String passportNumber;
    private String password;

    public Guest(String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, String passportNumber, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setPassportNumber(passportNumber);
        setPassword(password);
    }

    public Guest(int id, String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, String passportNumber, String password) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setPassportNumber(passportNumber);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nGuest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
