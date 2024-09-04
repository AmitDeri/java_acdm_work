// Name: Amit Deri; ID: 316443548

package mmn14;

import java.util.Objects;

// Student class where we create a constructor with the values of name id and grade
// there is also the toString method which will show us the student name id and grade friendly to the user (implementation of toString in Comparable)
// as well we implemented the compareTo which compare two students grades 
// and finally we implemented the equals to check if two students is actually the same
public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private int grade;

    public Student(String name, int id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade=" + grade +
                '}';
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return id == other.id && grade == other.grade && Objects.equals(name, other.name);
    }
}

