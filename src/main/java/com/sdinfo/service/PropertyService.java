package com.sdinfo.service;


import java.util.List;

import com.sdinfo.dto.PropertyDTO;


//@Service
public interface PropertyService {

	public PropertyDTO saveProperty(PropertyDTO propertyDTO) ;
	
	public List<PropertyDTO> getAllProperties() ;

	public void deleteProperty(Long propertyId);
	
	
}
