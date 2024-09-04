// Name: Amit Deri; ID: 316443548

package mmn14;

public class Main {
    public static void main(String[] args) {
        SortedGroup<Student> studentGroup = new SortedGroup<>();

        // Add students to the sorted group
        studentGroup.add(new Student("Amit", 1, 60));
        studentGroup.add(new Student("Ofek", 2, 30));
        studentGroup.add(new Student("Ofek", 2, 30));
        studentGroup.add(new Student("Liraz", 3, 90));
        studentGroup.add(new Student("Netta", 4, 100));
        studentGroup.add(new Student("Daniel", 5, 80));

        // Print the sorted group of students
        System.out.println("Before removal:");
        for (Student student : studentGroup.getElements()) {
            System.out.println(student);
        }
        
        Reduce reduced = new Reduce();

        // Reduce the sorted group by filtering students with grades above 60
        SortedGroup<Student> reducedGroup = reduced.reduce(studentGroup, new Student("", 0, 60));

        // Print the reduced group of students
        System.out.println("After reduction:");
        for (Student student : reducedGroup.getElements()) {
            System.out.println(student);
        }
        
        Student studentToRemove = new Student("Ofek", 2, 30);
        int removedCount = studentGroup.remove(studentToRemove);
        System.out.println("Number of students removed: " + removedCount);

        // Print the sorted group of students after removal
        System.out.println("After removal:");
        for (Student student : studentGroup.getElements()) {
            System.out.println(student);
        }

    }
}


