package py.edu.utic.api.ecommerce.converter;

import org.springframework.stereotype.Component;

import py.edu.utic.api.ecommerce.beans.CityBean;
import py.edu.utic.api.ecommerce.entities.City;

@Component
public class CityConverter {
    
    public CityBean buildDTO(City entity){
        return new CityBean(entity.getIdCiudad(), entity.getDescripcion());
    }

	public City buildEntity(CityBean city) {
		return new City(city.getId(), city.getDescription());
	}
    
}
