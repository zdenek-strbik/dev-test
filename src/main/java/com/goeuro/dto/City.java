package com.goeuro.dto;

import com.google.gson.annotations.SerializedName;
import com.sun.javafx.binding.DoubleConstant;

/**
 * Created by Zdenek Strbik
 */
public class City {

    @SerializedName("_id")
    private Integer id;
    private String name;
    private String type;
    @SerializedName("geo_position")
    private GeoPosition geoPosition;

    public City(Integer id, String name, String type, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.geoPosition = new GeoPosition(latitude, longitude);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Double getLatitude() {
        return geoPosition.getLatitude();
    }

    public Double getLongitude() {
        return geoPosition.getLongitude();
    }
}
