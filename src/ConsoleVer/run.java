package ConsoleVer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class run {
    static Scanner scan = new Scanner(System.in);
    private static int wUser = 0;


    public static void main(String[] args) {
        loginMenu();
    }

    public static void loginMenu(){
        System.out.println("Who you(Pls input 1 or 2):\n1.Librarian \n2.Member");
        while (!scan.hasNextInt()){
            System.err.println("Pleas input 1 or 2 ");
            scan.nextLine();
        }
        wUser = scan.nextInt();
        switch (wUser){
            case 1 -> System.out.println("Librarian");
            case 2 -> System.out.println("Member");
            default ->{
                System.err.println("Not found users");
                loginMenu();
            }
        }
    }
}
