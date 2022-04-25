<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="administrator.system-configuration.form.label.default-system-currency" path="defaultSystemCurrency"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.accepted-currencies" path="acceptedCurrencies"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strong-spam-terms" path="strongSpamTerms"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strong-spam-threshold" path="strongSpamThreshold"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weak-spam-terms" path="weakSpamTerms"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weak-spam-threshold" path="weakSpamThreshold"/>
</acme:form>