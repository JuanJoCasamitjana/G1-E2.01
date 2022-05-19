<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>	
	<acme:list-column code="inventor.patronageReport.list.label.creationDate" path="creationDate" width="25%"/>
	<acme:list-column code="inventor.patronageReport.list.label.memorandum" path="memorandum" width="25%"/>
	<acme:list-column code="inventor.patronageReport.list.label.serialCode" path="serialCode" width="25%"/>
	<acme:list-column code="inventor.patronageReport.list.label.optionalLink" path="optionalLink" width="25%"/>
</acme:list>

<acme:button code="inventor.patronageReport.list.button.create" action="/inventor/patronage-report/create"/>