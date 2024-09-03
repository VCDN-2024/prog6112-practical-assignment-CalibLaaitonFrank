package studentmanagementapplication;

// The Student class represents a student with attributes such as id, name, age, email, and course
public class Student {
    // Private fields for storing student's id, name, age, email, and course
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    // Constructor to initialize a Student object with id, name, age, email, and course
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getter method for id
    public String getId() {
        return id;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Getter method for course
    public String getCourse() {
        return course;
    }

    // Static method to validate if the age is 16 or above
    public static boolean isValidAge(int age) {
        return age >= 16;
    }

    // Static method to validate if the input string can be parsed into a valid age
    // Returns true if the input is a valid age, otherwise false
    public static boolean isValidAgeInput(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return isValidAge(age);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning
//W3Resource (2024). Java Encapsulation: A Student Class with Grade Validation.[online] Available at: w3resource.com.(Accessed: 29 August 2024).
//Java Code Examples (2023). Example Student Class in Java.[online] Available at: javacodeexamples.com. (Accessed: 29 August 2024).