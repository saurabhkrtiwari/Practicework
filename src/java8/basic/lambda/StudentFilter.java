package java8.basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 60));
        students.add(new Student("Charlie", 75));
        students.add(new Student("David", 90));

        // Define a Predicate to filter students who have scored above a certain threshold
        Predicate<Student> passedPredicate = student -> student.getScore() >= 70;

        // Filter the students based on the Predicate
        List<Student> passedStudents = filterStudents(students, passedPredicate);

        // Print the names of the passed students
        System.out.println("Passed students:");
        passedStudents.forEach(student -> System.out.println(student.getName()));
    }

    public static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
