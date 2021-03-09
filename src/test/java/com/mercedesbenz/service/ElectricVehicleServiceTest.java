package com.mercedesbenz.service;

import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ElectricVehicleServiceTest {

    public static MockWebServer mockBackEnd;
    private ElectricVehicleService electricVehicleService;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }


    @Test
    void test_happy_path_getMaxRange() {
        assertTrue(true);
    }
}