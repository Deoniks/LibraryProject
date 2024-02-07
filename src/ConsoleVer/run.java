package ConsoleVer;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

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
            b.printBook();
        }
    }

    public static String loginMenu() {
        Librarian librarian = new Librarian();
        Member member = new Member();
        System.out.println("Who you(Pls input 1 or 2):\n1.Librarian \n2.Member");
        while (!scan.hasNextInt()) {
            System.err.println("Pleas input 1 or 2 ");
            scan.nextLine();
        }
        wUser = scan.nextInt();
        scan.nextLine();
        switch (wUser) {
            case 1:
                System.out.println("Librarian, please enter login");
                String loginL = scan.nextLine();
                for (int i = 0; i < librarian.getLibrarian().length; i++) {
                    if (loginL.toLowerCase().equals(librarian.getLibrarian()[i][0].toLowerCase())) {
                        System.out.println("Enter password");
                        String password = scan.nextLine();
                        if (password.toLowerCase().equals(librarian.getLibrarian()[i][1].toLowerCase())) {
                            System.out.println("True, this user check");
                            return "Librarian";
                        } else {
                            System.out.println("Sorry,wrong password");
                        }
                    } else if(i == librarian.getLibrarian().length-1){
                        System.out.println("Sorry, it's not user");
                    }
                }
                return "null";
            case 2:
                System.out.println("Member, please enter login");
                String loginM = scan.nextLine();
                for (int i = 0; i < member.getMember().length; i++) {
                    if (loginM.equals(member.getMember()[i][0])) {
                        System.out.println("Enter password");
                        String password = scan.nextLine();
                        if (password.equals(member.getMember()[i][1])) {
                            System.out.println("True, this user check");
                            return "Member";
                        } else {
                            System.out.println("Sorry,wrong password");
                        }
                    }else if(i == member.getMember().length-1){
                        System.out.println("This users it's not found");
                    }
                }
                return "null";

            default:
                System.err.println("Not found users");
                scan.nextLine();
                return loginMenu();
        }
    }
}
