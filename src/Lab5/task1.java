package Lab5;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.course, other.course);
    }

    @Override
    public String toString() {
        return "Студент: " + name + ", Курс: " + course;
    }
}



public class task1 {
    public static void printStudents(LinkedList<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static LinkedList<Student> union(LinkedList<Student> set1, LinkedList<Student> set2) {
        HashSet<Student> set = new HashSet<>(set1);
        set.addAll(set2);
        return new LinkedList<>(set);
    }

    public static LinkedList<Student> intersect(LinkedList<Student> set1, LinkedList<Student> set2) {
        HashSet<Student> set = new HashSet<>(set1);
        set.retainAll(set2);
        return new LinkedList<>(set);
    }

    public static void task() {
        LinkedList<Student> students = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student("Студент " + i, i % 5 + 1));
        }

        System.out.println("Студенты на 3 курсе:");
        printStudents(students, 3);

        LinkedList<Student> students1 = new LinkedList<>(students.subList(0, 5));
        LinkedList<Student> students2 = new LinkedList<>(students.subList(5, 10));

        System.out.println("\nОбъединение двух множеств:");
        System.out.println(union(students1, students2));

        System.out.println("\nПересечение двух множеств:");
        System.out.println(intersect(students1, students2));

        TreeSet<Student> sortedStudents = new TreeSet<>(students);
        System.out.println("\nСтуденты, отсортированные по курсу:");
        System.out.println(sortedStudents);
    }
}
