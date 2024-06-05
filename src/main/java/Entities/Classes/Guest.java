package Entities.Classes;

import java.time.LocalDate;

public class Guest {
    private int id = -1;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String passportNumber;
    private String password;

    public Guest(String firstName, String secondName, LocalDate birthDate, String phoneNumber, String email, String passportNumber, String password) {
        setFirstName(firstName);
        setSecondName(secondName);
        setBirthDate(birthDate);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setPassportNumber(passportNumber);
        setPassword(password);
    }

    public Guest(int id, String firstName, String secondName, LocalDate birthDate, String phoneNumber, String email, String passportNumber, String password) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
                ", lastName='" + secondName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
