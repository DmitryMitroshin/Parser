import java.sql.SQLException;

public class MainClass {

    private static final String JSONToParseFile = "C:\\Users\\Dmitry\\Desktop\\" +
            "FinalProjectToTuTu\\Parser\\src\\main\\resources\\TuTu.json";
    private static final String SQLiteDB = "jdbc:sqlite:TuTuDB.db";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DBUtil.connectToDB(SQLiteDB);
        DBUtil.createTableCity();

//        JSONParser parser = new JSONParser();
//
//        // Достаем все объекты из массива CityFrom
//        try {
//            JSONObject mainJSONObject = (JSONObject) parser.parse(new FileReader(JSONToParseFile));
//            JSONArray citiesFrom = (JSONArray) mainJSONObject.get("citiesFrom");
//
//            Iterator<JSONObject> iterator = citiesFrom.iterator();
//
//            City cityFrom = null;
//
//            while (iterator.hasNext()) {
//                cityFrom = new City(iterator.next(), "From");
//
//                System.out.println("");
//                System.out.println("--------------------------------------------------------------");
//                System.out.println("");
//
//                System.out.println(cityFrom);
//
//                System.out.println("");
//                System.out.println("--------------------------------------------------------------");
//                System.out.println("");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}