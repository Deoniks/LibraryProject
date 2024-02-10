package ConsoleVer.Users;

import java.util.Scanner;

public class Librarian extends Users{
    private static Scanner scan = new Scanner(System.in);
    private String authorization = "N";
    private String[][]isCheckLib = {{"admin","admin"},{"Derec","1234q"},{"Lebovskiy","Aa1234aA"},{"Lib","Lib21"}};
    private int workExperience;

    public String[][]getLibrarian(){
        return isCheckLib;
    }

    public String getAuthorization(){
        return authorization;
    }
    public String enterLibrarian(String login, String password){
        for (int i = 0; i < getLibrarian().length; i++) {
            if (login.toLowerCase().equals(getLibrarian()[i][0].toLowerCase())) { //Ввод любым регистром, т.к. регистрирует админ...
                if (password.toLowerCase().equals(getLibrarian()[i][1].toLowerCase())) {
                    System.out.println("True, this user check");
                    this.authorization = "Librarian";
                    return authorization;
                }
            } else if(i == getLibrarian().length-1){
                System.out.println("Sorry, it's not user");
                this.authorization = "Not";
            }
        }
        return "";
    }

}
