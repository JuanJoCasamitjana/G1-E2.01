<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-select code="any.item.form.label.type" path="type">
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${type == 'COMPONENT'}"/>
		<acme:input-option code="TOOL" value="TOOL" selected="${type == 'TOOL'}"/>
	</acme:input-select>
	<acme:input-textbox code="any.item.form.label.name" path="name"/>
	<acme:input-textbox code="any.item.form.label.code" path="code"/>	
	<acme:input-textbox code="any.item.form.label.technology" path="technology"/>
	<acme:input-textbox code="any.item.form.label.description" path="description"/>
	<acme:input-money code="any.item.form.label.retailPrice" path="retailPrice"/>
	<acme:input-textbox code="any.item.form.label.optionalLink" path="optionalLink"/>
	<acme:input-textbox code="any.item.form.label.published" path="published"/>
</acme:form>
