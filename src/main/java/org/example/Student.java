package org.example;

public class Student {
        private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

    public Student(String firstName, String lastName, String email, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String toString() {
        return " Student id:" + id +"Name: " + firstName + " " + lastName + " " + email + " " + dateOfBirth;
    }
}
