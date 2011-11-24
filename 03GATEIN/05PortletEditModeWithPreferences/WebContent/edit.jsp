<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="action3" var="action3" />
<form action="${action3}" method="post">
	Update user preference (favourite color): <input name="color" type="text" />
	<input type="submit" value="Update your favourite color" />
</form>
<br />
<span style="color: ${color}">Your favourite color is ${color}.</span>


