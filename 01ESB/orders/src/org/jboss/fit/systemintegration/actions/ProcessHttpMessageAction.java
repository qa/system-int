package org.jboss.fit.systemintegration.actions;

import java.util.Arrays;
import java.util.Map;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.http.HttpRequest;
import org.jboss.soa.esb.message.Body;
import org.jboss.soa.esb.message.Message;

public class ProcessHttpMessageAction extends AbstractActionLifecycle {
	
	private ConfigTree config;
	
	public ProcessHttpMessageAction(ConfigTree _config) {
		this.config = _config;
	}

	public Message processMessage(Message message) {
		HttpRequest request = HttpRequest.getRequest(message);		
		Map<String, String[]> params = request.getQueryParams();
		Body body = message.getBody();		
		body.add(request.getQueryString());
		for (String p : params.keySet()) {
			String[] values = params.get(p);
			System.out.println("Param=" + p + ",values=" + Arrays.toString(values));
		}
		
		
		return message;
	}
	
}
