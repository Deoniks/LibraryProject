package ConsoleVer.Users;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.LibraryItem.implem.BorrowableItem;

public class Member extends Users{
    private String[][]isCheckMem = {{"user","user"},{"Berek","1234q"},{"Luffy","Aa1234aA"},{"Memb","Memb93"}};
    private BorrowableItem[] borrowableItem;
    private String authorization = "N";
    private boolean isActive = true;

    public Member(){} //To work with requests
    public Member(String login){ //To authorization and create new Account

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
    public boolean activate(){
        return true;
    }
    public boolean deactivate(){
        return false;
    }
}
