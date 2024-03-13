package ConsoleVer.Users;

import ConsoleVer.Library.Book;
import ConsoleVer.Library.Dvd;
import ConsoleVer.Library.Magazine;
import ConsoleVer.MyException.UndefinedItemException;

import java.util.LinkedList;

public class Member extends Users{
    private String login;
    private String password;
    private String rating;
    private LinkedList<Member> users = new LinkedList<>();
    private LinkedList<Book>borrowableBook = new LinkedList<>();
    private LinkedList<Magazine>borrowableMagazine = new LinkedList<>();
    private LinkedList<Dvd>borrowableDvd = new LinkedList<>();
    private String authorization = "N";
    private boolean isOnline = false;
    private boolean isActive = true;

    public Member(){
        Users();

    } //To work with requests
    public Member(String login,String password, boolean isActive, String rating){
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.rating = rating;
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

    public String getRating() { //Для уточнения рейтинга пользователя
        return rating;
    }
    public void setRating(String rating) { //Для смены рейтинга пользователя
        this.rating = rating;
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

    public void setAccountStatus(boolean isEnt){ //Для проверки входа пользователя
        isOnline = isEnt;
        if(!isOnline){
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
        m[0] = new Member("user","user",true,"gold");
        m[1] = new Member("Berek","12345q",true,"silver");
        m[2] = new Member("Luffy","Aa1234aA",true,"bronze");
        m[3] = new Member("Member","mEMBER",true,"bronze");
        m[4] = new Member("Ali","0sd3a21l",true,"bronze");
        for (Member member : m) {
            users.add(member);
        }
    }// Список пользователей

    public boolean activate(){
        return isActive = true;
    } // активация и деактивация профиля пользователя
    public boolean deactivate(){
        return isActive = false;
    }

    public boolean isAct(Member m){
        for(int i =0;i<m.getUsers().size();i++){
            if(m.getUsers().get(i).isOnline){
                if(m.getUsers().get(i).isActive) {
                    return true;
                }
            }else return false;
        }return false;
    }// проверка профиля пользователя

    public void setBorrowableItem(Member m, Object object) throws UndefinedItemException {
        if(object instanceof Book || object instanceof Magazine|| object instanceof Dvd) {
            if(object instanceof Book){
                if(((Book) object).isAvailable()){
                    for (int i=0;i<m.getUsers().size();i++){
                        if(m.getUsers().get(i).isOnline){
                            m.getUsers().get(i).borrowableBook.add(((Book) object));
                            break;
                        }
                    }

                }else System.err.println("This don't borrowable book");
            }else if(object instanceof Magazine){
                if(((Magazine)object).isAvailable()){
                    borrowableMagazine.add((Magazine) object);
                }else System.err.println("This don't borrowable book");
            }else if(object instanceof Dvd){
                if(((Dvd)object).isAvailable()){
                    borrowableDvd.add(((Dvd)object));
                }else System.err.println("This don't borrowable book");
            }
        }else {
            throw new UndefinedItemException();
        }
    } // test Method

    public void setBorrowableBook(Book book){
        if(book.isAvailable()){
            borrowableBook.add(book);
        }else System.err.println("This don't borrowable book");
    }
    public void setBorrowableMagazine(Magazine magazine){
        if(magazine.isAvailable()){
            borrowableMagazine.add(magazine);
        }else System.err.println("This don't borrowable book");
    }
    public void setBorrowableDvd(Dvd dvd){
        if(dvd.isAvailable()){
            borrowableDvd.add(dvd);
        }else System.err.println("This don't borrowable dvd");
    }
    public void returnAllBorrowableItem(Member m){
        for (int i = 0; i < m.getUsers().size();i++){
            if(m.getUsers().get(i).getAccountStatus()){
                for (int j = borrowableBook.size()-1; j!=-1;j--){
                    borrowableBook.remove(j);
                }
                for (int j = borrowableMagazine.size()-1; j!=-1;j--){
                    borrowableMagazine.remove(j);
                }
                for (int j = borrowableDvd.size()-1; j!=-1;j--){
                    borrowableDvd.remove(j);
                }
            }
        }
    } // Возврат всех предметов
    public void returnBorrowableBook(Member m, int index){
        for (int i = 0; i<m.getUsers().size();i++){
            if(m.getUsers().get(i).getAccountStatus()) {
                if(!m.getUsers().get(i).borrowableBook.isEmpty()) {
                    for (int j = 0; j < m.getUsers().get(i).borrowableBook.size(); j++) {
                        if (m.getUsers().get(i).isOnline) {
                            if (index == m.getUsers().get(i).borrowableBook.get(j).getId()) {
                                System.out.println(m.getUsers().get(i).borrowableBook.get(j));
                                m.getUsers().get(i).borrowableBook.remove(j);
                            }
                        }
                    }
                }else System.out.println("You didn't take the book");
            }
        }
    } //индивидуальный возврат
    public void returnBorrowableMagazine(Member m, int index){
        for (int i = 0; i<m.getUsers().size();i++){
            if(m.getUsers().get(i).getAccountStatus()) {
                if(!m.getUsers().get(i).borrowableMagazine.isEmpty()) {
                    for (int j = 0; j < m.getUsers().get(i).borrowableMagazine.size(); j++) {
                        if (m.getUsers().get(i).isOnline) {
                            if (index == m.getUsers().get(i).borrowableMagazine.get(j).getId()) {
                                System.out.println(m.getUsers().get(i).borrowableMagazine.get(j));
                                m.getUsers().get(i).borrowableMagazine.remove(j);
                            }
                        }
                    }
                }else System.out.println("You didn't take the magazine");
            }
        }
    }
    public void returnBorrowableDvd(Member m, int index){
        for (int i = 0; i<m.getUsers().size();i++){
            if(m.getUsers().get(i).getAccountStatus()) {
                if(!m.getUsers().get(i).borrowableDvd.isEmpty()) {
                    for (int j = 0; j < m.getUsers().get(i).borrowableDvd.size(); j++) {
                        if (m.getUsers().get(i).isOnline) {
                            if (index == m.getUsers().get(i).borrowableDvd.get(j).getId()) {
                                System.out.println(m.getUsers().get(i).borrowableDvd.get(j));
                                m.getUsers().get(i).borrowableDvd.remove(j);
                            }
                        }
                    }
                }else System.out.println("You didn't take the book");
            }
        }
    }
}
