package ConsoleVer;

import ConsoleVer.Library.Book;
import ConsoleVer.Library.Dvd;
import ConsoleVer.Library.Magazine;
import ConsoleVer.MyException.UndefinedItemException;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

import java.util.LinkedList;
import java.util.Scanner;

public class test {
    static Scanner scan = new Scanner(System.in);
    private static String exitToLogin = "Exit Profile";
    private static String exitToProgram = "Exit Program";
    public static void main(String[] args) {
        testAddHashBook();
    }

    private static void testAddHashBook(){
        Member m = new Member();
        Book b = new Book();
        m.setBorrowableBook(b.getBooks().get(1));
        m.setBorrowableBook(b.getBooks().get(3));
        m.setBorrowableBook(b.getBooks().get(5));
        m.setBorrowableBook(b.getBooks().get(14));

        m.returnBorrowableBook(6);
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
