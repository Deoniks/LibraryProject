package ConsoleVer.LibraryItem;

import ConsoleVer.LibraryItem.implem.PaperItem;
import ConsoleVer.Users.Librarian;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Book extends LibraryItem implements PaperItem {
    private Scanner scan = new Scanner(System.in);
    private String author;
    private String title;
    private String isbn; //международный стандартный книжный номер

    private static LinkedList<Book> books = new LinkedList<>(); // Collection for save book's
    private static String[] fantasyB;

    public Book(){
        Lib();
    } //Constructor for print book
    //This constructor for add new book
    public Book(String author, String title, String isbn, int id, String name, boolean isAvailable){
        super(id, name, isAvailable);
        this.author = author;
        this.title = title;
        this.isbn = isbn;

    }


    public LinkedList<Book> getBooks(){
        return books;
    }

    public void addBook(){ // add one book
        System.out.println("Enter Author");
        String inAuthor = scan.nextLine();
        System.out.println("Enter title");
        String inTitle = scan.nextLine();
        System.out.println("Enter isbn");
        String inIsbn = scan.nextLine();
        System.out.println("Enter id");
        while (!scan.hasNextInt()){
            System.out.println("Please input integer number");
            scan.nextLine();
        }
        int inId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter type");
        String inType = scan.nextLine();
        Book b = new Book(inAuthor,inTitle,inIsbn,inId,inType,true);
        books.add(b);
    }

    public void addBook(int val){ // add n-book
        for(int i =0;i<=val;i++){
            System.out.println("Enter Author");
            String inAuthor = scan.nextLine();
            System.out.println("Enter title");
            String inTitle = scan.nextLine();
            System.out.println("Enter isbn");
            String inIsbn = scan.nextLine();
            System.out.println("Enter id");
            while (!scan.hasNextInt()){
                System.out.println("Please input integer number");
                scan.nextLine();
            }
            int inId = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter type");
            String inType = scan.nextLine();
            Book b = new Book(inAuthor,inTitle,inIsbn,inId,inType,true);
            books.add(b);
        }
    }
    public void printBook(){ // Print All Book
        try {
            for(int i = 0; i<books.size(); i++){
                System.out.println(books.get(i));
            }
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }
    }

    public void printBook(String user){ // Print All Book
        if(user.equals("Member")){
            try {
                for(int i = 0; i<books.size(); i++){
                    if(books.get(i).isAvailable()==true){
                        System.out.println(books.get(i));
                    }
             }
        }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not book's");
            }
        } else if (user.equals("Librarian")) {
            try {
                for(int i = 0; i<books.size(); i++){
                    System.out.println(books.get(i));
                }
            }catch (IndexOutOfBoundsException IOOBExce){
                System.err.println("Not book's");
            }
        }
    }
    public void printBook(int val){ // Print n- Book
        try {
            System.out.println(books.get(val));
        }catch (IndexOutOfBoundsException IOOBExce){
            System.err.println("Not book's");
        }
    }

    public void borrowableBook(int id){
        for(int i = 0; i<books.size();i++){
            if(id == books.get(i).getId()){
               books.get(i).setAvailable(false);
            }
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void printFindBookToTitle(String user, String title) {// find to one word or all string
        if(user.equals("Librarian")){
            if(title == null || title.equals(" ")){
                System.err.println("Not title");
            }else {
                for (int i = 0; i < books.size(); i++) {
                    String equ = books.get(i).getTitle().toLowerCase();
                    if (title.toLowerCase().equals(equ)) {
                        System.out.println(books.get(i).getTitle());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word)) {
                                System.out.println(books.get(i).getTitle());
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
                for (int i = 0; i < books.size(); i++) {
                    String equ = books.get(i).getTitle().toLowerCase();
                    if (title.toLowerCase().equals(equ) && books.get(i).isAvailable()==true) {
                        System.out.println(books.get(i).getTitle());
                    }else if(!title.toLowerCase().equals(equ)) {
                        String[] arrEqu = equ.split(" ");
                        for (String word:arrEqu){
                            if (title.toLowerCase().equals(word) && books.get(i).isAvailable()==true) {
                                System.out.println(books.get(i).getTitle());
                            }
                        }
                    }else {
                        System.err.println("Not found title");
                    }
                }
            }
        }
    }
    public void printFindBookToAuthor(String author){
        if(author == null || author.equals(" ")){
            System.err.println("Not input author");
        }else {
            for (int i = 0; i < books.size(); i++) {
                String equ = books.get(i).getAuthor().toLowerCase();
                if (author.toLowerCase().equals(equ)) {
                    System.out.println(books.get(i));
                }else if(!author.toLowerCase().equals(equ)) {
                    String[] arrEqu = equ.split(" ");
                    for (String word:arrEqu){
                        if (author.toLowerCase().equals(word)) {
                            System.out.println(books.get(i));
                        }
                    }
                }else {
                    System.err.println("Not found author");
                }
            }
        }
    }

    private static void Lib(){
        int valBook = 51;
        Book[] b = new Book[51];
        b[0] = new Book("Роулинг Джоан","Гарри Поттер и философский камень","74370695653",101,"", true);
        b[1] = new Book("Роулинг Джоан","Гарри Поттер и Тайная комната","87342393654",102,"f", true);
        b[2] = new Book("Роулинг Джоан","Гарри Поттер и Узник Аскабана","23445473660",103,"f", true);
        b[3] = new Book("Роулинг Джоан","Гарри Поттер и Кубок огня","26340463663",104,"f", true);
        b[4] = new Book("Роулинг Джоан","Гарри Поттер и Орден Феникса","23345463253",105,"", true);
        b[5] = new Book("Роулинг Джоан","Гарри Поттер и Принц Полукровка","22335413253",106,"", true);
        b[6] = new Book("Роулинг Джоан","Гарри Поттер и Дары смерти","33240193254",107,"", true);
        b[7] = new Book("Джон Роулинг","Властелин колец и Братство кольца","13340493650",108,"", true);
        b[8] = new Book("Джон Роулинг","Властелин колец и Две крепости","135304867304",109,"", true);
        b[9] = new Book("Джон Роулинг","Властелин колец и Возвращение короля","462066533001",110,"", true);
        b[10] = new Book("Джон Роулинг","Хоббит или туда и обратно","716024436032",111,"", true);
        b[11] = new Book("Александр Островский","Как закалялась сталь","224064736909",112,"", true);
        b[12] = new Book("Алескандр Дюма","Три мушкетера","726774836777",113,"", true);
        b[13] = new Book("Алескандр Дюма","Двадцать лет спустя","136103835089",114,"", true);
        b[14] = new Book("Алескандр Дюма","Виконт Де Бражелон","236406846101",115,"", true);
        b[15] = new Book("Алескандр Дюма","Граф Монтекристо","536044646135",116,"", true);
        b[16] = new Book("Михаил Шолохов","Тихий дон","216234835620",117,"", true);
        b[17] = new Book("Лев Толстой","Война и Мир","726004836000",118,"", true);
        b[18] = new Book("Лев Толстой","Анна Кареннина","301023879023",119,"", true);
        b[19] = new Book("Алексей Толстой","Петр1","712063032633",120,"", true);
        b[20] = new Book("Алексей Толстой","Буратино","24534035633031",121,"", true);
        b[21] = new Book("Дмитрий Емец","Мефодий Буслаев Маг Полуночи","476203842536",122,"", true);
        b[22] = new Book("Дмитрий Емец","Мефодий Буслаев Свиток Желаний","162043658030",123,"", true);
        b[23] = new Book("Дмитрий Емец","Мефодий Буслаев Третий Всадник Мрака","866003832039",124,"", true);
        b[24] = new Book("Дмитрий Емец","Таня Гроттер и Магический Контрабас","809413424273",125,"", true);
        b[25] = new Book("Дмитрий Емец","Гарри Поттер и философский камень","917443823079",126,"", true);
        b[26] = new Book("Дмитрий Емец","Таня Гроттер и Исчезающий Этаж","2360064363774",127,"", true);
        b[27] = new Book("Говард Лавкрафт","Некрономикон","1422795020079",128,"", true);
        b[28] = new Book("Говард Лавкрафт","Зов Ктулху","7169475326579",129,"", true);
        b[29] = new Book("Говард Лавкрафт","Дагон","2002405020570",130,"", true);
        b[30] = new Book("Герберт Уэллс","Человек неведимка","1246467853532",131,"", true);
        b[31] = new Book("Герберт Уэллс","Рассказы","7762455223377",132,"", true);
        b[32] = new Book("Герберт Уэллс","Война Миров","2795664123475",133,"", true);
        b[33] = new Book("Герберт Уэллс","Машина Времени","7822345313273",134,"", true);
        b[34] = new Book("Александр Беляев","Голова Профессора Доуэля","2462465323579",135,"", true);
        b[35] = new Book("Александр Беляев","Человек-амфибия","6359861891952",136,"", true);
        b[36] = new Book("Александр Беляев","Остров погибших кораблей","1232845251253",137,"", true);
        b[37] = new Book("Артур Конан Дойл","Записки о Шерлоке Холмсе","5369451641152",138,"", true);
        b[38] = new Book("Артур Конан Дойл","Затерянный Мир","6729556858251",139,"", true);
        b[39] = new Book("Сергей Ожегов","Словарь Ожегова","7384851871252",140,"", true);
        b[40] = new Book("Мировая","Красная Книга","7683251851543",141,"", true);
        b[41] = new Book("Владимир Даль","Словарь Даля","176557651252",142,"", true);
        b[42] = new Book("Гелберт Шилдт","Java для начинающих","9389802869052",143,"", true);
        b[43] = new Book("Бёрд","Java для чайников","9532851351252",144,"", true);
        b[44] = new Book("Габриель Крамер","Математика Крамера","4785451851432",145,"", true);
        b[45] = new Book("Белага","Физика","1545651852352",146,"", true);
        b[46] = new Book("Харвест","Медецинская Энциклопедия Харвест","9789851851252",147,"", true);
        b[47] = new Book("Коллективная","Большая Советская Энциклопедия","3287851436252",148,"", true);
        b[48] = new Book("Михаил Булгаков","Мастер и Маргарита","2285856456252",149,"", true);
        b[49] = new Book("Михаил Булгаков","Собачье сердце","2382851435253",150,"", true);
        b[50] = new Book("Михаил Булгаков","Иван Васильевичь","2287245426242",151,"", true);
        for(int i =0;i<valBook;i++){
            books.add(b[i]);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                "id= " + getId() +
                '}';
    }
}
