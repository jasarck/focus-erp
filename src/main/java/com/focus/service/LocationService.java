package com.focus.service;

import com.focus.model.Country;
import com.focus.model.District;
import com.focus.model.Region;
import com.focus.model.State;

import java.util.List;

public interface LocationService {
    List<Country> getAllCountries();
    Country saveCountry(Country country);

    List<State> getAllStates(Long countryId);

    State saveState(State state);

    Country getCountryById(Long id);

    State getStateById(Long id);

    List<District> getAllDistrict(Long stateId);

    District getDistrictById(Long id);

    District saveDistrict(District district);

    List<Region> getAllRegion(Long districtId);

    Region getRegionById(Long id);

    Region saveRegion(Region region);
}
