package ConsoleVer.Users;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.LibraryItem.implem.BorrowableItem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Member extends Users{
    private String[][]isCheckMem = {{"user","user"},{"Berek","1234q"},{"Luffy","Aa1234aA"},{"Memb","Memb93"}};
    //private String login;
    //private String password;
    private ArrayList<Member> users = new ArrayList<>();
    private ArrayList<String>[][] members = new ArrayList[4][4];
    //private LinkedList<BorrowableItem>
    private BorrowableItem[] borrowableItem;
    private String authorization = "N";
    private boolean isActive = true;

    public Member(){
    } //To work with requests
    public Member(String login,String password, boolean isActive){
        //To authorization and create new Account
        this.isActive = isActive;
    }

    public void bindUsertToActive(String login){

    }
    public void checkAccountStatus(){
        if(isActive!=false){
            System.out.println("You account is active");
        }else System.out.println("You account is deactive");
    }
    public String [][] getMember(){
        return isCheckMem;
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
        for(int i=0;i<getMember().length;i++){ //Ввод чувствителен к регистру, т.к. это пользователь
            if(login.equals(getMember()[i][0])){
                if(password.equals(getMember()[i][1])){
                    this.authorization="Member";
                    return authorization;
                }else authorization="N";
            }else if(i == getMember().length-1){
                System.out.println("This users it's not found");
                this.authorization = "N";
                return authorization;
            }
        }
        return authorization = "N";
    }
    public void Users(){

    }
    public boolean activate(){
        if(isActive == false){
            isActive = true;
        }else return true;
        return true;
    }
    public boolean deactivate(){
        isActive = false;
        return isActive;
    }
    public boolean test(){
        if(isActive == true){
            return true;
        }else return false;
    }
}
