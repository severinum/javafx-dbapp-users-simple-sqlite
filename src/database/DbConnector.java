package database;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class DbConnector {

    private static Connection con;
    private static boolean hasData = false;



    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Path resourceDirectory = Paths.get("src","database");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String dbFilePath = absolutePath + "/posdatabase.db";
        Class.forName("org.sqlite.JDBC");
        return con = DriverManager.getConnection("jdbc:sqlite:"+dbFilePath);
    }


}
