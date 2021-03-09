package com.mercedesbenz.client;

import com.mercedesbenz.client.dto.ChargerDataList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChargerServiceClientImpl
        implements ChargerServiceClient {

    @Value("${CHARGER_URL}")
    private String chargerUrl;


    @Override
    public Mono<ChargerDataList> getChargerData() {
        return WebClient.builder().baseUrl(chargerUrl).build().get().retrieve().bodyToMono(ChargerDataList.class).log();
    }
}
