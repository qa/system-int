<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui-1.8.16.custom.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var values = ['ajax', 'java'];
	$.get('<portlet:resourceURL id="values" />', function(data) {
		values = data;
		$("#values").autocomplete({
			source : values.substring(1, values.length-1).split(",")
		});	
	});
});
</script>

Start typing your favourite programming language: <input id="values" type="text" />

<br />
<br />
<a href="<portlet:resourceURL id='link'/>">Resouce URL sample</a>