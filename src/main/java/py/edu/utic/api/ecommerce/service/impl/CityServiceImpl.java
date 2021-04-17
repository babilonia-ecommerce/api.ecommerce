package py.edu.utic.api.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import py.edu.utic.api.ecommerce.beans.CityBean;
import py.edu.utic.api.ecommerce.converter.CityConverter;
import py.edu.utic.api.ecommerce.entities.City;
import py.edu.utic.api.ecommerce.repository.CityReposository;
import py.edu.utic.api.ecommerce.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	private final CityReposository cityReposository;
	private final CityConverter cityConverter;

	public CityServiceImpl(CityReposository cityReposository, CityConverter cityConverter) {
		this.cityConverter = cityConverter;
		this.cityReposository = cityReposository;
	}

	@Override
	public List<CityBean> getCities() {
		Iterable<City> citiesI = cityReposository.findAll();
		List<CityBean> cities = new ArrayList<>();
		if (citiesI.iterator().hasNext()) {
			citiesI.forEach(c -> cities.add(cityConverter.buildDTO(c)));
		}
		return cities;

	}

	@Override
	public List<CityBean> save(CityBean city) {
		if(city.getId() != null  && cityReposository.existsById(city.getId())) {
			throw new RuntimeException("Ya existe registro con el mismo id");
		}
		City cityEntity = cityConverter.buildEntity(city);
		cityReposository.save(cityEntity);
		return this.getCities();
		
	}

}
