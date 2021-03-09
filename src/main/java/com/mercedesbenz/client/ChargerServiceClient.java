package com.mercedesbenz.client;

import com.mercedesbenz.client.dto.ChargerDataList;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ChargerServiceClient {

    Mono<ChargerDataList> getChargerData();

}
