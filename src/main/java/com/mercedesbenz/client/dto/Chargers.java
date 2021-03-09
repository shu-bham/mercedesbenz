package com.mercedesbenz.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Chargers {

    @JsonProperty("array")
    private List<Integer> array;

    @JsonProperty("array")
    public List<Integer> getArray() {
        return array;
    }

    public Chargers() {
    }

    @JsonProperty("array")
    public void setArray(List<Integer> array) {
        this.array = array;
    }
}
