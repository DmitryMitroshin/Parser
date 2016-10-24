public class City {

    private String countryTitle;
    private Double cityLongitude;
    private Double cityLatitude;
    private String districtTitle;
    private Long cityId;
    private String cityTitle;
    private String regionTitle;
    private String direction;

    public City(String countryTitle, Double cityLongitude, Double cityLatitude, String districtTitle,
                Long cityId, String cityTitle, String regionTitle, String direction) {
        this.countryTitle = countryTitle;
        this.cityLongitude = cityLongitude;
        this.cityLatitude = cityLatitude;
        this.districtTitle = districtTitle;
        this.cityId = cityId;
        this.cityTitle = cityTitle;
        this.regionTitle = regionTitle;
        this.direction = direction;
    }

    public String getCountryTitle() {
        return countryTitle;
    }

    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    public Double getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(Double cityLongitude) {
        this.cityLongitude = cityLongitude;
    }

    public Double getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(Double cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public void setDistrictTitle(String districtTitle) {
        this.districtTitle = districtTitle;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getRegionTitle() {
        return regionTitle;
    }

    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
