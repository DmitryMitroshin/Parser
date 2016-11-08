import org.json.simple.JSONObject;

public class Station {

    private Long stationId;
    private String stationTitle;
    private Double stationLongitude;
    private Double stationLatitude;
    private Long cityId;
    private String stationDirection;

    public Station(JSONObject jsonObject, String stationDirection) {
        stationId = (Long) jsonObject.get("stationId");
        stationTitle = (String) jsonObject.get("stationTitle");
        JSONObject stationPoint = (JSONObject) jsonObject.get("point");
        stationLongitude = (Double) stationPoint.get("longitude");
        stationLatitude = (Double) stationPoint.get("latitude");
        cityId = (Long) jsonObject.get("cityId");
        this.stationDirection = stationDirection;
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

    public String getStationDirection() {
        return stationDirection;
    }

    public Long getCityId() {
        return cityId;
    }
}
