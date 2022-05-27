package com.focus.controller;

import com.focus.model.*;
import com.focus.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
@Slf4j
public class LocationController {

     private final LocationService locationService;

    @GetMapping("/country")
    public ResponseEntity<Response> getCOuntries(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("List All Countries")
                        .data(Collections.singletonMap("projects" , locationService.getAllCountries() ))
                        .build()
        );
    }
    @GetMapping("/country/{id}")
    public ResponseEntity<Response> getCountryById(@PathVariable Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Fetch Country By using ID : "+ id)
                        .data(Collections.singletonMap("projects" , locationService.getCountryById(id) ))
                        .build()
        );
    }
    @PostMapping("/country")
    public ResponseEntity<Response> saveCountry(@RequestBody @Valid Country country) throws IOException {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .data(Collections.singletonMap("Country" , locationService.saveCountry(country) ) )
                        .message("New Country Info Stored")
                        .build()
        );
    }

    @GetMapping("/state/{countryId}")
    public ResponseEntity<Response> getStates(@PathVariable Long countryId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("List All States of Country "+ countryId)
                        .data(Collections.singletonMap("States" , locationService.getAllStates(countryId) ))
                        .build()
        );
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<Response> getStateById(@PathVariable Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Display States by Id"+ id)
                        .data(Collections.singletonMap("States" , locationService.getStateById(id) ))
                        .build()
        );
    }

    @PostMapping("/state")
    public ResponseEntity<Response> saveState(@RequestBody @Valid State state) throws IOException {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .data(Collections.singletonMap("State" , locationService.saveState(state) ) )
                        .message("New State Info Stored")
                        .build()
        );
    }

    @GetMapping("/districts/{stateId}")
    public ResponseEntity<Response> getDistricts(@PathVariable Long stateId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("List All District from the State : "+ stateId )
                        .data(Collections.singletonMap("districts" , locationService.getAllDistrict(stateId) ))
                        .build()
        );
    }
    @GetMapping("/district/{id}")
    public ResponseEntity<Response> getDistrictById(@PathVariable Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Fetch Country By using ID : "+ id)
                        .data(Collections.singletonMap("projects" , locationService.getDistrictById(id) ))
                        .build()
        );
    }
    @PostMapping("/district")
    public ResponseEntity<Response> saveDistrict(@RequestBody @Valid District district) throws IOException {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .data(Collections.singletonMap("Country" , locationService.saveDistrict(district) ) )
                        .message("New Country Info Stored")
                        .build()
        );
    }

    @GetMapping("/region/{districtId}")
    public ResponseEntity<Response> getRegions(@PathVariable Long districtId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("List All Region from the District : "+ districtId )
                        .data(Collections.singletonMap("region" , locationService.getAllRegion(districtId) ))
                        .build()
        );
    }
    @GetMapping("/region/{id}")
    public ResponseEntity<Response> getRegionById(@PathVariable Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Fetch Region By using ID : "+ id)
                        .data(Collections.singletonMap("region" , locationService.getRegionById(id) ))
                        .build()
        );
    }
    @PostMapping("/region")
    public ResponseEntity<Response> saveRegion(@RequestBody @Valid Region region) throws IOException {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .data(Collections.singletonMap("Region" , locationService.saveRegion(region) ) )
                        .message("New Region Info Stored")
                        .build()
        );
    }

}
