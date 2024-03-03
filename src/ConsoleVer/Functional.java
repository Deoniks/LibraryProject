package ConsoleVer;


import ConsoleVer.Library.Book;
import ConsoleVer.Library.LibraryAction;
import ConsoleVer.Library.Magazine;
import ConsoleVer.MyException.UndefinedItemException;
import ConsoleVer.Users.Librarian;
import ConsoleVer.Users.Member;

import java.util.LinkedList;
import java.util.Scanner;


public class Functional {
    protected static LibraryAction libraryAction = new LibraryAction(); // Перенёс сюда для удобного использования
    protected static Librarian librarian = new Librarian();
    protected static Member member = new Member();
    protected static boolean exitToLogin = false;
    protected static boolean exitToProgram = false;
    protected static Book book = new Book();
    protected static Magazine magazine = new Magazine();
    private static Scanner scan = new Scanner(System.in);

    public static boolean exitMethod(){
        while (!scan.hasNextInt()) {
            scan.nextLine();
        }
        int exit = scan.nextInt();
        if (exit > 0 && exit < 3) {
            switch (exit) {
                case 1 -> {
                    member.setAccountStatus(false);
                    return exitToLogin = true;
                }
                case 2 -> {
                    return exitToProgram = false;
                }
            }
        } else if (exit > 2) {
            System.err.println("Sorry, there is no such option.");
            return exitToLogin = true;
        }
        return exitToProgram = true;
    }
    public static String menuActivateOrDeactivate(){
        while (!scan.hasNextInt()){
            scan.nextLine();
        }
        int n = scan.nextInt();
        scan.nextLine();
        System.out.println("Print login user");
        String login = scan.nextLine();
        if(n==1){
            activateProfile(login);
            return "Activate";
        }else if(n==2){
            deactivateProfile(login);
            return "Deactivate";
        }
        return "n";
    }
    public static void borrawbleMenu(int index){
        switch (index){
            case 1->{
                book.printBook(member.getAccountStatus());
                int entUid = 0;
                int j = 0;
                do {
                    System.out.println("Please enter id book");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter num");
                    }
                    entUid = scan.nextInt();
                    for (int i = 0; i < book.getBooks().size(); i++) {
                        if (entUid == book.getBooks().get(i).getId()) {
                            if(book.getBooks().get(i).isAvailable() == true){
                                try {
                                    member.setBorrowableBook(book.getBooks().get(i));
                                    libraryAction.borrowableItem(book,entUid);
                                    System.out.println(book.getBooks().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }else member.setBorrowableBook(book.getBooks().get(i));
                            break;
                        }else j=i;
                    }if (entUid == 1){
                        j++;
                    }
                }while (entUid == book.getBooks().get(j).getId());
            }
            case 2->{
                magazine.printMagazine(member.getAccountStatus());
                int entUid = 0;
                int j = 0;
                do {
                    System.out.println("Please enter id book");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter num");
                    }
                    entUid = scan.nextInt();
                    for (int i = 0; i < magazine.getMagazine().size(); i++) {
                        if (entUid == magazine.getMagazine().get(i).getId()) {
                            if(magazine.getMagazine().get(i).isAvailable() == true){
                                try {
                                    member.setBorrowableMagazine(magazine.getMagazine().get(i));
                                    libraryAction.borrowableItem(magazine,entUid);
                                    System.out.println(magazine.getMagazine().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }else member.setBorrowableMagazine(magazine.getMagazine().get(i));
                            break;
                        }else j=i;
                    }if (entUid == 1){
                        j++;
                    }
                }while (entUid == magazine.getMagazine().get(j).getId());
            }
        }
    }
    public static void returnMenu(int index){
        switch (index){
            case 1->{
                for(int i =0; i <member.getBorrowableBook().size();i++){
                    System.out.println(member.getBorrowableBook().get(i));
                }
                System.out.println("Enter id for return book");
                while (!scan.hasNextInt()){
                    System.out.println("Please enter number");
                }
                int ind = scan.nextInt();
                member.returnBorrowableBook(ind);
            }
            case 2->{
                for(int i =0; i <member.getBorrowableBook().size();i++){
                    System.out.println(member.getBorrowableBook().get(i));
                }
                System.out.println("Enter id for return book");
                while (!scan.hasNextInt()){
                    System.out.println("Please enter number");
                }
                int ind = scan.nextInt();
                member.returnBorrowableMagazine(ind);
            }
        }
    }
    private static void activateProfile(String login){
        while (scan.hasNextLine()){
            Member m = new Member();
            int s = m.getUsers().size();
            for(int i = 0; i<s;i++){
                String test = scan.nextLine();
                if(test.equals(m.getUsers().get(i).getLogin())){
                    librarian.activateUser(member,login);
                }
            }
        }
    }
    private static void deactivateProfile(String login){
        while (scan.hasNextLine()){
            Member m = new Member();
            int s = m.getUsers().size();
            for(int i = 0; i<s;i++){
                String test = scan.nextLine();
                if(test.equals(m.getUsers().get(i).getLogin())){
                    librarian.deactivateUser(member,login);
                }
            }
        }
    }
}
