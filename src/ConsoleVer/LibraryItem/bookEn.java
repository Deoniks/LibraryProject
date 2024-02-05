package ConsoleVer.LibraryItem;

import java.util.LinkedList;

public enum bookEn {
    Fantasy,
    Harry_Potter_And_The_Philosophers_Stone,
    Harry_Potter_And_The_Chamber_Of_Secrets,
    Harry_Potter_And_The_Prisoner_Of_Azkaban,
    Harry_Potter_And_The_Goblet_Of_Fire,
    Harry_Potter_And_The_Order_Of_The_Phoenix,
    Harry_Potter_And_The_Half_Blood_Prince,
    Harry_Potter_And_The_Deathly_Hallows,
    Science,
    Mathematics,
    Chemistry,
    Java,
    CPlusPlus,
    CShapr,
    Comedy,
    The_Hitchhikers_Guide_To_The_Galaxy,
    The_Twelve_Chairs,
    Myth,
    Celtic_Myths_From_Parents_Arthur_And_Deirdre_To_Fairies_And_Druids,
    Twelwe_Labors_Of_Hercules,
    Drama,
    Romeo_And_Julieta,
    Hamlet,
    Othello,
    Novel,
    War_And_Peace,
    Master_And_Margarita,
    Adventures,
    The_Lord_Of_The_Rings_The_Fellowship_Of_The_Ring,
    The_Lord_Of_The_Rings_The_Two_Towers,
    The_Lord_Of_The_Rings_The_Return_Of_The_King,
    The_Hobbit_Or_There_And_Back_Again,
    Horor,
    Necronomicon,
    Dagon,
    The_Alchemist,
    The_Call_Of_Cthulhu,
    The_Dark_Tower_I,
    The_Dark_Tower_II,
    The_Dark_Tower_III,
    The_Dark_Tower_IV,
    The_Dark_Tower_V,
    The_Dark_Tower_VI,
    The_Dark_Tower_VII,
    WomenMagazine,
    ManMagazine,
    ScienceMagazine;

    public static bookEn[] getFantasyBook(){
        return new bookEn[]{Harry_Potter_And_The_Philosophers_Stone,Harry_Potter_And_The_Chamber_Of_Secrets,Harry_Potter_And_The_Prisoner_Of_Azkaban,
        Harry_Potter_And_The_Goblet_Of_Fire,Harry_Potter_And_The_Order_Of_The_Phoenix,
                Harry_Potter_And_The_Half_Blood_Prince,Harry_Potter_And_The_Deathly_Hallows};
    }

    public static bookEn[] getScienceBook(){
        return new bookEn[]{Mathematics,Chemistry,Java,CPlusPlus,CShapr};
    }

    public static bookEn[] getComedyBook(){
        return new bookEn[]{The_Hitchhikers_Guide_To_The_Galaxy,The_Twelve_Chairs};
    }
    public static bookEn[] getDramaBook(){
        return new bookEn[]{Romeo_And_Julieta,Hamlet,Othello,};
    }
    public static bookEn[] getNovelBook(){
        return new bookEn[]{War_And_Peace,Master_And_Margarita};
    }
    public static bookEn[] getAdventuresBook(){
        return new bookEn[]{The_Lord_Of_The_Rings_The_Fellowship_Of_The_Ring,The_Lord_Of_The_Rings_The_Two_Towers,
                The_Lord_Of_The_Rings_The_Return_Of_The_King,The_Hobbit_Or_There_And_Back_Again};
    }
    public static bookEn[] getHorrorBook(){
        return new bookEn[]{Necronomicon,Dagon,The_Alchemist,The_Call_Of_Cthulhu,The_Dark_Tower_I,The_Dark_Tower_II,The_Dark_Tower_III,
        The_Dark_Tower_IV,The_Dark_Tower_V,The_Dark_Tower_VI,The_Dark_Tower_VII};
    }
    public static LinkedList<String> getA(){
        LinkedList<String> f = new LinkedList<>();
        f.add("Horny");
        return f;
    }

}
