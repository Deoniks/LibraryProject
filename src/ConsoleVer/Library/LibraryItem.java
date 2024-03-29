package ConsoleVer.Library;

public abstract class LibraryItem {
    private int id;
    private String name; //Type name(Book, magazine or dvd?)
    private boolean isAvailable;

    public LibraryItem(){}
    public LibraryItem(int id, String name, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayDetails(){
        System.out.printf("ID: %d, Name: %s, isAvailable: %s\n", id, name, isAvailable);
    }
}
