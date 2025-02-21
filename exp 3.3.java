import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int maxStudents;
    private int enrolledStudents;
    private String prerequisite;
    
    public Course(String name, int maxStudents, String prerequisite) {
        this.name = name;
        this.maxStudents = maxStudents;
        this.prerequisite = prerequisite;
        this.enrolledStudents = 0;
    }
    
    public void enrollStudent(String student, boolean hasPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (!hasPrerequisite) {
            throw new PrerequisiteNotMetException("Error: Complete " + prerequisite + " before enrolling in " + name + ".");
        }
        if (enrolledStudents >= maxStudents) {
            throw new CourseFullException("Error: " + name + " is full.");
        }
        enrolledStudents++;
        System.out.println(student + " successfully enrolled in " + name);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course advancedJava = new Course("Advanced Java", 2, "Core Java");
        
        try {
            System.out.print("Enter student name: ");
            String student = scanner.next();
            System.out.print("Has completed Core Java? (true/false): ");
            boolean hasPrerequisite = scanner.nextBoolean();
            advancedJava.enrollStudent(student, hasPrerequisite);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
