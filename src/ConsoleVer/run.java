package ConsoleVer;

import ConsoleVer.LibraryItem.Book;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class run {
    static Scanner scan = new Scanner(System.in);
    private static int wUser = 0;



    public static void main(String[] args) {
        String enterUser = loginMenu();
        if("Librarian".equals(enterUser)){
            System.out.println("L");
        } else if ("Member".equals(enterUser)) {
            System.out.println("M");
            Book b = new Book();
            b.addBook();
            b.addBook(2);
            b.printBook();
        }
    }

    public static String loginMenu(){
        System.out.println("Who you(Pls input 1 or 2):\n1.Librarian \n2.Member");
        while (!scan.hasNextInt()){
            System.err.println("Pleas input 1 or 2 ");
            scan.nextLine();
        }
        wUser = scan.nextInt();
        switch (wUser){
            case 1 :
                System.out.println("Librarian");
                return "Librarian";

            case 2 :
                System.out.println("Member");
                return "Member";
            default :
                System.err.println("Not found users");
                scan.nextLine();
                return loginMenu();
        }
    }
}
