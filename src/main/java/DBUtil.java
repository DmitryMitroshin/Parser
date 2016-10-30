import java.sql.*;

// Класс, предоставляющий методы для работы с базой данных
public class DBUtil {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;


//    Метод организует подключение и инициирует базу данных
    public static void connectToDB(String pathToDB) throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(pathToDB);
        statement = connection.createStatement();
        System.out.println("DB Connected");
    }

    // Метод создает в базе данных таблицу "Город"
    public static void createTableCity() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS 'cities' (" +
                "'_id' INTEGER PRIMARY KEY," +
                "'cityTitle' TEXT," +
                "'countryTitle' TEXT," +
                "'cityLongitude' REAL," +
                "'cityLatitude' REAL," +
                "'districtTitle' TEXT," +
                "'regionTitle' TEXT," +
                "'direction' TEXT);");
        System.out.println("Table created or already exist");
    }

    // Метод создает в базе данных таблицу "Станция"
    public static void createTableStation() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS 'stations' (" +
                "'_id' INTEGER PRIMARY KEY," +
                "'stationTitle' TEXT," +
                "'stationLongitude' REAL," +
                "'stationLatitude' REAL," +
                "'cityId' INTEGER," +
                "FOREIGN KEY('cityId') REFERENCES 'cities'('cityId'));");
    }

    // Метод записывает в таблицу "Города" объекты модели "Город"
    public static void writeCityToDB(City city) throws ClassNotFoundException, SQLException {
        statement.execute("INSERT INTO 'cities' ('_id', 'cityTitle', 'countryTitle', 'cityLongitude', " +
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

    // Метод записывает в таблицу "Станции" объекты модели "Станции"
    public static void writeStationToDB(Station station) throws SQLException {
        statement.execute("INSERT INTO 'stations' ('_id', 'stationTitle', 'stationLongitude', " +
                "'stationLatitude', 'cityId') VALUES " +
//                "'stationLatitude', 'cityId') VALUES " +
        "('" + station.getStationId() + "'," +
        "'" + station.getStationTitle() + "'," +
        "'" + station.getStationLongitude() + "'," +
        "'" + station.getStationLatitude() + "'," +
        "'" + station.getCityId() + "');");
    }

    // Метод обновляет поле "Направление" записи, если она имеет оба направления.
    public static void updateDirectionToBoth(Long cityId) throws SQLException {
        statement.execute("UPDATE cities SET direction = 'Both' WHERE _id = " + cityId + ";");
    }

    // Метод закрывает подключение к базе данных
    public static void closeDB() throws ClassNotFoundException, SQLException {
        connection.close();
        statement.close();
        resultSet.close();

        System.out.println("DB Disconnected");
    }
}
