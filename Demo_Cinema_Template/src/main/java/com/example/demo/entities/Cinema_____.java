
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cinema_____ {

    @SerializedName("cinemaId")
    @Expose
    private String cinemaId;
    @SerializedName("cinemaName")
    @Expose
    private String cinemaName;
    @SerializedName("cinemaAddress")
    @Expose
    private String cinemaAddress;

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

}
