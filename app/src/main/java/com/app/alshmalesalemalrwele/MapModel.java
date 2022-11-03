package com.app.alshmalesalemalrwele;

public class MapModel {

    private String mapText ;
    private String mapUrl;

    public MapModel(String mapText, String mapUrl) {
        this.mapText = mapText;
        this.mapUrl = mapUrl;
    }

    public String getMapText() {
        return mapText;
    }

    public void setMapText(String mapText) {
        this.mapText = mapText;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }
}
