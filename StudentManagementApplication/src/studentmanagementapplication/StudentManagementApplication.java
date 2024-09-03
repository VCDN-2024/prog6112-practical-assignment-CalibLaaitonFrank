package  studentmanagementapplication;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StudentManagementApplication {
    private ArrayList<Student> students; // Array List

    public StudentManagementApplication() {
        students = new ArrayList<>();
    }

    public void run() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, 
                    "STUDENT MANAGEMENT APPLICATION\nEnter (1) to launch menu or any other key to exit");
            if (input != null && input.equals("1")) {
                displayMenu();
            } else {
                break;
            }
        }
    }

    //Create a display menu
    private void displayMenu() {
        String[] options = {
            "Capture a new student.",
            "Search for a student.",
            "Delete a student.",
            "Print student report.",
            "Exit application."
        };
        
        String input = (String) JOptionPane.showInputDialog(null, 
                "Please select one of the following menu items:", 
                "Menu", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);
        
        if (input != null) {
            switch (input) {
                case "Capture a new student.":
                    captureNewStudent();
                    break;
                case "Search for a student.":
                    searchForStudent();
                    break;
                case "Delete a student.":
                    deleteStudent();
                    break;
                case "Print student report.":
                    printStudentReport();
                    break;
                case "Exit application.":
                    JOptionPane.showMessageDialog(null, "Exiting application.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
            }
        }
    }

    //Details to capture the new student 
    private void captureNewStudent() {
        String id = JOptionPane.showInputDialog("Enter the student id:");
        String name = JOptionPane.showInputDialog("Enter the student name:");
        int age = getValidAgeInput();
        String email = JOptionPane.showInputDialog("Enter the student email:");
        String course = JOptionPane.showInputDialog("Enter the student course:");
        
        Student student = new Student(id, name, age, email, course);
        students.add(student);
        
        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");
    }

    //Make sure the students age is anove 16
    private int getValidAgeInput() {
        while (true) {
            String ageInput = JOptionPane.showInputDialog("Enter the student age:");
            if (ageInput != null && Student.isValidAgeInput(ageInput)) {
                return Integer.parseInt(ageInput);
            } else {
                JOptionPane.showMessageDialog(null, "You have entered an incorrect student age!!!");
            }
        }
    }

    // To search for a student 
    private void searchForStudent() {
        String id = JOptionPane.showInputDialog("Enter the student id to search:");
        for (Student student : students) {
            if (student.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, 
                    "STUDENT ID: " + student.getId() + "\n" +
                    "STUDENT NAME: " + student.getName() + "\n" +
                    "STUDENT AGE: " + student.getAge() + "\n" +
                    "STUDENT EMAIL: " + student.getEmail() + "\n" +
                    "STUDENT COURSE: " + student.getCourse());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student with Student Id: " + id + " was not found!");
    }

    //To delete a student 
    private void deleteStudent() {
        String id = JOptionPane.showInputDialog("Enter the student id to delete:");
        for (Student student : students) {
            if (student.getId().equals(id)) {
                int confirmation = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to delete student " + id + " from the system?", 
                        "Confirm Deletion", 
                        JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    students.remove(student);
                    JOptionPane.showMessageDialog(null, "Student with Student Id: " + id + " was deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion canceled.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student with Student Id: " + id + " was not found!");
    }

    //To print a student report
    private void printStudentReport() {
        StringBuilder report = new StringBuilder("STUDENT REPORT\n");
        if (students.isEmpty()) {
            report.append("No students found.");
        } else {
            for (Student student : students) {
                report.append(student).append("\n------------\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public static void main(String[] args) {
        StudentManagementApplication app = new StudentManagementApplication();
        app.run();
    }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning
//TechVidvan. (2023). Java Student Management System - A smarter way to manage your student records. [online]. Available at: https://www.techvidvan.com (Accessed: 29 August 2024).
//JavaTpoint. (2023). Java JOptionPane.[online]. Available at: https://www.javatpoint.com/java-joptionpane (Accessed: 29 August 2024). 