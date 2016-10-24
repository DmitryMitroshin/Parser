import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by Dmitry on 24.10.2016.
 */
public class JSONUtil {

    public static void parseCities(String JSONToParseFile) {

        JSONParser parser = new JSONParser();

        // Достаем все объекты из массива CityFrom
        try {
            JSONObject mainJSONObject = (JSONObject) parser.parse(new FileReader(JSONToParseFile));

            JSONArray citiesFrom = (JSONArray) mainJSONObject.get("citiesFrom");
            JSONArray citiesTo = (JSONArray) mainJSONObject.get("citiesTo");

            Iterator<JSONObject> iteratorFrom = citiesFrom.iterator();
            Iterator<JSONObject> iteratorTo = citiesFrom.iterator();

            City cityFrom = null;
            City cityTo = null;

            while (iteratorFrom.hasNext() | iteratorTo.hasNext()) {
                cityFrom = new City(iteratorFrom.next(), "From");
                cityTo = new City(iteratorTo.next(), "To");
                DBUtil.writeCityToDB(cityFrom);
                DBUtil.writeCityToDB(cityTo);
            }

            System.out.println("Table Filled");
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
}
