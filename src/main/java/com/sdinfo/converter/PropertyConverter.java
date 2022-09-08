package com.sdinfo.converter;

import org.springframework.stereotype.Component;

import com.sdinfo.dto.PropertyDTO;
import com.sdinfo.entity.PropertyEntity;


@Component
public class PropertyConverter {
	
	
	public PropertyEntity convertPropertyDtoToEntity( PropertyDTO propertyDTO) {
		
		PropertyEntity pe = new PropertyEntity();
		pe.setTitle(propertyDTO.getTitle());
		pe.setOwnerEmail(propertyDTO.getOwnerEmail());
		pe.setAddress(propertyDTO.getAddress());
		pe.setOwnerName(propertyDTO.getOwnerName());
		pe.setDescription(propertyDTO.getDescription());
		pe.setPrice(propertyDTO.getPrice());
		
		return pe;
		
	}
	
	public PropertyDTO convertPropertyEntityToDto(PropertyEntity propertyEntity) {
		
		PropertyDTO propertyDTO = new PropertyDTO();
		
		propertyDTO.setTitle(propertyEntity.getTitle());
		propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
		propertyDTO.setAddress(propertyEntity.getAddress());
		propertyDTO.setOwnerName(propertyEntity.getOwnerName());
		propertyDTO.setDescription(propertyEntity.getDescription());
		propertyDTO.setPrice(propertyEntity.getPrice());
		
		return propertyDTO;
		
		
	}

}
