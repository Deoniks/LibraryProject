package ConsoleVer.Users;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.LibraryItem.implem.BorrowableItem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Member extends Users{
    private String[][]isCheckMem = {{"user","user"},{"Berek","1234q"},{"Luffy","Aa1234aA"},{"Memb","Memb93"}};
    private String login;
    private String password;
    private LinkedList<Member> users = new LinkedList<>();
    private BorrowableItem[] borrowableItem;
    private String authorization = "N";
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
    public void setUsers(LinkedList<Member> users){
        this.users = users;
    }

    public void checkAccountStatus(){
        if(isActive!=false){
            System.out.println("You account is active");
        }else System.out.println("You account is deactive");
    }

    public void setBorrowableItem(Book b){
        borrowableItem = new BorrowableItem[10];
    }
    public String getAuthorization(){
        return authorization;
    }
    public void setAuthorization(String authorization){
        this.authorization = authorization;
    }
    public String enterMember(String login, String password){
        for(int i=0;i<getUsers().size();i++){ //Ввод чувствителен к регистру, т.к. это пользователь
            if(login.equals(getUsers().get(i).getLogin())){
                if(password.equals(getUsers().get(i).getPassword())){
                    this.authorization="Member";
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
}
