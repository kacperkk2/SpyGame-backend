package kk.spybackend.locations.repo;

import kk.spybackend.locations.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationsRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String name);
    void deleteByName(String name);
}
