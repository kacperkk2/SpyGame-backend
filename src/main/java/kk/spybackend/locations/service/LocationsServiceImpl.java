package kk.spybackend.locations.service;

import kk.spybackend.locations.model.LocationsDto;
import kk.spybackend.locations.repo.LocationsRepository;
import kk.spybackend.locations.exceptions.LocationNotFoundException;
import kk.spybackend.locations.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationsServiceImpl implements LocationsService {
    private final LocationsRepository locationsRepository;
    private final DefaultLocationsManager defaultLocationsManager;

    @PostConstruct
    public void insertDefaultLocations(){
        Location location = locationsRepository.findByName(defaultLocationsManager.NAME)
                .orElseGet(() -> locationsRepository.save(defaultLocationsManager.loadDefaultLocations()));
        defaultLocationsManager.setDefaultId(location.getId());
    }

    @Override
    public LocationsDto save(LocationsDto locationsDto) {
        Location location = new Location();
        location.setLocations(locationsDto.getLocations());
        location.setName(locationsDto.getName());
        Location saved = locationsRepository.save(location);
        LocationsDto returnDto = new LocationsDto();
        returnDto.setName(saved.getName());
        return returnDto;
    }

    @Override
    public LocationsDto load(String name) {
        Location found = locationsRepository.findByName(name).orElseThrow(() -> new LocationNotFoundException(name));
        LocationsDto returnDto = new LocationsDto();
        returnDto.setName(found.getName());
        returnDto.setLocations(found.getLocations());
        return returnDto;
    }

    @Override
    public String loadDefault() {
        Long id = defaultLocationsManager.getDefaultId();
        Location found = locationsRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id.toString()));
        return found.getLocations();
    }

    @Override
    public List<LocationsDto> loadAll() {
        List<Location> locations = locationsRepository.findAll();
        return locations.stream().map(location -> {
            LocationsDto returnDto = new LocationsDto();
            returnDto.setName(location.getName());
            returnDto.setLocations(location.getLocations());
            return returnDto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String name) {
        locationsRepository.deleteByName(name);
    }
}
