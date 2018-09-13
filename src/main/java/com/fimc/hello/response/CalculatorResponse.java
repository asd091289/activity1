package com.fimc.hello.response;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class CalculatorResponse implements Serializable{

	private String action;
	private float result;
	
	public CalculatorResponse() {
		
	}
	public CalculatorResponse(String action,float result) {
		this.action = action;
		this.result = result;
	}
	

}
