package kk.spybackend.locations.controller;

import kk.spybackend.locations.exceptions.LocationNotFoundException;
import kk.spybackend.locations.model.LocationsDto;
import kk.spybackend.locations.service.LocationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LocationsController {

    private final LocationsService locationsService;

    @PostMapping()
    public ResponseEntity<LocationsDto> save(@RequestBody LocationsDto locationsDto) {
        return ResponseEntity.ok().body(locationsService.save(locationsDto));
    }

    @GetMapping("/{name}")
    @CrossOrigin
    public ResponseEntity<LocationsDto> load(@PathVariable String name) {
        try {
            return ResponseEntity.ok().body(locationsService.load(name));
        } catch (LocationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<List<LocationsDto>> loadAll() {
        return ResponseEntity.ok().body(locationsService.loadAll());
    }

    @GetMapping("/default")
    @CrossOrigin
    public String loadDefault() {
        return locationsService.loadDefault();
    }

    @DeleteMapping("/{name}")
    @CrossOrigin
    public void delete(@PathVariable String name) {
        locationsService.delete(name);
    }
}
