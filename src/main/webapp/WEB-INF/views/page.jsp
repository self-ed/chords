<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<tilesx:useAttribute name="title"/>
		<s:message code="${title}" text=""/>
	</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/main.css" />" />
	<script type="text/javascript" src="<c:url value="/resources/jquery-1.6.4.js" />"></script>
	<tiles:insertAttribute name="head" flush="true" />
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>