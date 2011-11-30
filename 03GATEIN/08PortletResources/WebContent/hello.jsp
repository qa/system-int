<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<h1>Hello ${usernameFromDoView}!</h1> (from EL expression)

<br />

<h1>Hello <%= renderRequest.getAttribute("usernameFromDoView") %>!</h1> (from scriptlet)

<br /><br />
<a href="<portlet:renderURL><portlet:param name="usernameFromAction" value="empty"/></portlet:renderURL>">Back to first page...</a>

