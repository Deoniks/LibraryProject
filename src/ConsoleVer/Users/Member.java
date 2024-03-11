package ConsoleVer.Users;

import ConsoleVer.Library.Book;
import ConsoleVer.Library.Dvd;
import ConsoleVer.Library.Magazine;
import ConsoleVer.MyException.UndefinedItemException;

import java.util.LinkedList;

public class Member extends Users{
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
    } //добавить каждому пользователю индивидуальный список предметов

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    private String getPassword() {
        return password;
    } // Для проверки пароля с введенным пользователем... Не нужен публичный доступ
    public void setPassword(String password) {
        this.password = password;
    } // Установить новый пароль пользователю(для будущего апдейта:))
    public LinkedList<Member> getUsers(){
        return users;
    }

    public LinkedList<Book>getBorrowableBook(){return borrowableBook;}
    public LinkedList<Dvd>getBorrowableDvd(){return borrowableDvd;}
    public LinkedList<Magazine>getBorrowableMagazine(){return borrowableMagazine;}

    public void setUsers(LinkedList<Member> users){
        this.users = users;
    }

    public void setAccountStatus(boolean isEnt){ //Для проверки входа пользователя
        isOnline = isEnt;
        if(isOnline == false){
            isOnline = false;
        }else isOnline = true;
    }
    public boolean getAccountStatus(){ //Проверка активности пользователя
        return isOnline;}
    public String getAuthorization(){ // проверка авторизации пользователя
        return authorization ;
    }
    public void setAuthorization(String authorization){
        this.authorization = authorization;
    }
    public String enterMember(String login, String password){ //авторизация пользователя
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
    }// Список пользователей

    public boolean activate(){
        return isActive = true;
    } // активация и деактивация профиля пользователя
    public boolean deactivate(){
        return isActive = false;
    }

    public boolean isAct(){
        for(int i =0;i<users.size();i++){
            if(users.get(i).isActive == true){
                return true;
            }else return false;
        }return false;
    }// проверка профиля пользователя

    public void setBorrowableItem(Object object) throws UndefinedItemException {
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd) {
            System.out.println("True");
            if(object instanceof Book){
                if(((Book) object).isAvailable() == true){
                    for (int i=0;i<users.size();i++){
                        if(users.get(i).isOnline==true){
                            borrowableBook.add(((Book) object));
                        }
                    }

                }else System.err.println("This don't borrowable book");
            }else if(object instanceof Magazine){
                if(((Magazine)object).isAvailable() == true){
                    borrowableMagazine.add((Magazine) object);
                }else System.err.println("This don't borrowable book");
            }else if(object instanceof Dvd){
                if(((Dvd)object).isAvailable() == true){
                    borrowableDvd.add(((Dvd)object));
                }else System.err.println("This don't borrowable book");
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
    public void setBorrowableDvd(Dvd dvd){
        if(dvd.isAvailable() == true){
            borrowableDvd.add(dvd);
        }else System.err.println("This don't borrowable dvd");
    }
    public void returnAllBorrowableItem(){
        for (int i = borrowableBook.size()-1; i!=-1;i--){
            borrowableBook.remove(i);
        }
        for (int i = borrowableMagazine.size()-1; i!=-1;i--){
            borrowableMagazine.remove(i);
        }
        for (int i = borrowableDvd.size()-1; i!=-1;i--){
            borrowableDvd.remove(i);
        }
    } // Возврат всех предметов
    public void returnBorrowableBook(int index){
        for (int i = 0; i<borrowableBook.size();i++){
            if(users.get(i).getAccountStatus() == true) {
                if (index == borrowableBook.get(i).getId()) {
                    System.out.println(borrowableBook.get(i));
                    borrowableBook.remove(i);
                }
            }
        }
    } //индивидуальный возврат
    public void returnBorrowableMagazine(int index){
        for (int i = 0; i<borrowableMagazine.size();i++){
            if(index == borrowableMagazine.get(i).getId()){
                System.out.println(borrowableMagazine.get(i));
                borrowableMagazine.remove(i);
            }
        }
    }
    public void returnBorrowableDvd(int index){
        for (int i = 0; i<borrowableDvd.size();i++){
            if(index == borrowableDvd.get(i).getId()){
                System.out.println(borrowableDvd.get(i));
                borrowableDvd.remove(i);
            }
        }
    }
}
