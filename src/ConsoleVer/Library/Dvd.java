package ConsoleVer.Library;

import ConsoleVer.Library.implem.BorrowableItem;

import java.util.LinkedList;
import java.util.Scanner;

public class Dvd extends LibraryItem implements BorrowableItem {
    private static Scanner scan = new Scanner(System.in);
    private int runTime;

    private static LinkedList<Dvd> dvd = new LinkedList<>(); // Collection for save DVD

    public Dvd(){
        Lib();
    }
    public Dvd(int id, String name, boolean isAvailable, int runTime){
        super(id, name, isAvailable);
        this.runTime = runTime;
    }

    public LinkedList<Dvd> getDvd(){
        return dvd;
    }

    public void addDvd(){ // add one dvd
        System.out.println("Enter name");
        String inName = scan.nextLine();
        System.out.println("Enter id");
        while (!scan.hasNextInt()){
            System.out.println("Please input integer number");
            scan.nextLine();
        }
        int inId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter run time");
        while (!scan.hasNextInt()){
            System.out.println("Please input integer number");
            scan.nextLine();
        }
        int runTime = scan.nextInt();
        scan.nextLine();
        Dvd d = new Dvd(inId, inName,true,runTime);
        dvd.add(d);
    }
    public void deleteDvd(int ind){ // remove one dvd
        dvd.remove(ind);
    }
    public void addDvd(int val){ // add n-dvd
        for(int i =0;i<=val;i++){
            System.out.println("Enter name");
            String inName = scan.nextLine();
            System.out.println("Enter id");
            while (!scan.hasNextInt()){
                System.out.println("Please input integer number");
                scan.nextLine();
            }
            int inId = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter run time");
            while (!scan.hasNextInt()){
                System.out.println("Please input integer number");
                scan.nextLine();
            }
            int runTime = scan.nextInt();
            scan.nextLine();
            Dvd d = new Dvd(inId, inName,true,runTime);
            dvd.add(d);
        }
    }
    public void printDvd(){ // Print All dvd
        try {
            for(int i = 0; i<dvd.size(); i++){
                System.out.println(dvd.get(i));
            }
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not dvd");
        }
    }
    public void printDvd(boolean check){ // Print All dvd
        if(check == true){
            try {
                for(int i = 0; i<dvd.size(); i++){
                    if(dvd.get(i).isAvailable()==true){
                        System.out.println(dvd.get(i));
                    }
                }
            }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not dvd");
            }
        } else if (check == false) {
            try {
                for(int i = 0; i<dvd.size(); i++){
                    System.out.println(dvd.get(i));
                }
            }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not dvd");
            }
        }
    }
    public void printDvd(int val){ // Print n- dvd
        try {
            System.out.println(dvd.get(val));
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not dvd");
        }
    }

    public void borrowableDvd(int id){
        for(int i = 0; i<dvd.size();i++){
            if(id == dvd.get(i).getId()){
                dvd.get(i).setAvailable(false);
            }
        }
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }


    public void printFindDvdToName(String user, String title) {// find to one word or all string
        if(user.equals("Librarian")){
            if(title == null || title.equals(" ")){
                System.err.println("Not name");
            }else {
                for (int i = 0; i < dvd.size(); i++) {
                    String equ = dvd.get(i).getName().toLowerCase();
                    if (title.toLowerCase().equals(equ)) {
                        System.out.println(dvd.get(i).getName());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word)) {
                                System.out.println(dvd.get(i).getName());
                            }
                        }
                    }else {
                        System.err.println("Not found name");
                    }
                }
            }
        }else if(user.equals("Member")){
            if(title == null || title.equals(" ")){
                System.err.println("Not name");
            }else {
                for (int i = 0; i < dvd.size(); i++) {
                    String equ = dvd.get(i).getName().toLowerCase();
                    if (title.toLowerCase().equals(equ) && dvd.get(i).isAvailable()==true) {
                        System.out.println(dvd.get(i).getName());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word) && dvd.get(i).isAvailable()==true) {
                                System.out.println(dvd.get(i).getName());
                            }
                        }
                    }else {
                        System.err.println("Not found name");
                    }
                }
            }
        }
    }
    public void printFindDvdToIssueNumber(int runTime){
        for(int j = 0; j < dvd.size(); j++){
            if(runTime != dvd.get(j).runTime){
                System.err.println("Not run time");
            }else {
                for (int i = 0; i < dvd.size(); i++) {
                    int equ = dvd.get(i).getRunTime();
                    if (runTime == equ) {
                        System.out.println(dvd.get(i));
                    }else {
                        System.err.println("Not found run time");
                    }
                }
            }
        }
    }

    private static void Lib(){
        int valDvd = 11;
        Dvd[] d = new Dvd[11];
        d[0] = new Dvd(1,"Game of thrones 1 season",true,500);
        d[1] = new Dvd(2,"SAW",true,102);
        d[2] = new Dvd(3,"It",true,135);
        d[3] = new Dvd(4,"Forrest Gump",true,142);
        d[4] = new Dvd(5,"The Green Mile",true,189);
        d[5] = new Dvd(6,"Knockin’ On Heaven’s Door",true,87);
        d[6] = new Dvd(7,"Django Unchained",true,165);
        d[7] = new Dvd(8,"Pulp Fiction",true,154);
        d[8] = new Dvd(9,"Leon",true,133);
        d[9] = new Dvd(10,"Star Wars: A New Hope",true,121);
        d[10] = new Dvd(11,"Star Wars: The Empire Strikes Back",true,124);
        for(int i =0;i<valDvd;i++){
            dvd.add(d[i]);
        }
    }

    @Override
    public String toString(){
        return getId()+ " "
                +getName() + " "+ getRunTime();
    }

}
