
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-moment code="inventor.patronageReport.form.label.creationDate" path="creationDate"/>
	<acme:input-textbox code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
	<acme:input-textbox code="inventor.patronageReport.form.label.serialCode" path="serialCode"/>	
	<acme:input-url code="inventor.patronageReport.form.label.optionalLink" path="optionalLink"/>
</acme:form>

