package com.fimc.hello.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.request.PeopleRequest;
import com.fimc.hello.response.PeopleResponse;
import com.fimc.hello.util.PeopleService;



@Component
@Path("/people")
public class PeopleResource {
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPeople(PeopleRequest peopleRequest){
	System.err.println(peopleRequest);
		if(StringUtils.isEmpty(peopleRequest.getFirstName()) || 
				StringUtils.isEmpty(peopleRequest.getLastName()) || 
				StringUtils.isEmpty(peopleRequest.getBirthDate())) {
		
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();	
		}else if(PeopleService.isDateValid(peopleRequest.getBirthDate())==false) {
			
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();	
		}
		PeopleService.addPerson(peopleRequest);
		
		
		return Response.ok(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		List<PeopleResponse> people = PeopleService.findAllPerson();
		return Response.ok().entity(people).build();
	}
}
