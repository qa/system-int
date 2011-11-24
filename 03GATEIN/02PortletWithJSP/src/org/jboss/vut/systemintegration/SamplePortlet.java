package org.jboss.vut.systemintegration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.UnavailableException;

public class SamplePortlet extends GenericPortlet {

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException, UnavailableException {
		response.setContentType("text/html");
		String jspPath = "/view.jsp";
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(jspPath);
		prd.include(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, PortletSecurityException, IOException {
		// TODO Auto-generated method stub
		super.doEdit(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, PortletSecurityException, IOException {
		// TODO Auto-generated method stub
		super.processAction(request, response);
	}
}
