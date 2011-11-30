package org.jboss.vut.systemintegration;

import java.io.IOException;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class EventConsumer extends GenericPortlet {

	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html");
		DummyObject object = (DummyObject) request.getPortletSession().getAttribute("object");
		request.setAttribute("object", object);
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher("/view-consumer.jsp");
		dispatcher.include(request, response);
	}

	@Override
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		DummyObject object = (DummyObject) request.getEvent().getValue();
		request.getPortletSession().setAttribute("object", object);
	}
}
