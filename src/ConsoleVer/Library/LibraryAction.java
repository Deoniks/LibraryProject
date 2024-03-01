package ConsoleVer.Library;

import ConsoleVer.MyException.UndefinedItemException;
import ConsoleVer.Users.Member;

import java.util.LinkedList;
import java.util.Scanner;

public class LibraryAction {
    private Scanner scan = new Scanner(System.in);

    public void addItem(Object object) throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd) {
            if(object instanceof Book){
                int inId = 0;
                System.out.println("Enter Author");
                String inAuthor = scan.nextLine();
                System.out.println("Enter title");
                String inTitle = scan.nextLine();
                System.out.println("Enter isbn");
                String inIsbn = scan.nextLine();
                do {
                    System.out.println("Enter id");
                    while (!scan.hasNextInt()){
                        System.out.println("Please input integer number or");
                        scan.nextLine();
                    }
                    inId = scan.nextInt();
                }while (checkIdItem(object, inId) == true);
                scan.nextLine();
                System.out.println("Enter type");
                String inType = scan.nextLine();
                Book b = new Book(inAuthor,inTitle,inIsbn,inId,inType,true);
                ((Book) object).getBooks().add(b);
            }
        }else throw new UndefinedItemException();
    }
    public void addItem(Object object, int val) throws UndefinedItemException{ // add n- value item...
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd) {
            if(object instanceof Book){
                for(int i =0;i<=val;i++) {
                    int inId = 0;
                    System.out.println("Enter Author");
                    String inAuthor = scan.nextLine();
                    System.out.println("Enter title");
                    String inTitle = scan.nextLine();
                    System.out.println("Enter isbn");
                    String inIsbn = scan.nextLine();
                    do {
                        System.out.println("Enter id");
                        while (!scan.hasNextInt()) {
                            System.out.println("Please input integer number or");
                            scan.nextLine();
                        }
                        inId = scan.nextInt();
                    } while (checkIdItem(object, inId) == true);
                    scan.nextLine();
                    System.out.println("Enter type");
                    String inType = scan.nextLine();
                    Book b = new Book(inAuthor, inTitle, inIsbn, inId, inType, true);
                    ((Book) object).getBooks().add(b);
                }
            }
        }else throw new UndefinedItemException();
    }
    public void printItemUser(Object object) throws UndefinedItemException{ // Print All Book
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd){
            if(object instanceof Book){
                try {
                    for(int i = 0; i<((Book) object).getBooks().size(); i++){
                        if(((Book) object).getBooks().get(i).isAvailable() == true){
                            System.out.println(((Book) object).getBooks().get(i));
                        }
                    }
                }catch (IndexOutOfBoundsException IOOBExce){
                    System.err.println("Not book's");
                }
            }
            else if (object instanceof Magazine) {
                System.out.println("Magazine");
            }
            else if (object instanceof Dvd) {
                System.out.println("DvD");
            }
        }
        else {
            throw new UndefinedItemException();
        }
    }
    public void borrowableItem(Object object, int id) throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd){
            if(object instanceof Book){
                for(int i = 0; i<((Book) object).getBooks().size();i++){
                    if(id == ((Book) object).getBooks().get(i).getId()){
                        ((Book) object).getBooks().get(i).setAvailable(false);
                        break;
                    }
                }
            }
            else if (object instanceof Magazine) {
                System.out.println("Magazine");
            }
            else if (object instanceof Dvd){
                System.out.println("Dvd");
            }
        }
        else {
            throw new UndefinedItemException();
        }
    }
    public void findItemToName(Object object, String user, String name)throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine || object instanceof Dvd){
            if(object instanceof Book){
                if(user.equals("Librarian")){
                if(name == null || name.equals(" ")){
                    System.err.println("Not title");
                }else {
                    for (int i = 0; i < ((Book) object).getBooks().size(); i++) {
                        String equ = ((Book) object).getBooks().get(i).getTitle().toLowerCase();
                        if (name.toLowerCase().equals(equ)) {
                            System.out.println(((Book) object).getBooks().get(i).getTitle());
                        }else if(!name.toLowerCase().equals(equ)) {
                            String[] arrEqu = equ.split(" ");
                            for (String word:arrEqu){
                                if (name.toLowerCase().equals(word)) {
                                    System.out.println(((Book) object).getBooks().get(i).getTitle());
                                }
                            }
                        }else {
                            System.err.println("Not found title");
                        }
                    }
                }
            }
            else if(user.equals("Member")){
                if(name == null || name.equals(" ")){
                    System.err.println("Not title");
                }else {
                    for (int i = 0; i < ((Book)object).getBooks().size(); i++) {
                        String equ = ((Book)object).getBooks().get(i).getTitle().toLowerCase();
                        if (name.toLowerCase().equals(equ) && ((Book)object).getBooks().get(i).isAvailable()==true) {
                            System.out.println(((Book)object).getBooks().get(i).getTitle());
                        }else if(!name.toLowerCase().equals(equ)) {
                            String[] arrEqu = equ.split(" ");
                            for (String word:arrEqu){
                                if (name.toLowerCase().equals(word) && ((Book)object).getBooks().get(i).isAvailable()==true) {
                                    System.out.println(((Book)object).getBooks().get(i).getTitle());
                                }
                            }
                        }else {
                            System.err.println("Not found title");
                        }
                    }
                }
            }
            }
            else if (object instanceof Magazine) {
                System.out.println("Magazine");
            }
            else if (object instanceof Dvd) {
                System.out.println("DvD");
            }
        }
        else {
            throw new UndefinedItemException();
        }
    }
    public void findItemToAuthor(Object object, String user, String author)throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine || object instanceof Dvd){
            if(object instanceof Book){
                if(user.equals("Librarian")){
                    if(author == null || author.equals(" ")){
                        System.err.println("Not Author");
                    }else {
                        for (int i = 0; i < ((Book) object).getBooks().size(); i++) {
                            String equ = ((Book) object).getBooks().get(i).getAuthor().toLowerCase();
                            if (author.toLowerCase().equals(equ)) {
                                System.out.println(((Book) object).getBooks().get(i).getAuthor());
                            }else if(!author.toLowerCase().equals(equ)) {
                                String[] arrEqu = equ.split(" ");
                                for (String word:arrEqu){
                                    if (author.toLowerCase().equals(word)) {
                                        System.out.println(((Book) object).getBooks().get(i).getAuthor());
                                    }
                                }
                            }else {
                                System.err.println("Not found title");
                            }
                        }
                    }
                }
                else if(user.equals("Member")){
                    if(author == null || author.equals(" ")){
                        System.err.println("Not Author");
                    }else {
                        for (int i = 0; i < ((Book)object).getBooks().size(); i++) {
                            String equ = ((Book)object).getBooks().get(i).getAuthor().toLowerCase();
                            if (author.toLowerCase().equals(equ) && ((Book)object).getBooks().get(i).isAvailable()==true) {
                                System.out.println(((Book)object).getBooks().get(i).getAuthor());
                            }else if(!author.toLowerCase().equals(equ)) {
                                String[] arrEqu = equ.split(" ");
                                for (String word:arrEqu){
                                    if (author.toLowerCase().equals(word) && ((Book)object).getBooks().get(i).isAvailable()==true) {
                                        System.out.println(((Book)object).getBooks().get(i).getAuthor());
                                    }
                                }
                            }else {
                                System.err.println("Not found title");
                            }
                        }
                    }
                }
            }
            else if (object instanceof Magazine) {
                System.out.println("Magazine");
            }
            else if (object instanceof Dvd) {
                System.out.println("DvD");
            }
        }
        else {
            throw new UndefinedItemException();
        }
    }
    public void returnItem(Object object, int id) throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine || object instanceof Dvd){

        }
        else {
            throw new UndefinedItemException();
        }
    }
    private boolean checkIdItem(Object object, int id) throws UndefinedItemException{
        if(object instanceof Book || object instanceof Magazine || object instanceof Dvd){
            if(object instanceof Book){
                for(int i = 0; i< ((Book) object).getBooks().size();i++){
                    if(id == ((Book) object).getBooks().get(i).getId()){
                        return true;
                    }
                }return false;
            }
        }
        else {
            throw new UndefinedItemException();
        }
        return false;
    }
}
