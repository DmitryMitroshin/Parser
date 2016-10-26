import org.json.simple.JSONObject;

/**
 * Created by Dmitry on 26.10.2016.
 */
public class Station {

    private Long stationId;
    private String stationTitle;
    private Double stationLongitude;
    private Double stationLatitude;
    private Long cityId;

    public Station(JSONObject jsonObject) {
        stationId = (Long) jsonObject.get("stationId");
        stationTitle = (String) jsonObject.get("stationTitle");
        JSONObject stationPoint = (JSONObject) jsonObject.get("point");
        stationLongitude = (Double) stationPoint.get("stationLongitude");
        stationLatitude = (Double) stationPoint.get("stationLatitude");
        cityId = (Long) jsonObject.get("cityId");
    }

    public Station() {
    }

    public Long getStationId() {
        return stationId;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public Double getStationLongitude() {
        return stationLongitude;
    }

    public Double getStationLatitude() {
        return stationLatitude;
    }

    public Long getCityId() {
        return cityId;
    }
}
