/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.utic.api.ecommerce.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"py.edu.utic.api.ecommerce.repository"})
@EntityScan(basePackages = {"py.edu.utic.api.ecommerce.entities"})
@ComponentScan(basePackages = { "py.edu.utic.api.ecommerce" })
public class CustomRestMvcConfiguration {

}