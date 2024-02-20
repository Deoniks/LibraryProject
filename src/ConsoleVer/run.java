package ConsoleVer;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class run {
    private static Scanner scan = new Scanner(System.in);
    private static Librarian librarian = new Librarian();
    private static Member member = new Member();
    private static String exitToLogin = "Exit Profile";
    private static String exitToProgram = "Exit Program";
    private static String isExit = exitToLogin;
    private static int wUser = 0; //переменная для хранения выбранного пользователя
    private static String lib = "Librarian";
    private static String memb = "Member";
    private static Book book = new Book();

    public static void main(String[] args) {
        while (isExit.equals(exitToLogin)) {
            String enterUser = loginMenu(); //Запуск-меню-выбор-авторизация
            if (lib.equals(enterUser)) {
                menuLibrarian();
            } else if (memb.equals(enterUser)) {
                menuMember();
            }
        }
        System.out.println("Bye!");
    }

    public static String loginMenu() {
        System.out.println("Who you(Pls input 1 or 2):\n1.Librarian \n2.Member");
        while (!scan.hasNextInt()) { //Вместо try-catch системы использовал данную конструкцию, данный момент это позволяет...
            System.err.println("Pleas input 1 or 2 ");
            scan.nextLine();
        }
        wUser = scan.nextInt();
        scan.nextLine();
        switch (wUser) {
            case 1:
                System.out.println("Librarian, please enter login");
                String loginLib = scan.nextLine();
                System.out.println("Enter password");
                String passwordLib = scan.nextLine();
                return librarian.enterLibrarian(loginLib,passwordLib);
            case 2:
                System.out.println("Member, please enter login");
                String loginM = scan.nextLine();
                System.out.println("Enter password");
                String passwordM = scan.nextLine();
                return member.enterMember(loginM,passwordM);
            default:
                System.err.println("Not found users");
                scan.nextLine();
                return selectExit(exitToLogin);
        }
    }
    public static void menuMember() {
        while (!isExit.equals(exitToProgram)) {
            System.out.println("\n_____________________________________________________\n");
            System.out.println("1.Borrowable Item\n2.Return Item\n3.Check Profile\n4.Exit");
            while (!scan.hasNextInt()) {
                System.err.println("Please enter 1-4");
                scan.nextLine();
            }
            wUser = scan.nextInt();
            switch (wUser) {
                case 1 -> {
                    selectExit(exitToLogin);
                    System.out.println("Rent");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter 1-3");
                        scan.nextLine();
                    }
                    int rent = scan.nextInt();
                    switch (rent) {
                        case 1 -> {
                            System.out.println("Book");
                            book.printBook(member.getAuthorization());
                            System.out.println("Please enter id book");
                            int entUid = 0;
                            while (!scan.hasNextInt()) {
                                System.err.println("Please enter num");
                            }

                        }
                        case 2 -> {
                            System.out.println("DVD");
                        }
                        case 3 -> {
                            System.out.println("Magazine");
                        }
                    }
                }
                case 2 -> {
                    selectExit(exitToLogin);
                    System.out.println("Return...");
                }
                case 3 -> {
                    selectExit(exitToLogin);
                    System.out.println("Check Profile");
                }
                case 4 -> {
                    System.out.println("Exit:\n1.Profile\n2.Program");
                    exitMethod();
                }
            }
        }
    }
    public static void menuLibrarian() {
        while (!isExit.equals(exitToProgram)){
            System.out.println("\n_____________________________________________________\n");
            System.out.println("1.Library Item\n2.De/a'ctivate Profile\n3.Check Profile\n4.Exit");
            while (!scan.hasNextInt()) {
                System.err.println("Please enter 1-4");
                scan.nextLine();
            }
            wUser = scan.nextInt();
            switch (wUser) {
                case 1 -> {
                    selectExit(exitToLogin);
                    System.out.println("Rent");
                    Book b = new Book();
                    b.printBook();
                }
                case 2 -> {
                    selectExit(exitToLogin);
                    System.out.println("Return...");
                }
                case 3 -> {
                    selectExit(exitToLogin);
                    System.out.println("Check Profile");
                }
                case 4 -> {
                    System.out.println("Exit:\n1.Profile\n2.Program");
                    exitMethod();
                }
            }
        }
    }
    public static String exitMethod(){
        while (!scan.hasNextInt()) {
            scan.nextLine();
        }
        int exit = scan.nextInt();
        if (exit > 0 && exit < 3) {
            switch (exit) {
                case 1 -> {
                    return selectExit(exitToLogin);
                }
                case 2 -> {
                    return selectExit(exitToProgram);
                }
            }
        } else if (exit > 2) {
            System.err.println("Sorry, there is no such option.");
            return selectExit(exitToLogin);
        }
        return selectExit("n");
    }
    public static String selectExit(String exit){
        isExit = exit;
        return exit;
    }
}
