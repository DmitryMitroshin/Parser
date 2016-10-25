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
        System.out.println("DB Connected");
    }

    public static void createTableCity() throws ClassNotFoundException, SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS 'cities' (" +
                "'cityId' INTEGER PRIMARY KEY," +
                "'cityTitle' TEXT," +
                "'countryTitle' TEXT," +
                "'cityLongitude' REAL," +
                "'cityLatitude' REAL," +
                "'districtTitle' TEXT," +
                "'regionTitle' TEXT," +
                "'direction' TEXT);");
        System.out.println("Table created or already exist");
    }

    public static void writeCityToDB(City city) throws ClassNotFoundException, SQLException {
        statement.execute("INSERT INTO 'cities' ('cityId', 'cityTitle', 'countryTitle', 'cityLongitude', " +
                "'cityLatitude', 'districtTitle', 'regionTitle', 'direction') VALUES " +
                "('" + city.getCityId() + "', " +
                "'" + city.getCityTitle() + "', " +
                "'" + city.getCountryTitle() + "', " +
                "'" + city.getCityLongitude() + "', " +
                "'" + city.getCityLatitude() + "', " +
                "'" + city.getDistrictTitle() + "', " +
                "'" + city.getRegionTitle() + "', " +
                "'" + city.getDirection() + "');");
    }



    public static void updateDirectionToBoth(Long cityId) throws SQLException {
        statement.execute("UPDATE cities SET direction = 'Both' WHERE cityId = " + cityId + ";");
    }

    public static void closeDB() throws ClassNotFoundException, SQLException {
        connection.close();
        statement.close();
        resultSet.close();

        System.out.println("DB Disconnected");
    }
}
