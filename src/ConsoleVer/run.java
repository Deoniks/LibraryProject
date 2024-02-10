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
    private static String librarian = "Librarian";
    private static String member = "Member";

    public static void main(String[] args) {
        String enterUser = loginMenu(); //Запуск-меню-выбор-авторизация
        while (!"EXIT".equals(enterUser)){
            if(librarian.equals(enterUser)){
                menuLibrarian();
            } else if (member.equals(enterUser)) {
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
                String loginLib = scan.nextLine();
                System.out.println("Enter password");
                String passwordLib = scan.nextLine();
                return librarian.enterLibrarian(loginLib,passwordLib);
            case 2:
                System.out.println("Member, please enter login");
                String loginM = scan.nextLine();
                for (int i = 0; i < member.getMember().length; i++) {//Ввод чувствителен к регистру, т.к. это пользователь
                    if (loginM.equals(member.getMember()[i][0])) {
                        System.out.println("Enter password");
                        String passwordM = scan.nextLine();
                        if (passwordM.equals(member.getMember()[i][1])) {
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

    public static String exitProg(){
        return "EXIT";
    }
}
