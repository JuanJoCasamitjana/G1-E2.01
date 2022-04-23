<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="authenticated.system-configuration.form.label.defaultSystemCurrency" path="defaultSystemCurrency" readonly="true"/>
	<acme:input-textbox code="authenticated.system-configuration.form.label.acceptedCurrencies" path="acceptedCurrencies" readonly="true"/>
	
</acme:form>

<acme:link code="authenticated.system-configuration.form.label.money-exchange" action="/authenticated/money-exchange/perform"/>
