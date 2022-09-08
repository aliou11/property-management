package com.sdinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdinfo.dto.PropertyDTO;
import com.sdinfo.service.PropertyService;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
	
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/hello")
	public String sayHelo() {
		return "hello";
	}
	
	
	
	@PostMapping("/properties")
	public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
		
		
		 propertyDTO = propertyService.saveProperty(propertyDTO);
		 
		 ResponseEntity< PropertyDTO> responseEntity = new  ResponseEntity<PropertyDTO>(propertyDTO,HttpStatus.CREATED);
		
		System.out.println(propertyDTO);
		
		return responseEntity;
		
	}

	@GetMapping("/properties")
	public ResponseEntity<List<PropertyDTO>> getAllProperties() {
		List<PropertyDTO> propertyDTOs =   propertyService.getAllProperties();
		
		
		ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<List<PropertyDTO>>(propertyDTOs, HttpStatus.OK);
		return responseEntity;
		
	}
	
	
	@DeleteMapping("/properties/{propertyId}")
	public ResponseEntity<Void> deleteProperty(@PathVariable   Long propertyId) {
		propertyService.deleteProperty(propertyId);
		
		ResponseEntity<Void> responseEntity= new ResponseEntity<>(null,HttpStatus.CREATED);
		
		return responseEntity;
		
	}
}
