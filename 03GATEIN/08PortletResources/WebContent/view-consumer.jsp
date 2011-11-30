<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<portlet:defineObjects/>

<c:choose>
	<c:when test='${empty object}'>
	<br />
		Please select object at Generator portlet to see if eventing with object works.<br />
	</c:when>
	<c:otherwise>
		You have selected following object: <br /><br />
		<b>${object.name}, ${object.number}</b>
		<br />
		<br />
		<portlet:actionURL name="clean" var="clean" />
		<form method="post" action="${clean}">
			<input type="submit" value="Clear selection">
		</form>
	</c:otherwise>
</c:choose>