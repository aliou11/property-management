package com.sdinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdinfo.dto.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
	
	
	
	@GetMapping("add")
	public Double add(@RequestParam("num11") Double num1 , @RequestParam("num22") Double num2) {
		return num1 + num2;
	}

	
	@GetMapping("sub/{num1}/{num2}")
	public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
		
		Double result = null;
		
		if(num1 > num2)
			result = num1 - num2;
		else
			result = num2 - num1;
		
		return result;
			
			
	}
	
	@PostMapping("/mul")
	public ResponseEntity<Double>  mutiply(@RequestBody  CalculatorDTO calculatorDTO) {
		
		Double result = null;
		
		result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
		
		ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result,HttpStatus.CREATED);
		
		return responseEntity;
		
	}
	
	
}
