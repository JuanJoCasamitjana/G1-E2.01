<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.announcement.list.label.moment" path="creationMoment" width="20%"/>
	<acme:list-column code="authenticated.announcement.list.label.status" path="critical" width="10%"/>
	<acme:list-column code="authenticated.announcement.list.label.critical" path="title" width="70%"/>
</acme:list>