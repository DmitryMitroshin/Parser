import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class MainClass {

    private static final String JSONToParseFile = "C:\\Users\\Dmitry\\Desktop\\FinalProjectToTuTu\\Data\\TuTu.json";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        // Достаем все объекты из массива CityFrom
        try {
            JSONObject mainJSONObject = (JSONObject) parser.parse(new FileReader(JSONToParseFile));
            JSONArray citiesFrom = (JSONArray) mainJSONObject.get("citiesFrom");

            Iterator<JSONObject> iterator = citiesFrom.iterator();
            JSONObject cityFrom = (JSONObject) iterator.next();

            JSONUtil jsonUtil = new JSONUtil();

            while (iterator.hasNext()) {
                jsonUtil.parseCityToDB(iterator.next(), "From");
            }
//            String countryTitle = (String) cityFrom.get("countryTitle");
//            JSONObject cityPoints = (JSONObject) cityFrom.get("point");
//            Double cityLongitude = (Double) cityPoints.get("longitude");
//            Double cityLatitude = (Double) cityPoints.get("latitude");
//            String districtTitle = (String) cityFrom.get("districtTitle");
//            Long cityId = (Long) cityFrom.get("cityId");
//            String cityTitle = (String) cityFrom.get("cityTitle");
//            String regionTitle = (String) cityFrom.get("regionTitle");
//
//
//            System.out.println("Country: " + countryTitle);
//            System.out.println("Longitude: " + cityLongitude);
//            System.out.println("Latitude: " + cityLatitude);
//            System.out.println("District: " + districtTitle);
//            System.out.println("Region: " + regionTitle);
//            System.out.println("City ID: " + cityId);
//            System.out.println("City: " + cityTitle);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
