import org.json.simple.JSONObject;

/**
 * Created by Dmitry on 23.10.2016.
 */
public class JSONUtil {

    public void parseCityToDB(JSONObject jsonObject, String direction) {

        String countryTitle = (String) jsonObject.get("countryTitle");
        JSONObject cityPoints = (JSONObject) jsonObject.get("point");
        Double cityLongitude = (Double) cityPoints.get("longitude");
        Double cityLatitude = (Double) cityPoints.get("latitude");
        String districtTitle = (String) jsonObject.get("districtTitle");
        Long cityId = (Long) jsonObject.get("cityId");
        String cityTitle = (String) jsonObject.get("cityTitle");
        String regionTitle = (String) jsonObject.get("regionTitle");

        System.out.println("Country: " + countryTitle);
        System.out.println("Longitude: " + cityLongitude);
        System.out.println("Latitude: " + cityLatitude);
        System.out.println("District: " + districtTitle);
        System.out.println("Region: " + regionTitle);
        System.out.println("City ID: " + cityId);
        System.out.println("City: " + cityTitle);

        System.out.println("Direction: " + direction);

        System.out.println("");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
    }
}
