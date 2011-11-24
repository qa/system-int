<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<c:set value="<%= renderRequest.getRemoteUser() %>" var="user"></c:set>
<c:choose>
	<c:when test="${empty user}">
		You are currently not signed in portal.
	</c:when>
	<c:otherwise>
		You are signed in as ${user}.
	</c:otherwise>
</c:choose>

<br /><br />
<a href="<portlet:actionURL name="action2"/>">Switch back to VIEW mode.</a>

