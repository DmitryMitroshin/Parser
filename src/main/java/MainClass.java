import java.sql.SQLException;

public class MainClass {

    private static final String JSONToParseFile = "C:\\Users\\Dmitry\\Desktop\\" +
            "FinalProjectToTuTu\\Parser\\src\\main\\resources\\allStations.json";
    private static final String SQLiteDB = "jdbc:sqlite:TuTuDB.db";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // TODO Так как в исходном файле allStations.json присутствуют символы апострофа,
        // которые по одиночке не воспринимаются в SQLite,
        // была реализована функция, которая добавляет второй апостроф рядом с каждым уже имеющимся.
        // Так как последовательность из двух апострофов позволяет считать строку и корректно воспринять один из них.


        DBUtil.connectToDB(SQLiteDB);
        DBUtil.createTableCity();
        JSONUtil.parseCities(JSONToParseFile);

        // TODO Нужно закрыть подключение, когда все считаем
//        DBUtil.closeDB();
    }
}