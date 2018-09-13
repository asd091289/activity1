package com.fimc.hello.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.fimc.hello.request.PeopleRequest;
import com.fimc.hello.response.PeopleResponse;


public class PeopleService {
	
	
	
	static List<PeopleResponse> peopleResponse = new ArrayList<>();
	
	public static boolean addPerson(PeopleRequest peopleRequest) {
		PeopleResponse pr = new PeopleResponse();
		
		pr.setFirstName(peopleRequest.getFirstName());
		pr.setLastName(peopleRequest.getLastName());
		pr.setBirthDate(peopleRequest.getBirthDate());
		
		peopleResponse.add(pr);
		
		return true;
	}
	
	public static boolean isDateValid(String inDate) {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM-dd-yyyy");
	    sdfrmt.setLenient(false);
	    try
	    {
	        Date javaDate = sdfrmt.parse(inDate); 
	        
	    }catch (ParseException e){
	        return false;
	    }
	    return true;
	}
	
	public static List<PeopleResponse> findAllPerson() {
		return peopleResponse;
	}

}
