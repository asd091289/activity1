package com.fimc.hello.request;

import java.io.Serializable;
import java.text.DecimalFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class CalculatorRequest  implements Serializable{

	private String operator;
	private String num1;
	private String num2;
	
	public CalculatorRequest() {
		
	}

	
	
	
	
}
