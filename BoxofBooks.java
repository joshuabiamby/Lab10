import java.util.ArrayList;

class BoxofBooks{
    private String boxName;
    private ArrayList<String> books = new ArrayList<>();
    
    public BoxofBooks(String boxName){
        this.boxName = boxName;
    }

    public String getBoxName(){
        return boxName;
    }

    public void addBook(String boxName){
        books.add(0, boxName);
    }

    public String retrieveBook(){
        if(books.isEmpty()){
            return null;
        }
        return books.remove(0);

    }

    public BoxofBooks copy(){
        BoxofBooks copy = new BoxofBooks(this.boxName);
        copy.books.addAll(this.books);
        return copy;
    }


}
