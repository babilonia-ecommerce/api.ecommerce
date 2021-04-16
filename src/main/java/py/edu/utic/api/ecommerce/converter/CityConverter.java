package py.edu.utic.api.ecommerce.converter;

import org.springframework.stereotype.Component;
import py.edu.utic.api.ecommerce.dto.CityDTO;
import py.edu.utic.api.ecommerce.entities.City;

@Component
public class CityConverter {
    
    public CityDTO buildDTO(City entity){
        return new CityDTO(entity.getIdCiudad(), entity.getDescripcion());
    }
    
}
