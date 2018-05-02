package com.example.mrrobot.customernew.model;

import java.util.List;



/**
 * Created by Mr Robot on 2/22/2018.
 */

public class WebSite {

    private String status;
    private List<Source> sources;

    public WebSite() {

    }

    public WebSite(String status, List<Source> sources) {
        this.sources = sources;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
