package org.jboss.vut.systemintegration;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSecurityException;
import javax.portlet.ProcessAction;
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
		String username = request.getParameter("usernameFromAction");
		request.setAttribute("usernameFromDoView", username);
		String jspPath = (username != null && !username.isEmpty()) ? "/hello.jsp" : "/view.jsp";
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(jspPath);
		prd.include(request, response);
	}
	
	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException, UnavailableException {
		response.setContentType("text/html");
		String color = request.getPreferences().getValue("color", "black");
		request.setAttribute("color", color);
		String jspPath = "/edit.jsp";
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(jspPath);
		prd.include(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, PortletSecurityException, IOException {
		String jspPath = "/help.jsp";
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(jspPath);
		prd.include(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@ProcessAction(name="action1")
	public void processAction1(ActionRequest request, ActionResponse response)
			throws PortletException, PortletSecurityException, IOException {
		String username = request.getParameter("username");
		response.setRenderParameter("usernameFromAction", username);
	}
	
	@ProcessAction(name="action2")
	public void processAction2(ActionRequest request, ActionResponse response)
			throws PortletException, PortletSecurityException, IOException {
		response.setPortletMode(PortletMode.VIEW);
	}
	
	@ProcessAction(name="action3")
	public void processAction3(ActionRequest request, ActionResponse response)
			throws PortletException, PortletSecurityException, IOException {
		String color = request.getParameter("color");
		if (color != null && !color.isEmpty()) {
			PortletPreferences preferences = request.getPreferences();
			preferences.setValue("color", color);
			preferences.store();
		}
	}
}
