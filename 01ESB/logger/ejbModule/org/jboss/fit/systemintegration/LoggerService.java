package org.jboss.fit.systemintegration;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="Logger")
@Stateless
public class LoggerService {
	
	@WebMethod(action="log")
	public void log(@WebParam(name="message") String message) {
		System.out.println("#########LoggerService log start########");
		System.out.println(message);		
		System.out.println("#########LoggerService log end  ########");
	}

}
