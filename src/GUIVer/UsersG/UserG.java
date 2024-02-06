package GUIVer.UsersG;

public abstract class UserG {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public UserG(){}
    public UserG(int id, String login,String password, String firstName, String lastName, String role){
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public void activte(){}
    public void deactivate(){}
}
