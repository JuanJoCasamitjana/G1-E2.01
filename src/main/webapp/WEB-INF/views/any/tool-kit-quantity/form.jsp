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

<acme:form>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.name" path="item.name" readonly="true"/>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.type" path="item.type" readonly="true"/>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.code" path="item.code" readonly="true"/>	
	<acme:input-textbox code="any.tool-kit-quantity.form.label.technology" path="item.technology" readonly="true"/>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.description" path="item.description" readonly="true"/>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.retail-price" path="item.retailPrice" readonly="true"/>
	<acme:input-textbox code="any.tool-kit-quantity.form.label.amount" path="amount" readonly="true"/>
	<jstl:if test="${optionalLink!=null}">
		<acme:input-textbox code="any.tool-kit-quantity.form.label.optional-link" path="item.optionalLink"/>
	</jstl:if>
	
	<acme:button code="any.tool-kit-quantity.form.label.button" action="/any/tool-kit/list-filter?id=${item.id}"/>
	
</acme:form>
