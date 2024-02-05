package ConsoleVer.Users;

public abstract class Users {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public Users(){}
    public Users(int id, String login, String password, String firstName, String lastName, String role){
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public void activate(){

    }
    public void deactivate(){

    }
}
