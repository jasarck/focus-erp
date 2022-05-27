package com.focus.service;

import com.focus.model.Country;
import com.focus.model.District;
import com.focus.model.Region;
import com.focus.model.State;
import com.focus.repository.CountryRepository;
import com.focus.repository.DistrictRepository;
import com.focus.repository.RegionRepository;
import com.focus.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{


    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    private final RegionRepository regionRepository;

    private final DistrictRepository districtRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public State getStateById(Long id) {
        return stateRepository.findById(id).get();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<State> getAllStates(Long countryId) {
            return stateRepository.findByCountryId(countryId);
    }

    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }


    @Override
    public List<District> getAllDistrict(Long stateId) {
        return districtRepository.findByStateId(stateId);
    }

    @Override
    public District getDistrictById(Long id) {
        return districtRepository.findById(id).get();
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<Region> getAllRegion(Long districtId) {
        return regionRepository.findByDistrictId(districtId);
    }

    @Override
    public Region getRegionById(Long id) {
        return regionRepository.findById(id).get();
    }

    @Override
    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }


}
