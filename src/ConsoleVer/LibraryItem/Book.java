package ConsoleVer.LibraryItem;

import ConsoleVer.LibraryItem.implem.PaperItem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Book extends LibraryItem implements PaperItem {
    Scanner scan = new Scanner(System.in);

    private String author;
    private String title;
    private String isbn; //международный стандартный книжный номер

    private static LinkedList<Book> books = new LinkedList<>(); // Collection for save book's
    private static String[] fantasyB;

    public Book(){} //Constructor for print book
    //This constructor for add new book
    public Book(String author, String title, String isbn, int id, String name, boolean isAvailable){
        super(id, name, isAvailable);
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }



    public void addBook(){
        System.out.println("Enter Author");
        String inAuthor = scan.nextLine();
        System.out.println("Enter title");
        String inTitle = scan.nextLine();
        System.out.println("Enter isbn");
        String inIsbn = scan.nextLine();
        System.out.println("Enter id");
        while (!scan.hasNextInt()){
            System.out.println("Please input integer number");
            scan.nextLine();
        }
        int inId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter type");
        String inType = scan.nextLine();
        Book b = new Book(inAuthor,inTitle,inIsbn,inId,inType,true);
        books.add(b);
    }

    public void addBook(int val){
        for(int i =0;i<=val;i++){
            System.out.println("Enter Author");
            String inAuthor = scan.nextLine();
            System.out.println("Enter title");
            String inTitle = scan.nextLine();
            System.out.println("Enter isbn");
            String inIsbn = scan.nextLine();
            System.out.println("Enter id");
            while (!scan.hasNextInt()){
                System.out.println("Please input integer number");
                scan.nextLine();
            }
            int inId = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter type");
            String inType = scan.nextLine();
            Book b = new Book(inAuthor,inTitle,inIsbn,inId,inType,true);
            books.add(b);
        }
    }

    public void printBook(){ // Print All Book
        try {
            for(int i = 0; i<books.size(); i++){
            System.out.println(books.get(i));
            }
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }
    }
    public void printBook(int val){ // Print n- Book
        try {
            System.out.println(books.get(val));
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }
    }


    private static void Lib(){

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
