package org.jboss.vut.ws.echo;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author mbaluch
 */
@WebService(name = "EchoService", targetNamespace = "http://www.jboss.org/vut/ws/echo")
public class EchoWS {
	
    @WebMethod(operationName = "echo")
    public String echo(@WebParam(name = "message") String message) {
    	message = "[EchoWS] " + message;
    	System.out.println(message);
    	return message;
    }

    @WebMethod(operationName = "fastEcho")
    @Oneway
    public void fastEcho(@WebParam(name = "message") String message) {
    	System.out.println("[EchoWS]" + message);
    }

}
