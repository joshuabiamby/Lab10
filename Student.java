
public class Student {
    private String name;
    private BoxofBooks boxofBooks;
    
    public Student(String name, BoxofBooks boxofBooks) {
        this.name = name;
        this.boxofBooks = boxofBooks;
    }

    public String unpackBoxOfBooks() {
        String result = "";
        String book = boxofBooks.retrieveBook();

        while (book != null) {
            if (result.length() > 0) {
                result += "\n";
            }
            result += book;
            book = boxofBooks.retrieveBook();
        }
        return result;
    }

    @Override 
    public String toString(){
        return "Student: " + name + "\nBooks:\n" + unpackBoxOfBooks();
    }


}
