package kk.spybackend.locations.service;

import kk.spybackend.locations.model.LocationsDto;

import java.util.List;

public interface LocationsService {
    LocationsDto save(LocationsDto locationsDto);

    LocationsDto load(String name);

    String loadDefault();

    List<LocationsDto> loadAll();

    void delete(String name);
}
