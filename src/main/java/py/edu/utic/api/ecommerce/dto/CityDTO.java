package py.edu.utic.api.ecommerce.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO implements Serializable{
    
    private Integer id;
    private String descriptio;
    
}
