package org.jboss.vut.systemintegration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.UnavailableException;
import javax.xml.namespace.QName;

public class EventGenerator extends GenericPortlet {

	private List<DummyObject> objects;

	@Override
	public void init() throws PortletException {
		super.init();
		objects = new ArrayList<DummyObject>();
		objects.add(new DummyObject("hruska", 1));
		objects.add(new DummyObject("jablko", 10));
		objects.add(new DummyObject("meloun", 5));
	}

	public DummyObject getTestObjectByName(String name) {
		for (DummyObject object : objects) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException, UnavailableException {
		response.setContentType("text/html");
		request.setAttribute("objects", objects);
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher("/view-generator.jsp");
		dispatcher.include(request, response);
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String name = request.getParameter("name");
		response.setEvent(new QName("urn:jboss:gatein:samples:event:object", "eventObject"), getTestObjectByName(name));
	}
}
