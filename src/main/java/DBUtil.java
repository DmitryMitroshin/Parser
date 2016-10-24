import java.sql.*;

/**
 * Created by Dmitry on 24.10.2016.
 */
public class DBUtil {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void connectToDB(String pathToDB) throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(pathToDB);
        System.out.println("DB Connected!!!!!!!!!!!!!!!");
    }

    public static void createTableCity() throws ClassNotFoundException, SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS 'cities' (" +
                "'cityId' INTEGER PRIMARY KEY NOT NULL UNIQUE," +
                "'cityTitle' TEXT NOT NULL," +
                "'countryTitle' TEXT NOT NULL," +
                "'cityLongitude' REAL NOT NULL," +
                "'cityLatitude' REAL NOT NULL," +
                "'districtTitle' TEXT NOT NULL," +
                "'regionTitle' TEXT NOT NULL," +
                "'direction' TEXT NOT NULL);");
        System.out.println("Table created or already exist");
    }

    public static void writeDB() throws ClassNotFoundException, SQLException {

    }

    public static void closeDB() throws ClassNotFoundException, SQLException {

    }
}
