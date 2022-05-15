<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="false">
	
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:input-select code="authenticated.announcement.form.label.critical" path="critical">
		<acme:input-option code="CRITICAL" value="true" selected="${critical}"/>
		<acme:input-option code="NOT CRITICAL" value="false" selected="${!critical}"/>
	</acme:input-select>
	<acme:input-textarea code="authenticated.announcement.form.label.body" path="body"/>
	<acme:input-url code="authenticated.announcement.form.label.url" path="optionalLink"/>
	<acme:input-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>
	
	<acme:submit code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
</acme:form>