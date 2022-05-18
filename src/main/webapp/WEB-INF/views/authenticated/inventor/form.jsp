<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="authenticated.inventor.inventor.form.label.company" path="company"/>
	<acme:input-textbox code="authenticated.inventor.inventor.form.label.statement" path="statement"/>
	<acme:input-url code="authenticated.inventor.inventor.form.label.info" path="info"/>
	
	<acme:submit test="${command == 'create'}" code="authenticated.inventor.inventor.form.button.create" action="/authenticated/inventor/create"/>
	<acme:submit test="${command == 'update'}" code="authenticated.inventor.inventor.form.button.update" action="/authenticated/inventor/update"/>
</acme:form>
