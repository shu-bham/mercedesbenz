package com.mercedesbenz.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChargerDataList {

    @JsonProperty("chargers")
    private List<Chargers> chargersList;

    public ChargerDataList() {
    }

    @JsonProperty("chargers")
    public List<Chargers> getChargersList() {
        return chargersList;
    }

    @JsonProperty("chargers")
    public void setChargersList(List<Chargers> chargersList) {
        this.chargersList = chargersList;
    }
}
