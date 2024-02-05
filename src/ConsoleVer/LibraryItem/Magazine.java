package ConsoleVer.LibraryItem;

import ConsoleVer.LibraryItem.implem.PaperItem;

public class Magazine extends LibraryItem implements PaperItem {
    private long issueNumber;
    private String issuer;

    public Magazine(){}
    public Magazine(long issueNumber, String issuer){
        this.issueNumber = issueNumber;
        this.issuer = issuer;
    }
}
