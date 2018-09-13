package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.request.CalculatorRequest;
import com.fimc.hello.response.CalculatorResponse;
import com.fimc.hello.util.CalcutatorService;

@Component
@Path("/calculator")
public class CalculatorResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculate(CalculatorRequest calculator) {
		if (StringUtils.isEmpty(calculator.getOperator()) || CalcutatorService.validateOperation(calculator.getOperator())
				|| StringUtils.isEmpty(calculator.getNum1()) || StringUtils.isEmpty(calculator.getNum2())
				|| CalcutatorService.validateNumer(calculator.getNum1()) || CalcutatorService.validateNumer(calculator.getNum2())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST)
					.build();
		}

		CalculatorResponse calculatorResponse = new CalculatorResponse(CalcutatorService.action(calculator.getOperator()),
				CalcutatorService.calculate(calculator));
		return Response.ok().entity(calculatorResponse).build();

	}
}
