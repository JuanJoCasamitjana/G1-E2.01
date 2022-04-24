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
	<acme:input-textbox code="any.tool-kit.form.label.code" path="code"/>
	<acme:input-textbox code="any.tool-kit.form.label.title" path="title"/>
	<acme:input-textbox code="any.tool-kit.form.label.description" path="description"/>
	<acme:input-textbox code="any.tool-kit.form.label.assembly-notes" path="assemblyNotes"/>
	<jstl:if test="${optionalLink!=null}">
		<acme:input-textbox code="any.tool-kit.form.label.optional-link" path="optionalLink"/>
	</jstl:if>
	<jstl:forEach var="tool" items="toolKitTools">
		<acme:box code="any.tool-kit.form.label.tool">
			<acme:input-textbox code="any.tool-kit.form.label.item-name" path="tool.item.name"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-code" path="tool.item.code"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-technology" path="tool.item.technology"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-description" path="tool.item.description"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-retail-price" path="tool.item.retailPrice"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-optional-link" path="tool.item.optionalLink"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-amount" path="tool.amount"/>
		</acme:box>
	</jstl:forEach>
	<jstl:forEach var="component" items="toolKitComponents">
		<jstl:set var="comp" value="component"/>
		<acme:box code="any.tool-kit.form.label.component">
			<acme:input-textbox code="any.tool-kit.form.label.item-name" path="comp"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-code" path="comp.item.code"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-technology" path="comp.item.technology"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-description" path="comp.item.description"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-retail-price" path="comp.item.retailPrice"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-optional-link" path="comp.item.optionalLink"/>
			<acme:input-textbox code="any.tool-kit.form.label.item-amount" path="comp.amount"/>
		</acme:box>
	</jstl:forEach>
	
</acme:form>
