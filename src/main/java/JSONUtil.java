import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.sqlite.SQLiteException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

// Класс, предоставляющий методы для работы с JSON.
public class JSONUtil {

    public static void parseCitiesToDB(String JSONToParseFile) {

        JSONParser parser = new JSONParser();

        // Достаем все объекты из массива CityFrom
        try {
            JSONObject mainJSONObject = (JSONObject) parser.parse(new FileReader(JSONToParseFile));

            JSONArray citiesFrom = (JSONArray) mainJSONObject.get("citiesFrom");
            JSONArray citiesTo = (JSONArray) mainJSONObject.get("citiesTo");

            System.out.println("Size of cities From = " + citiesFrom.size());
            System.out.println("Size of cities To = " + citiesTo.size());

            Iterator<JSONObject> iteratorFrom = citiesFrom.iterator();
            Iterator<JSONObject> iteratorTo = citiesTo.iterator();

            City cityFrom = null;
            City cityTo = null;

            while (iteratorFrom.hasNext()) {
                cityFrom = new City(iteratorFrom.next(), "From");
                DBUtil.writeCityToDB(cityFrom);
            }

            System.out.println("From complete");

            // Заполняя второй массив в БД, может оказаться, что город с данным идентификатором
            // уже имеется в базе. В таком случае устанавливаем в БД значение его поля direction = both
            while (iteratorTo.hasNext()) {
                cityTo = new City(iteratorTo.next(), "To");
                try {
                    DBUtil.writeCityToDB(cityTo);
                } catch (SQLiteException ex) {
                    DBUtil.updateDirectionToBoth(cityTo.getCityId());
                    continue;
                }
            }

            System.out.println("To complete");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void parseStationsToDB(String JSONToParseFile) {

        JSONParser parser = new JSONParser();

        try {
            JSONObject mainJSONObject = (JSONObject) parser.parse(new FileReader(JSONToParseFile));

            JSONArray citiesFrom = (JSONArray) mainJSONObject.get("citiesFrom");
            JSONArray citiesTo = (JSONArray) mainJSONObject.get("citiesTo");

            Iterator<JSONObject> iteratorFrom = citiesFrom.iterator();
            Iterator<JSONObject> iteratorTo = citiesTo.iterator();

            JSONArray stationsCityFrom = null;
            JSONArray stationsCityTo = null;

            Iterator<JSONObject> iteratorCityFrom;
            Iterator<JSONObject> iteratorCityTo;

            Station station = null;

            while (iteratorFrom.hasNext()) {
                stationsCityFrom = (JSONArray) iteratorFrom.next().get("stations");
                iteratorCityFrom = stationsCityFrom.iterator();

                while (iteratorCityFrom.hasNext()) {
                    station = new Station(iteratorCityFrom.next());
                    DBUtil.writeStationToDB(station);
                }
            }

            System.out.println("Stations from complete");

            while (iteratorTo.hasNext()) {
                stationsCityTo = (JSONArray) iteratorTo.next().get("stations");
                iteratorCityTo = stationsCityTo.iterator();
                while (iteratorCityTo.hasNext()) {
                    station = new Station(iteratorCityTo.next());
                    try {
                        DBUtil.writeStationToDB(station);
                    } catch (SQLiteException ex) {
                        continue;
                    }
                }
            }

            System.out.println("Stations to complete");

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
