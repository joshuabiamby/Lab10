import java.util.ArrayList;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BoxofBooks> boxes = new ArrayList<>();

        // addBook inserts at the top, so push each box's books in the order
        // specified by the lab. The last one pushed will be delivered first.
        BoxofBooks programming = new BoxofBooks("Programming");
        programming.addBook("Databases made Simple");
        programming.addBook("Macros and Scripts");
        programming.addBook("Programming Basics");
        boxes.add(programming);

        BoxofBooks chemistry = new BoxofBooks("Chemistry");
        chemistry.addBook("Organic Chemistry");
        chemistry.addBook("Inorganic Chemistry");
        chemistry.addBook("The Periodic Table of Elements");
        boxes.add(chemistry);

        BoxofBooks mathematics = new BoxofBooks("Mathematics");
        mathematics.addBook("Linear Algebra");
        mathematics.addBook("Calculus I and II");
        mathematics.addBook("Pre-Calculus");
        boxes.add(mathematics);

        QueueOfStudents queueOfStudents = new QueueOfStudents();
        boolean running = true;

        System.out.println("[Book Delivery Scheduler]");
        while (running) {
            System.out.println("\n1. Add student");
            System.out.println("2. Create box of books");
            System.out.println("3. Deliver all boxes");
            System.out.print("Enter option: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                input.nextLine();
                continue;
            }

            int option = input.nextInt();
            input.nextLine(); // consume the rest of the menu input line

            switch (option) {
            case 1:
            {
                System.out.print("\nEnter name of student: ");
                String studentName = input.nextLine();

                for (int i = 0; i < boxes.size(); i++) {
                    System.out.println(i + ": " + boxes.get(i).getBoxName());
                }

                System.out.print("Give them which box? ");
                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid box number.");
                    input.nextLine();
                    break;
                }
                int boxIndex = input.nextInt();
                input.nextLine();

                if (boxIndex < 0 || boxIndex >= boxes.size()) {
                    System.out.println("That box number is not available.");
                    break;
                }

                Student student = new Student(studentName, boxes.get(boxIndex).copy());
                queueOfStudents.registerForPickup(student);
                System.out.println("Student added to queue.");
                break;
            }
            case 2:
            {
                System.out.print("\nEnter box name: ");
                String boxName = input.nextLine();
                BoxofBooks newBox = new BoxofBooks(boxName);

                while (true) {
                    System.out.print("Enter name of book or '-done': ");
                    String bookName = input.nextLine();
                    if (bookName.equals("-done")) {
                        break;
                    }
                    newBox.addBook(bookName);
                    System.out.println("Book added to box.");
                }

                boxes.add(newBox);
                System.out.println("Box of Books registered for future use.");
                break;
            }
            case 3:
            {
                System.out.println("\nHere are all the students and the contents of their boxes:");
                Student student = queueOfStudents.deliverBoxOfBooks();
                while (student != null) {
                    System.out.println(student);
                    System.out.println();
                    student = queueOfStudents.deliverBoxOfBooks();
                }
                System.out.println("Shutting off...");
                running = false;
                break;
            }
            default:
                System.out.println("Please enter 1, 2, or 3.");
            }
        }

        input.close();
    }
}
