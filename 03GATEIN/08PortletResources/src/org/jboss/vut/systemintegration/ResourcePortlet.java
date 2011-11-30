package org.jboss.vut.systemintegration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.UnavailableException;

public class ResourcePortlet extends GenericPortlet {
	
	private String[] values = new String[]{
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"};

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException, UnavailableException {
		response.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/view-resource.jsp");
		prd.include(request, response);
	}

	@Override
	public void serveResource(ResourceRequest arg0, ResourceResponse arg1)
			throws PortletException, IOException {
		if ("values".equals(arg0.getResourceID())) {
			arg1.setContentType("text/html");
			PrintWriter out = arg1.getWriter();
			out.println(Arrays.asList(values).toString());
		} else if ("link".equals(arg0.getResourceID())) {
			arg1.setContentType("text/html");
			PrintWriter out = arg1.getWriter();
			out.println("Test dynamickeho URL " + Math.random());
		}
	}
}
