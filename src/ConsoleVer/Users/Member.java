package ConsoleVer.Users;

import ConsoleVer.Library.Book;
import ConsoleVer.Library.Dvd;
import ConsoleVer.Library.Magazine;
import ConsoleVer.MyException.UndefinedItemException;

import java.util.LinkedList;

public class Member extends Users{
    private String[][]isCheckMem = {{"user","user"},{"Berek","1234q"},{"Luffy","Aa1234aA"},{"Memb","Memb93"}};
    private String login;
    private String password;
    private LinkedList<Member> users = new LinkedList<>();
    private LinkedList<Book>borrowableBook = new LinkedList<>();
    private LinkedList<Magazine>borrowableMagazine = new LinkedList<>();
    private LinkedList<Dvd>borrowableDvd = new LinkedList<>();
    //private HashMap<Integer,Book>borrowableBoosk = new HashMap<>();
    private String authorization = "N";
    private boolean isOnline = false;
    private boolean isActive = true;

    public Member(){
        Users();
    } //To work with requests
    public Member(String login,String password, boolean isActive){
        this.login = login;
        this.password = password;
        this.isActive = isActive;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LinkedList<Member> getUsers(){
        return users;
    }

    public LinkedList<Book>getBorrowableBook(){return borrowableBook;}
    public LinkedList<Dvd>getBorrowableDvd(){return borrowableDvd;}
    public LinkedList<Magazine>getBorrowableMagazine(){return borrowableMagazine;}

    public void setUsers(LinkedList<Member> users){
        this.users = users;
    }

    public void setAccountStatus(boolean isEnt){
        isOnline = isEnt;
        if(isOnline == false){
            isOnline = false;
        }else isOnline = true;
    }
    public boolean getAccountStatus(){
        return isOnline;}
    public String getAuthorization(String user){
        for (int i=0;i<users.size();i++){
            if(users.get(i).getLogin().equals(user)){
                return authorization = users.get(i).getLogin();
            }
        }
        return authorization = "N";
    }
    public void setAuthorization(String authorization){
        this.authorization = authorization;
    }
    public String enterMember(String login, String password){
        for(int i=0;i<getUsers().size();i++){ //Ввод чувствителен к регистру, т.к. это пользователь
            if(login.equals(getUsers().get(i).getLogin())){
                if(password.equals(getUsers().get(i).getPassword())){
                    this.authorization=login;
                    return authorization;
                }else {
                    authorization="N";
                    System.err.println("Wrong password");
                }
            }else if(i == getUsers().size()-1){
                System.out.println("This users it's not found");
                this.authorization = "N";
                return authorization;
            }
        }
        return authorization = "N";
    }
    private void Users(){
        int val = 5;
        Member[]m = new Member[val];
        m[0] = new Member("user","user",true);
        m[1] = new Member("Berek","12345q",true);
        m[2] = new Member("Luffy","Aa1234aA",true);
        m[3] = new Member("Member","mEMBER",true);
        m[4] = new Member("Ali","0sd3a21l",true);
        for (int i =0;i<m.length;i++){
            users.add(m[i]);
        }
    }

    public boolean activate(){
        return isActive = true;
    }
    public boolean deactivate(){
        return isActive = false;
    }

    public boolean test(){
        if(isActive == true){
            return true;
        }else return false;
    }

    public void setBorrowableItem(Object object,int i) throws UndefinedItemException {
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd) {
            System.out.println("True");
            if(object instanceof Book){
                Book book = new Book();
            }else if(object instanceof Magazine){
                Magazine magazine = new Magazine();
            }else if(object instanceof Dvd){
                Dvd dvd = new Dvd();
            }
        }else {
            throw new UndefinedItemException();
        }
    } // test Method

    public void setBorrowableBook(Book book){
        if(book.isAvailable() == true){
            borrowableBook.add(book);
        }else System.err.println("This don't borrowable book");
    }
    public void setBorrowableMagazine(Magazine magazine){
        if(magazine.isAvailable() == true){
            borrowableMagazine.add(magazine);
        }else System.err.println("This don't borrowable book");

    }
    public void returnAllBorrowableBook(){
        for (int i = borrowableBook.size()-1; i!=-1;i--){
            borrowableBook.remove(i);
        }
    }
    public void returnBorrowableBook(int index){
        for (int i = 0; i<borrowableBook.size();i++){
            if(index == borrowableBook.get(i).getId()){
                System.out.println(borrowableBook.get(i));
                borrowableBook.remove(i);
            }
        }
    }
    public void returnBorrowableMagazine(int index){
        for (int i = 0; i<borrowableMagazine.size();i++){
            if(index == borrowableMagazine.get(i).getId()){
                System.out.println(borrowableMagazine.get(i));
                borrowableMagazine.remove(i);
            }
        }
    }
}
