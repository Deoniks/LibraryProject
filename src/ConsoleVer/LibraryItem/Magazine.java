package ConsoleVer.LibraryItem;

import ConsoleVer.LibraryItem.implem.PaperItem;

public class Magazine extends LibraryItem implements PaperItem {
    private String name;
    private String title;
    private String isbn;

    public Magazine(){}
    public Magazine(String name, String title, String isbn){
        this.name = name;
        this.title = title;
        this.isbn = isbn;
    }
}
