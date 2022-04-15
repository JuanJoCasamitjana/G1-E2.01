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

<acme:form readonly="true">
	<acme:input-select code="inventor.patronage.list.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="IMPORTANT" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.patronage.list.label.code" path="code"/>
	<acme:input-textbox code="inventor.patronage.list.label.legalStuff" path="legalStuff"/>	
	<acme:input-money code="inventor.patronage.list.label.budget" path="budget"/>
	<acme:input-moment code="inventor.patronage.list.label.creationDate" path="creationDate"/>
	<acme:input-moment code="inventor.patronage.list.label.startDate" path="startDate"/>
	<acme:input-moment code="inventor.patronage.list.label.finishDate" path="finishDate"/>
	<acme:input-url code="inventor.patronage.list.label.moreInfo" path="moreInfo"/>
</acme:form>

