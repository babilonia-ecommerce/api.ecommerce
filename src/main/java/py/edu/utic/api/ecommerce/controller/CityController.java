package py.edu.utic.api.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import py.edu.utic.api.ecommerce.beans.CityBean;
import py.edu.utic.api.ecommerce.service.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    
    private final CityService cityService;
    
    public CityController(CityService cityService) {
		this.cityService = cityService;
	}
    
    @Operation(summary = "Obtiene el listado de ciudades. Equivalente a select * from ciudades")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Lista de ciudades", 
        content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = CityBean.class)) }),
      @ApiResponse(responseCode = "204", description = "No se encontraron datos", 
        content = @Content) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityBean>> getCity() {
    	List<CityBean> cities = cityService.getCities();
        if(cities.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
        	return new ResponseEntity<>(cities, HttpStatus.OK);
        }
    }
    
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityBean>> save(@RequestBody CityBean city){
    	return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }
    
}
