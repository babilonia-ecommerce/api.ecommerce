package py.edu.utic.api.ecommerce.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.utic.api.ecommerce.entities.City;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityReposository extends PagingAndSortingRepository<City, Long> {

}
