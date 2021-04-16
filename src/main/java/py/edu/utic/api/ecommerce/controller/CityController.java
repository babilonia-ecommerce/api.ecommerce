package py.edu.utic.api.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.edu.utic.api.ecommerce.converter.CityConverter;
import py.edu.utic.api.ecommerce.dto.CityDTO;

import py.edu.utic.api.ecommerce.entities.City;
import py.edu.utic.api.ecommerce.repository.CityReposository;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    
    @Autowired
    private CityReposository cityReposository;
    @Autowired
    private CityConverter cityConverter;
    
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> getCity() {
        
        Iterable<City> citiesI = cityReposository.findAll();
        List<CityDTO> cities = new ArrayList<>();
        citiesI.forEach(c -> cities.add(cityConverter.buildDTO(c)));
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    
}
