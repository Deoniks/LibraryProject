package ConsoleVer;

import ConsoleVer.Library.*;
import ConsoleVer.MyException.UndefinedItemException;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

import java.util.LinkedList;
import java.util.Scanner;

public class test extends Functional{
    static Scanner scan = new Scanner(System.in);
    private static String exitToLogin = "Exit Profile";
    private static String exitToProgram = "Exit Program";
    public static void main(String[] args) {
        testReturnBook();
    }

    private static void testReturnBook(){

        member.setBorrowableBook(book.getBooks().get(2));
        Functional.returnMenu(1);
    }
    private static void testSetBorrowable(){
        Book book = new Book();
        Member member = new Member();
        member.setBorrowableBook(book.getBooks().get(4));
        member.setBorrowableBook(book.getBooks().get(25));
        member.setBorrowableBook(book.getBooks().get(14));
        member.setBorrowableBook(book.getBooks().get(5));
        member.returnBorrowableBook(5);
    }

    private static void testAddHashBook(){
        LibraryAction lA = new LibraryAction();
        Book book = new Book();
        try {
            lA.addItem(book);
        }catch (UndefinedItemException ute){
            System.err.println("There is no such element");
        }
        book.printBook();
    }

    private static void testAddItem(){
        LinkedList<Book> i = new LinkedList<>();
        Book b = new Book();
        i.add(b.getBooks().get(3));
        System.out.println(i.get(0));

        Book bo = new Book();
        Dvd d = new Dvd();
        Magazine mag = new Magazine();
        Librarian l = new Librarian();
        Member m = new Member();
        try {
            m.setBorrowableItem(bo,2);
            System.out.println();
        }catch (UndefinedItemException e){
            System.err.println("This class is not a subclass of library item");
        }
    }
    private static void testStart(){
        String exit = exitToProgram;
        do {
            Book b = new Book();
            b.borrowableBook(105);
            b.printFindBookToTitle("Member", "Гарри");
            int n = scan.nextInt();
            scan.nextLine();
            switch (n){
                case 1 ->{
                    exit = exitToLogin;
                }
                case 2 ->
                    exit = exitToProgram;
            }
        }while (!exit.equals(exitToLogin));
    }
}
