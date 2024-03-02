package ConsoleVer;

import ConsoleVer.Library.Book;
import ConsoleVer.Library.LibraryAction;

import java.util.Scanner;

public class run extends Functional{
    private static Scanner scan = new Scanner(System.in);
    private static int wUser = 0; //переменная для хранения выбора пользователя
    private static String lib = "Librarian";
    private static String memb = "Member";

    public static void main(String[] args) {
        while (exitToProgram == false) {
            exitToLogin = false;
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
        while (!scan.hasNextInt()) { //Вместо try-catch использовал данную конструкцию, данный момент это позволяет...
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
                memb = loginM;
                System.out.println("Enter password");
                String passwordM = scan.nextLine();
                return member.enterMember(loginM,passwordM);
            default:
                System.err.println("Not found users");
                scan.nextLine();
                return "n";
        }
    }
    public static void menuMember() {
        while (exitToLogin == false) {
            member.setAccountStatus(true);
            System.out.println("\n_____________________________________________________\n");
            System.out.println("1.Borrowable Item\n2.Return Item\n3.Check Profile\n4.Exit");
            while (!scan.hasNextInt()) {
                System.err.println("Please enter 1-4");
                scan.nextLine();
            }
            wUser = scan.nextInt();
            switch (wUser) {
                case 1 -> {
                    System.out.println("1.Book\n2.Magazine\n3.DvD");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter 1-3");
                        scan.nextLine();
                    }
                    int rent = scan.nextInt();
                    Functional.borrawbleMenu(rent);
                }
                case 2 -> {
                    System.out.println("1.Book\n2.Magazine\n3.DvD");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter 1-3");
                        scan.nextLine();
                    }
                    int rent = scan.nextInt();
                    Functional.returnMenu(rent);

                }
                case 3 -> {
                    System.out.println("Check Profile");
                    if(member.test() == true){
                        System.out.println("Active");
                    }else System.out.println("False");
                }
                case 4 -> {
                    System.out.println("Exit:\n1.Profile\n2.Program");
                    exitMethod();
                }
            }
        }
    }
    public static void menuLibrarian() {
        while (exitToLogin == false){
            System.out.println("\n_____________________________________________________\n");
            System.out.println("1.Library Item\n2.De/a'ctivate Profile\n3.Check Profile\n4.Exit");
            while (!scan.hasNextInt()) {
                System.err.println("Please enter 1-4");
                scan.nextLine();
            }
            wUser = scan.nextInt();
            switch (wUser) {
                case 1 -> {
                    System.out.println("Rent");
                    Book b = new Book();
                    b.printBook();
                }
                case 2 -> {
                    System.out.println("1.Activate Profile\n2.Deactivate Profile");
                    menuActivateOrDeactivate();
                }
                case 3 -> {
                    System.out.println("Check Profile");
                }
                case 4 -> {
                    System.out.println("Exit:\n1.Profile\n2.Program");
                    exitMethod();
                }
            }
        }
    }

}
