package java8.basic.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 40000));
        employees.add(new Employee("David", 25, 60000));

        // Define a Comparator to sort employees based on salary and age
        Comparator<Employee> salaryAndAgeComparator = Comparator
                .comparingDouble(Employee::getSalary)
                .thenComparingInt(Employee::getAge)
                .reversed(); // Sort age in descending order

        // Sort the list of employees using the Comparator
        Collections.sort(employees, salaryAndAgeComparator);

        // Print the sorted list of employees
        System.out.println("Sorted Employees:");
        employees.forEach(System.out::println);
    }
}
