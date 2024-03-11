package ConsoleVer;


import ConsoleVer.Library.Book;
import ConsoleVer.Library.Dvd;
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
    protected static Dvd dvd = new Dvd();
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
                    exitToLogin = true;
                    return exitToProgram = true;
                }
            }
        } else if (exit > 2) {
            System.err.println("Sorry, there is no such option.");
            return exitToLogin = true;
        }
        return exitToProgram = true;
    }
    public static String menuActivateOrDeactivate(){
        System.out.println("1.Activate Profile\n2.Deactivate Profile");
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
                        scan.nextLine();
                    }
                    entUid = scan.nextInt();
                    for (int i = 0; i < book.getBooks().size(); i++) {
                        if (entUid == book.getBooks().get(i).getId()) {
                            if(book.getBooks().get(i).isAvailable() == true){
                                try {
                                    for(int z=0;z<member.getUsers().size();i++) {
                                        if(member.getUsers().get(z).getAccountStatus() == true) {
                                            member.getUsers().get(z).setBorrowableItem(member,book.getBooks().get(i));
                                            libraryAction.borrowableItem(book, entUid);
                                            System.out.println(book.getBooks().get(i));
                                            break;
                                        }
                                    }
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }else {
                                try{
                                    member.setBorrowableItem(member, book.getBooks().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
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
                                    member.setBorrowableItem(member,magazine.getMagazine().get(i));
                                    libraryAction.borrowableItem(magazine,entUid);
                                    System.out.println(magazine.getMagazine().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }else {
                                try{
                                    member.setBorrowableItem(member, magazine.getMagazine().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
                            break;
                        }else j=i;
                    }if (entUid == 1){
                        j++;
                    }
                }while (entUid == magazine.getMagazine().get(j).getId());
            }
            case 3->{
                dvd.printDvd(member.getAccountStatus());
                int entUid = 0;
                int j = 0;
                do {
                    System.out.println("Please enter id dvb");
                    while (!scan.hasNextInt()) {
                        System.err.println("Please enter num");
                    }
                    entUid = scan.nextInt();
                    for (int i = 0; i < dvd.getDvd().size(); i++) {
                        if (entUid == dvd.getDvd().get(i).getId()) {
                            if(dvd.getDvd().get(i).isAvailable() == true){
                                try {
                                    member.setBorrowableItem(member,dvd.getDvd().get(i));
                                    libraryAction.borrowableItem(dvd,entUid);
                                    System.out.println(dvd.getDvd().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }else {
                                try{
                                    member.setBorrowableItem(member, dvd.getDvd().get(i));
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
                            break;
                        }else j=i;
                    }if (entUid == 1){
                        j++;
                    }
                }while (entUid == dvd.getDvd().get(j).getId());
            }
        }
    }
    public static void returnMenu(int index){
        switch (index){
            case 1->{
                for(int i =0; i< member.getUsers().size();i++) {
                    if(member.getUsers().get(i).getAccountStatus() == true) {
                        for (int j = 0; j < member.getUsers().get(i).getBorrowableBook().size(); j++) {
                            System.out.println(member.getUsers().get(i).getBorrowableBook().get(j));
                        }
                    }
                }
                System.out.println("Enter id for return book");
                while (!scan.hasNextInt()){
                    System.out.println("Please enter number");
                }
                int ind = scan.nextInt();
                member.returnBorrowableBook(member,ind);
                libraryAction.returnItem(book,ind);
            }
            case 2->{
                for(int i =0; i <member.getBorrowableMagazine().size();i++){
                    System.out.println(member.getBorrowableMagazine().get(i));
                }
                System.out.println("Enter id for return magazine");
                while (!scan.hasNextInt()){
                    System.out.println("Please enter number");
                }
                int ind = scan.nextInt();
                member.returnBorrowableMagazine(ind);
                libraryAction.returnItem(magazine,ind);
            }
            case 3->{
                for(int i =0; i <member.getBorrowableDvd().size();i++){
                    System.out.println(member.getBorrowableDvd().get(i));
                }
                System.out.println("Enter id for return dvd");
                while (!scan.hasNextInt()){
                    System.out.println("Please enter number");
                }
                int ind = scan.nextInt();
                member.returnBorrowableDvd(ind);
                libraryAction.returnItem(dvd,ind);
            }
            case 4->{
                member.returnAllBorrowableItem();
                System.out.println("You successfully return all item ");
            }
        }
    }
    public static void addDeleteMenu(int index)throws UndefinedItemException{
        switch (index){
            case 1->{
                if(index == 1){
                    System.out.println("1.Add Item\n2.Add User");
                    while (!scan.hasNextInt()){
                        scan.nextLine();
                    }
                    int check = scan.nextInt();
                    scan.nextLine();
                    switch (check){
                        case 1->{
                            System.out.println("1.Add book\n2.Add Magazine\n3.Add DvD");
                            while (!scan.hasNextInt()){
                                scan.nextLine();
                            }
                            int item = scan.nextInt();
                            switch(item){
                                case 1->{
                                    try{
                                        libraryAction.addItem(book);
                                    }catch (UndefinedItemException e){
                                        System.err.println("Not object");
                                    }
                                }
                                case 2->{
                                    try{
                                        libraryAction.addItem(magazine);
                                    }catch (UndefinedItemException e){
                                        System.err.println("Not object");
                                    }
                                }
                                case 3->{
                                    try{
                                        libraryAction.addItem(dvd);
                                    }catch (UndefinedItemException e){
                                        System.err.println("Not object");
                                    }
                                }
                            }
                        }
                        case 2->{
                            libraryAction.addUser(member);
                        }
                    }
                }else throw new UndefinedItemException();
            }
            case 2->{
                System.out.println("1.Delete Item\n2.Delete User");
                while (!scan.hasNextInt()){
                    scan.nextLine();
                }
                int check = scan.nextInt();
                switch (check){
                    case 1->{
                        System.out.println("1.Delete book\n2.Delete Magazine\n3.Delete DvD");
                        while (!scan.hasNextInt()){
                            scan.nextLine();
                        }
                        int item = scan.nextInt();
                        switch(item){
                            case 1->{
                                try{
                                    for (int i = 0;i < book.getBooks().size();i++) {
                                        System.out.println(book.getBooks().get(i));
                                    }
                                    System.out.println("Enter id");
                                    while (!scan.hasNextInt()){
                                        scan.nextLine();
                                    }
                                    int id = scan.nextInt();
                                    libraryAction.returnItem(book, id);
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
                            case 2->{
                                try{
                                    for (int i = 0;i < magazine.getMagazine().size();i++) {
                                        System.out.println(magazine.getMagazine().get(i));
                                    }
                                    System.out.println("Enter id");
                                    while (!scan.hasNextInt()){
                                        scan.nextLine();
                                    }
                                    int id = scan.nextInt();
                                    libraryAction.returnItem(magazine, id);
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
                            case 3->{
                                try{
                                    for (int i = 0;i < dvd.getDvd().size();i++) {
                                        System.out.println(dvd.getDvd().get(i));
                                    }
                                    System.out.println("Enter id");
                                    while (!scan.hasNextInt()){
                                        scan.nextLine();
                                    }
                                    int id = scan.nextInt();
                                    libraryAction.returnItem(dvd, id);
                                }catch (UndefinedItemException e){
                                    System.err.println("Not object");
                                }
                            }
                        }
                    }
                    case 2->{
                        System.out.println("Enter login user");
                        scan.nextLine();
                        String login = scan.nextLine();
                        deleteUser(login);
                    }
                }
            }
        }
    }
    private static void activateProfile(String login){
        for(int i = 0; i<member.getUsers().size();i++){
            if(login.equals(member.getUsers().get(i).getLogin())){
                member.getUsers().get(i).activate();
                break;
            }
        }
    }
    private static void deactivateProfile(String login){
        for(int i = 0; i<member.getUsers().size();i++){
            if(login.equals(member.getUsers().get(i).getLogin())){
                member.getUsers().get(i).deactivate();
                break;
            }
        }
    }
    public static void isOnline(){
        for(int i =0;i<member.getUsers().size();i++){
            if(member.getAuthorization().equals(member.getUsers().get(i).getLogin())){
                member.getUsers().get(i).setAccountStatus(true);
                break;
            }
        }
    }
    public static void printAllItem(){
        System.out.println("________________________________");
        for(int i=0;i<book.getBooks().size();i++){
            System.out.println(book.getBooks().get(i));
        }
        System.out.println("________________________________");
        for(int i=0;i<magazine.getMagazine().size();i++){
            System.out.println(magazine.getMagazine().get(i));
        }
        System.out.println("________________________________");
        for(int i=0;i<dvd.getDvd().size();i++){
            System.out.println(dvd.getDvd().get(i));
        }
    }
    private static void deleteUser(String login){
        for(int i = 0; i<member.getUsers().size();i++){
            if(login.equals(member.getUsers().get(i).getLogin())){
                member.getUsers().remove(i);
                break;
            }
        }
    }

}
