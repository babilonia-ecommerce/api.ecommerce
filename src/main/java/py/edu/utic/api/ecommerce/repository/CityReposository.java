package py.edu.utic.api.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.edu.utic.api.ecommerce.entities.City;

@Repository
public interface CityReposository extends CrudRepository<City, Long> {

}
