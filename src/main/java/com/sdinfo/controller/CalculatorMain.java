package com.sdinfo.controller;

public class CalculatorMain {

	public static void main(String[] args) {

		
		CalculatorController cc = new CalculatorController();
		Double result  = cc.add(3.4, 5.9 );
		
		System.out.println(result);
	}

}
