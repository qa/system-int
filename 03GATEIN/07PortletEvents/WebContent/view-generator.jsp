<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<portlet:defineObjects/>

<table align="center">
	<c:forEach items="${objects}" var="object">
		<portlet:actionURL name="select" var="select">
			<portlet:param name="name" value="${object.name}" />
		</portlet:actionURL>
		<tr>
			<td align="center">${object.name}</td>
			<td align="center">${object.number}</td>
			<td align="center"><form method="post" action="${select}"><input type="submit" value="Select" /></form></td>
		</tr>
	</c:forEach>
</table>
<br />