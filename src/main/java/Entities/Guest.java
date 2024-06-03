package Entities;

import java.time.LocalDate;

public class Guest {
    private int id = -1;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private String email;
    private String passportNumber;
    private String password;

    public Guest(String firstName, String secondName, LocalDate birthDate, String email, String passportNumber, String password) {
        setFirstName(firstName);
        setSecondName(secondName);
        setBirthDate(birthDate);
        setEmail(email);
        setPassportNumber(passportNumber);
        setPassword(password);
    }

    public int getId() {
        return id;
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
}
