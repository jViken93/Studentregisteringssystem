package sample.Database;

import java.io.File;

/*Klasse for å hente ut den relvante informasjonen du trenger for å lage en database*/
public class Database {
    private static File db = new File("oblig_database.db"); //Oppretter filen
    private static String sql = "CreateDatabase.sql"; //Lager databasen
    private static String url = "jdbc:sqlite:" + db.getPath();

    public static Boolean dbExists(){
        return db.exists();
    }

    public static String getSql(){
        return sql;
    }

    public static String getUrl(){
        return url;
    }
}
