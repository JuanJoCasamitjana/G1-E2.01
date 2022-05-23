<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-select code="inventor.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="IMPORTANT" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.patronage.form.label.code" path="code" readonly="true"/>
	<acme:input-textbox code="inventor.patronage.form.label.legalStuff" path="legalStuff" readonly="true"/>	
	<acme:input-money code="inventor.patronage.form.label.budget" path="budget" readonly="true"/>
	<acme:input-moment code="inventor.patronage.form.label.creationDate" path="creationDate" readonly="true"/>
	<acme:input-moment code="inventor.patronage.form.label.startDate" path="startDate" readonly="true"/>
	<acme:input-moment code="inventor.patronage.form.label.finishDate" path="finishDate" readonly="true"/>
	<acme:input-url code="inventor.patronage.form.label.moreInfo" path="moreInfo" readonly="true"/>
	<acme:input-checkbox code="inventor.patronage.form.label.published" path="published" readonly="true"/>
	
	<acme:button code="inventor.patronage.form.button.patron" action="/any/user-account/show?id=${patronId}"/>
	
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update') && published == true && status == 'PROPOSED'}">
			<acme:submit code="inventor.patronage.form.button.update" action="/inventor/patronage/update"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>

