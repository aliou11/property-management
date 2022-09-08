package com.sdinfo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdinfo.dto.PropertyDTO;
import com.sdinfo.entity.PropertyEntity;
import com.sdinfo.repository.PropertyRepository;
import com.sdinfo.service.PropertyService;

import com.sdinfo.converter.PropertyConverter;



@Service
public class PropertyServiceImpl implements PropertyService {
	
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyConverter propertyConverter;

	@Override
	public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

		PropertyEntity pe = this.propertyConverter.convertPropertyDtoToEntity(propertyDTO);
		this.propertyRepository.save(pe);
		return null;
	}

	@Override
	public List<PropertyDTO> getAllProperties() {
		
		List<PropertyDTO> lstPropertyDTOs = new ArrayList<PropertyDTO>();
		
		List<PropertyEntity> lstProperties =  (List<PropertyEntity>) propertyRepository.findAll();
		
		for(PropertyEntity pe: lstProperties) {
			
			PropertyDTO propertyDTO =  propertyConverter.convertPropertyEntityToDto(pe);
			
			lstPropertyDTOs.add(propertyDTO);
		}
		return lstPropertyDTOs;
	}

	
	@Override
	public void deleteProperty(Long propertyId) {
		propertyRepository.deleteById(propertyId);
	}
}
