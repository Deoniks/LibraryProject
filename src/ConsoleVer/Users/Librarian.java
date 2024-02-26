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
    public void setAuthorization(String authorization){
        this.authorization = authorization;
    }
    public String enterLibrarian(String login, String password){
        for (int i = 0; i < getLibrarian().length; i++) {
            if (login.toLowerCase().equals(getLibrarian()[i][0].toLowerCase())) { //Ввод любым регистром, т.к. регистрирует админ...
                if (password.toLowerCase().equals(getLibrarian()[i][1].toLowerCase())) {
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
    public void activateUser(Member user,String login){
        for (int i =0; i<user.getUsers().size();i++){
            if(login.equals(user.getUsers().get(i).getLogin())){
                user.getUsers().get(i).activate();
                break;
            }
        }
    }
    public void deactivateUser(Member user, String login){
        for(int i =0; i<user.getUsers().size();i++){
            if(user.getUsers().get(i).getLogin().equals(login)){
                user.getUsers().get(i).deactivate();
                break;
            }
        }
    }

}
