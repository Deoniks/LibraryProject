package ConsoleVer.Library;

import java.util.LinkedList;

public enum JanreE {
    FANTASY,
    SCIENCE,
    COMEDY,
    MYTH,
    DRAMA,
    NOVEL,
    ADVENTURES,
    HORROR,
    WOMEN_MAGAZINE,
    MAN_MAGAZINE,
    SCIENCE_MAGAZINE;

    public static LinkedList<String> getA(){
        LinkedList<String> f = new LinkedList<>();
        f.add("WTF&?!");
        return f;
    }

}
