package com.mercedesbenz.service;

import com.mercedesbenz.client.ChargerServiceClient;
import com.mercedesbenz.client.dto.ChargerDataList;
import com.mercedesbenz.client.dto.Chargers;
import com.mercedesbenz.model.ElectricVehicleServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/electric-vehicle")
public class ElectricVehicleService {

    @Autowired
    ChargerServiceClient chargerServiceClient;

    @GetMapping("/max-range/{currentFuelLevel}")
    public ResponseEntity getMaxRange(@PathVariable final int currentFuelLevel) {
        ElectricVehicleServiceResponse response = new ElectricVehicleServiceResponse();
        List<String> responseCode = new ArrayList<>();
        ChargerDataList chargerDataList = chargerServiceClient.getChargerData().block();
        if (chargerDataList == null) {
            return new ResponseEntity("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Chargers> chargersList = chargerDataList.getChargersList();
        chargersList.forEach(chargers -> {
            List<Integer> array = chargers.getArray();
            int temp = currentFuelLevel;
            boolean broken = false;
            for (Integer integer : array) {
                temp += (integer - 1);
                if (temp <= 0) {
                    broken = true;
                    responseCode.add("400");
                    break;
                }
            }
            if (!broken) {
                responseCode.add("200");
            }
        });
        response.setResponseCodes(responseCode);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
