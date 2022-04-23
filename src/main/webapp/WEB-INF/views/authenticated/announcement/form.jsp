<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags" %>

<acme:form readonly="true">
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:input-select code="authenticated.announcement.form.label.critical" path="critical">
		<acme:input-option code="CRITICAL" value="CRITICAL" selected="${critical}"/>
		<acme:input-option code="NOT CRITICAL" value="NOT CRITICAL" selected="${!critical}"/>
	</acme:input-select>
	<acme:input-textarea code="authenticated.announcement.form.label.body" path="body"/>
	<acme:input-url code="authenticated.announcement.form.label.url" path="optionalLink"/>
</acme:form>