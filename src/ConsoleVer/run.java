package ConsoleVer;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class run {
    private static Scanner scan = new Scanner(System.in);
    private static int wUser = 0; //переменная для хранения выбранного пользователя



    public static void main(String[] args) {
        String enterUser = loginMenu(); //Запуск-меню-выбор-авторизация
        while ("EXIT".equals(enterUser)){
            if("Librarian".equals(enterUser)){
                System.out.println("L");
                menuLibrarian();
            } else if ("Member".equals(enterUser)) {
                menuMember();
            }
        }
        System.out.println("Bye!");
    }

    public static String loginMenu() {
        Librarian librarian = new Librarian();
        Member member = new Member();
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
                String loginL = scan.nextLine();
                for (int i = 0; i < librarian.getLibrarian().length; i++) {
                    if (loginL.toLowerCase().equals(librarian.getLibrarian()[i][0].toLowerCase())) { //Ввод любым регистром, т.к. регистрирует админ...
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
                for (int i = 0; i < member.getMember().length; i++) {//Ввод чувствителен к регистру, т.к. это пользователь
                    if (loginM.equals(member.getMember()[i][0])) {
                        System.out.println("Enter password");
                        String password = scan.nextLine();
                        if (password.equals(member.getMember()[i][1])) {
                            System.out.println("True, this user check");
                            menuMember();
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

    public static void menuMember(){
        System.out.println("\n_____________________________________________________\n");
        System.out.println("1.Borrowable Item\n2.Return Item\n3.Check Profile\n4.Exit");
        while (!scan.hasNextInt()){
            System.err.println("Please enter 1-4");
            scan.nextLine();
        }
        wUser = scan.nextInt();
        switch (wUser){
            case 1->{
                System.out.println("Rent");
                Book b = new Book();
                b.printBook();
            }
            case 2->{
                System.out.println("Return...");
            }
            case 3->{
                System.out.println("Check Profile");
            }
            case 4->{
                System.out.println("Exit:\n1.Profile\n2.Program");
                while (!scan.hasNextInt()){
                    scan.nextLine();
                }
                int exit = scan.nextInt();
                switch (exit){
                    case 1->loginMenu();
                    case 2-> exitProg();
                }
            }
        }
    }

    public static void menuLibrarian(){
        System.out.println("\n_____________________________________________________\n");
        System.out.println("1.Library Item\n2.De/a'ctivate Profile\n3.Check Profile\n4.Exit");
    }

    public static String exitProg(){
        return "EXIT";
    }
}
