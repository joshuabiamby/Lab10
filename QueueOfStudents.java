import java.util.ArrayList;

public class QueueOfStudents {
    private ArrayList<Student> students = new ArrayList<>();
    
    public QueueOfStudents() { }

    public void registerForPickup(Student s) {// designed to be like enqueue
        students.add(s);
    }

    public Student deliverBoxOfBooks() {// designed to be like dequeue
        if (students.isEmpty()) {
            return null;
        }
        return students.remove(0);
    }


}
