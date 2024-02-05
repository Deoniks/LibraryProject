package ConsoleVer.LibraryItem;

import ConsoleVer.LibraryItem.eJanre.Fantasy;
import ConsoleVer.LibraryItem.implem.PaperItem;

import java.util.Arrays;
import java.util.LinkedList;

public class Book extends LibraryItem implements PaperItem {

    private String author;
    private String title;
    private String isbn; //международный стандартный книжный номер

    private static LinkedList<Book> books = new LinkedList<>();
    private static String[] fantasyB;

    public Book(){}

    public Book(String author, String title, String isbn, int id, String name, boolean isAvailable){
        super(id, name, isAvailable);
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public void fantasyBook(){
        int fArr = bookEn.getFantasyBook().length;
        for(int i =0; i<fArr;i++){

            String formated = String.valueOf(bookEn.getFantasyBook()[i]);
            System.out.println(formated.replace('_',' '));
        }
        System.out.println(Fantasy.getFantasy());
    }


    public void addBook(){
        int aE = bookEn.Fantasy.ordinal();
        bookEn.getA();
        Book b = new Book("Roling",bookEn.Harry_Potter_And_The_Chamber_Of_Secrets.name(),"123.12.31",1,"HarryPotter1",true);
        books.add(b);
    }

    public void printBook(){
        try {
            System.out.println(books.get(0));
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\n' +
                "id= " + getId() +
                '}';
    }
}
