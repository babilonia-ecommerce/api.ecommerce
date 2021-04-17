package py.edu.utic.api.ecommerce.service;

import java.util.List;

import py.edu.utic.api.ecommerce.beans.CityBean;

public interface CityService {
	
	public List<CityBean> getCities();

	public List<CityBean> save(CityBean city);
	
}
