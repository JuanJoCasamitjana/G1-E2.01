<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}">
	<acme:input-textbox code="inventor.toolKit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolKit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolKit.form.label.description" path="description"/>
	<acme:input-textbox code="inventor.toolKit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="inventor.toolKit.form.label.optionalLink" path="optionalLink"/>
	<acme:hidden-data path="published"/>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && !published}">
			<acme:button code="inventor.toolKit.form.button.edit-items" action="/inventor/quantity/list?toolKitId=${id}"/>
			<acme:submit code="inventor.toolKit.form.button.update" action="/inventor/tool-kit/update"/>
			<acme:submit code="inventor.toolKit.form.button.delete" action="/inventor/tool-kit/delete"/>
			<acme:submit code="inventor.toolKit.form.button.publish" action="/inventor/tool-kit/publish"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.toolKit.form.button.create" action="/inventor/tool-kit/create"/>
		</jstl:when>
	</jstl:choose>
</acme:form>

