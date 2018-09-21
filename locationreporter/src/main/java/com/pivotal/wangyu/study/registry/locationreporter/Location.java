package com.pivotal.wangyu.study.registry.locationreporter;

import java.io.Serializable;

public class Location implements Serializable {
    private String country;
    private String city;
    private long latitude;
    private long longitude;

    public Location(String country, String city, long latitude, long longitude) {
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }
}
