<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-select code="any.item.form.label.type" path="type" readonly="">
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${type == 'COMPONENT'}"/>
		<acme:input-option code="TOOL" value="TOOL" selected="${type == 'TOOL'}"/>
	</acme:input-select>
	<acme:input-textbox code="any.item.form.label.name" path="name" readonly="true"/>
	<acme:input-textbox code="any.item.form.label.code" path="code" readonly="true"/>	
	<acme:input-textbox code="any.item.form.label.technology" path="technology" readonly="true"/>
	<acme:input-textbox code="any.item.form.label.description" path="description" readonly="true"/>
	<acme:input-money code="any.item.form.label.retailPrice" path="retailPrice" readonly="true"/>
	<acme:input-textbox code="any.item.form.label.optionalLink" path="optionalLink" readonly="true"/>
	<acme:input-textbox code="any.item.form.label.published" path="published" readonly="true"/>
	
	<acme:link code="any.item.form.label.tool-kit-filter" action="/any/tool-kit/list-filter?id=${ id }"/>
</acme:form>
