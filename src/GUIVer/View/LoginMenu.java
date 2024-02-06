package GUIVer.View;

import GUIVer.UsersG.LibrarianG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginMenu extends JDialog {
    private JPanel contentPane;
    private JButton buttonEnter;
    private JButton buttonExit;
    private JTextField textFieldLogin;
    private JPasswordField passwordField1;
    private JLabel labelLogin;
    private JLabel labelPasswrd;
    private JPanel panelLogin;
    private JPanel panelPasswrd;

    public LoginMenu() {
        setContentPane(contentPane);
        setTitle("Login to acc");
        setLocation(500,500);
        setModal(true);
        getRootPane().setDefaultButton(buttonEnter);

        buttonEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEnter();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onEnter() {
        // add your code here
        LibrarianG libG = new LibrarianG();
        String[][] lg = libG.librarian();
        for(int i =0;i<lg.length;i++){
            if(lg[i][0].toLowerCase().equals(textFieldLogin.getText().toLowerCase())){
                System.out.println("true");
                if(lg[i][1].toLowerCase().equals(passwordField1.getText().toLowerCase())){
                    System.out.println("true");
                }else System.out.println("false");
                break;
            }else {
                System.out.println("false");
                break;
            }
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        LoginMenu dialog = new LoginMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
