package ConsoleVer.Library;

import ConsoleVer.Library.implem.PaperItem;

import java.util.LinkedList;
import java.util.Scanner;

public class Magazine extends LibraryItem implements PaperItem {
    private static Scanner scan = new Scanner(System.in);
    private long issueNumber;
    private String issuer;
    private static LinkedList<Magazine> magazine = new LinkedList<>(); // Collection for save book's

    public Magazine(){}
    public Magazine(int id, String name, boolean isAvailable, long issueNumber, String issuer){
        super(id, name, isAvailable);
        this.issueNumber = issueNumber;
        this.issuer = issuer;
    }

    public LinkedList<Magazine> getMagazine(){
        return magazine;
    }

    public void addMagazine(){ // add one magazine
        System.out.println("Enter name");
        String inName = scan.nextLine();
        System.out.println("Enter issue Number");
        long issueNum = scan.nextLong();
        System.out.println("Enter id");
        while (!scan.hasNextInt()){
            System.out.println("Please input integer number");
            scan.nextLine();
        }
        int inId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter issuer");
        String inIssuer = scan.nextLine();
        Magazine m = new Magazine(inId, inName,true,issueNum,inIssuer);
        magazine.add(m);
    }
    public void addMagazine(int val){ // add n-book
        for(int i =0;i<=val;i++){
            System.out.println("Enter name");
            String inName = scan.nextLine();
            System.out.println("Enter issue Number");
            long issueNum = scan.nextLong();
            System.out.println("Enter id");
            while (!scan.hasNextInt()){
                System.out.println("Please input integer number");
                scan.nextLine();
            }
            int inId = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter issuer");
            String inIssuer = scan.nextLine();
            Magazine m = new Magazine(inId, inName,true,issueNum,inIssuer);
            magazine.add(m);
        }
    }
    public void printMagazine(){ // Print All Book
        try {
            for(int i = 0; i<magazine.size(); i++){
                System.out.println(magazine.get(i));
            }
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not magazine's");
        }
    }
    public void printMagazine(boolean check){ // Print All Book
        if(check == true){
            try {
                for(int i = 0; i<magazine.size(); i++){
                    if(magazine.get(i).isAvailable()==true){
                        System.out.println(magazine.get(i));
                    }
                }
            }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not book's");
            }
        } else if (check == false) {
            try {
                for(int i = 0; i<magazine.size(); i++){
                    System.out.println(magazine.get(i));
                }
            }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not magazine's");
            }
        }
    }
    public void printMagazine(int val){ // Print n- Book
        try {
            System.out.println(magazine.get(val));
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }
    }

    public void borrowableMagazine(int id){
        for(int i = 0; i<magazine.size();i++){
            if(id == magazine.get(i).getId()){
                magazine.get(i).setAvailable(false);
            }
        }
    }

    public long getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public void printFindMagazineToName(String user, String title) {// find to one word or all string
        if(user.equals("Librarian")){
            if(title == null || title.equals(" ")){
                System.err.println("Not title");
            }else {
                for (int i = 0; i < magazine.size(); i++) {
                    String equ = magazine.get(i).getName().toLowerCase();
                    if (title.toLowerCase().equals(equ)) {
                        System.out.println(magazine.get(i).getName());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word)) {
                                System.out.println(magazine.get(i).getName());
                            }
                        }
                    }else {
                        System.err.println("Not found title");
                    }
                }
            }
        }else if(user.equals("Member")){
            if(title == null || title.equals(" ")){
                System.err.println("Not title");
            }else {
                for (int i = 0; i < magazine.size(); i++) {
                    String equ = magazine.get(i).getName().toLowerCase();
                    if (title.toLowerCase().equals(equ) && magazine.get(i).isAvailable()==true) {
                        System.out.println(magazine.get(i).getName());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word) && magazine.get(i).isAvailable()==true) {
                                System.out.println(magazine.get(i).getName());
                            }
                        }
                    }else {
                        System.err.println("Not found title");
                    }
                }
            }
        }
    }
    public void printFindMagazineToIssueNumber(long issueNumber){
        for(int j = 0; j < magazine.size(); j++){
            if(issueNumber != magazine.get(j).issueNumber){
                System.err.println("Not issue number");
            }else {
                for (int i = 0; i < magazine.size(); i++) {
                    long equ = magazine.get(i).getIssueNumber();
                    if (issueNumber == equ) {
                        System.out.println(magazine.get(i));
                    }else {
                        System.err.println("Not found issue number");
                    }
                }
            }
        }
    }

    private static void Lib(){
        int valMagazine = 31;
        Magazine[] m = new Magazine[31];
        m[0] = new Magazine(1,"Discovery Hen Music",true,334,"January-April_24");
        m[1] = new Magazine(2,"Discovery About the cover",true,333,"September-December_23");
        m[2] = new Magazine(3,"Discovery Cyber Security Threats",true,332,"August_23");
        m[3] = new Magazine(4,"Discovery July",true,331,"July_23");
        m[4] = new Magazine(5,"Discovery Factor",true,330,"June_23");
        m[5] = new Magazine(6,"Discovery Effect of cannabis",true,329,"May_23");
        m[6] = new Magazine(7,"Discovery sport?!",true,328,"April_23");
        m[7] = new Magazine(8,"Discovery The effect of nickel",true,327,"March_23");
        m[8] = new Magazine(9,"Discovery Increased brain and serum",true,326,"February_23");
        m[9] = new Magazine(10,"Weekly Shonen Jump  Issue 13, 2024",true,1324,"26_February_24");
        m[10] = new Magazine(11,"Weekly Shonen Jump Issue 12, 2024",true,1224,"19_February_24");
        m[11] = new Magazine(12,"Weekly Shonen Jump Issue 11, 2024",true,1124,"13_February_24");
        m[12] = new Magazine(13,"Weekly Shonen Jump Issue 10, 2024",true,1024,"5_February_24");
        m[13] = new Magazine(14,"Weekly Shonen Jump Issue 9, 2024",true,924,"29_January_24");
        m[14] = new Magazine(15,"Weekly Shonen Jump Issue 8, 2024",true,824,"22_January_24");
        m[15] = new Magazine(16,"Weekly Shonen Jump Issue 6-7, 2024",true,724,"6_January_24");
        m[16] = new Magazine(17,"Weekly Shonen Jump Issue 4-5, 2024",true,624,"25_December_23");
        m[17] = new Magazine(18,"Forbes KZ",true,149,"January_24");
        m[18] = new Magazine(19,"Forbes KZ",true,148,"December_23");
        m[19] = new Magazine(20,"Forbes KZ",true,147,"November_23");
        m[20] = new Magazine(21,"Forbes KZ",true,146,"October_23");
        m[21] = new Magazine(22,"Forbes KZ",true,145,"September_23");
        m[22] = new Magazine(23,"Forbes KZ",true,144,"August_23");
        m[23] = new Magazine(9,"Мир фантастики кузница миров",true,243,"February_24");
        m[24] = new Magazine(9,"Мир фантастики ожидания 2024",true,242,"January_24");
        m[25] = new Magazine(9,"Мир фантастики Rogue trader",true,241,"December_23");
        m[26] = new Magazine(9,"Мир фантастики Берсерк История лара",true,240,"November_23");
        m[27] = new Magazine(9,"WIRED",true,13024,"February_24");
        m[28] = new Magazine(9,"WIRED",true,12024,"January_24");
        m[29] = new Magazine(9,"WIRED",true,11024,"December_23");
        m[30] = new Magazine(9,"WIRED",true,10024,"November_23");
        for(int i =0;i<valMagazine;i++){
            magazine.add(m[i]);
        }
    }

}
