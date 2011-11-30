<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="action1" var="action1" />
<form action="${action1}" method="post">
	Enter your name: <input name="username" type="text" />
	<br />
	<input type="submit" value="Say Hello" />
</form>