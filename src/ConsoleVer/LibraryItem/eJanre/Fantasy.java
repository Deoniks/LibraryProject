package ConsoleVer.LibraryItem.eJanre;

public enum Fantasy {
    Potter1("Harry Potter And Philoshof"),
    Potter2("Harry Potter And the chambers");

    private String title;
    Fantasy(String title){
        this.title = title;
    }

    public static String[] getFantasy(){
        return new String[]{Potter1.name(), Potter2.name()};
    }
}
