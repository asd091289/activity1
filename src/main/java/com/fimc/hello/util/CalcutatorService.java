package com.fimc.hello.util;

import java.text.DecimalFormat;

import com.fimc.hello.request.CalculatorRequest;

public class CalcutatorService {

	public static String action(String action) {
		String returnValue = null;
		switch (action) {
		case "+":
			returnValue = "Addition";
			break;
		case "-":
			returnValue= "Subtraction";
			break;	
		case "*":
			returnValue =  "Multiplication";
			break;
		case "/":
			returnValue =  "Division";
			break;
		}
		return returnValue;
		
	}
	
	public static float calculate(CalculatorRequest cal) {
		float returnValue = 0;
		DecimalFormat d = new DecimalFormat("#.00000");
		switch (cal.getOperator()) {
		case "+":
			returnValue = Float.parseFloat(cal.getNum1()) + Float.parseFloat(cal.getNum2());
			break;
		case "-":
			returnValue=  Float.parseFloat(cal.getNum1()) - Float.parseFloat(cal.getNum2());;
			break;	
		case "*":
			returnValue =   Float.parseFloat(cal.getNum1()) * Float.parseFloat(cal.getNum2());;
			break;
		case "/":
			returnValue = Float.parseFloat(d.format(( Float.parseFloat(cal.getNum1()) / Float.parseFloat(cal.getNum2()))));
			
			break;
		}
		return returnValue;
		
	}
	
	public static boolean validateOperation(String action) {
		boolean returnValue = true;
		switch (action) {
		case "+":
			returnValue = false;
			break;
		case "-":
			returnValue= false;
			break;	
		case "*":
			returnValue =  false;
			break;
		case "/":
			returnValue =  false;
			break;
		}
		return returnValue;
	}
	
	public static boolean validateNumer(String num) {
		boolean isValid = true;
		try {
			Float.parseFloat(num);
			isValid = false;
		} catch (NumberFormatException e) {
			isValid = true;
		}
		return isValid;
	}

	

}
