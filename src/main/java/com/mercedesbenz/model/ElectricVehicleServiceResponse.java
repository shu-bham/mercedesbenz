package com.mercedesbenz.model;

import java.util.List;

public class ElectricVehicleServiceResponse {

    private List<String> responseCodes;

    public List<String> getResponseCodes() {
        return responseCodes;
    }

    public ElectricVehicleServiceResponse() {
    }

    public void setResponseCodes(List<String> responseCodes) {
        this.responseCodes = responseCodes;
    }
}
