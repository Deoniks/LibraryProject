package ConsoleVer.Users;

import ConsoleVer.LibraryItem.Book;
import ConsoleVer.LibraryItem.implem.BorrowableItem;

public class Member extends Users{
    private String[][]isCheckMem = {{"user","user"},{"Berek","1234q"},{"Luffy","Aa1234aA"},{"Memb","Memb93"}};
    private BorrowableItem[] borrowableItem;
    private boolean isActive;

    public void checkAccountStatus(){

    }

    public String [][] getMember(){
        return isCheckMem;
    }
    public void setBorrowableItem(Book b){
        borrowableItem = new BorrowableItem[10];
    }
}
