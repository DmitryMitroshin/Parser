import org.json.simple.JSONObject;

public class City {

    private String countryTitle;
    private Double cityLongitude;
    private Double cityLatitude;
    private String districtTitle;
    private Long cityId;
    private String cityTitle;
    private String regionTitle;
    private String direction;

    public City(JSONObject jsonObject, String direction) {
        countryTitle = (String) jsonObject.get("countryTitle");
        JSONObject cityPoints = (JSONObject) jsonObject.get("point");
        cityLongitude = (Double) cityPoints.get("longitude");
        cityLatitude = (Double) cityPoints.get("latitude");
        districtTitle = (String) jsonObject.get("districtTitle");
        cityId = (Long) jsonObject.get("cityId");
        cityTitle = (String) jsonObject.get("cityTitle");
        regionTitle = (String) jsonObject.get("regionTitle");
        this.direction = direction;
    }

    public City() {
    }

    public String getCountryTitle() {
        return countryTitle;
    }

    public Double getCityLongitude() {
        return cityLongitude;
    }

    public Double getCityLatitude() {
        return cityLatitude;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public String getRegionTitle() {
        return regionTitle;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        String strCity;

        strCity = "Country: " + countryTitle +
                "\nLongitude: " + cityLongitude +
                "\nLatitude: " + cityLatitude +
                "\nDistrict: " + districtTitle +
                "\nRegion: " + regionTitle +
                "\nCity ID: " + cityId +
                "\nCity: " + cityTitle +
                "\nDirection: " + direction;

        return strCity;
    }
}
