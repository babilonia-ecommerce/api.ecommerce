package py.edu.utic.api.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Product product = new Product(i,"cocina"+i);
			products.add(product);
			
		}
		
    	return new ResponseEntity<>(products, HttpStatus.OK);
    }
    	
}

class Product {

    private Integer id;
    private String descrition;
    
    public Product() {}
    
	public Product(Integer id, String descrition) {
		super();
		this.id = id;
		this.descrition = descrition;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
    
    
    
    
    
}
