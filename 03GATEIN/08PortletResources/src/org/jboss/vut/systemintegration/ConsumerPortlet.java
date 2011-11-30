package org.jboss.vut.systemintegration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.UnavailableException;

public class ConsumerPortlet extends GenericPortlet {

    /* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException, UnavailableException {
		response.setContentType("text/html");
		String username = request.getParameter("usernameFromAction");
		PrintWriter writer = response.getWriter();
		if (username != null && (!username.isEmpty() && !username.equals("empty"))) {
			writer.write("Hello " + username + " (value passed from PRP)");
		} else {
			writer.write("No public param passed");
		}
		writer.close();
	}
}
