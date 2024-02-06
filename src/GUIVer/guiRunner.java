package GUIVer;

import GUIVer.UsersG.LibrarianG;
import GUIVer.View.LoginMenu;

public class guiRunner {

    public static void main(String[] args) {
        LibrarianG l = new LibrarianG();
        System.out.println(l);
        LoginMenu lg = new LoginMenu();
        lg.pack();
        lg.setVisible(true);
        System.exit(0);
    }
}
