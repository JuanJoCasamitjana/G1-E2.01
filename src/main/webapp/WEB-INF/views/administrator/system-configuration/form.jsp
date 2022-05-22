<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<acme:form>
	<acme:input-textbox code="administrator.system-configuration.form.label.default-system-currency" path="defaultSystemCurrency" readonly="${readOnly}"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.accepted-currencies" path="acceptedCurrencies" readonly="${readOnly}"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strong-spam-terms" path="strongSpamTerms" readonly="${readOnly}"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strong-spam-threshold" path="strongSpamThreshold" readonly="${readOnly}"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weak-spam-terms" path="weakSpamTerms" readonly="${readOnly}"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weak-spam-threshold" path="weakSpamThreshold" readonly="${readOnly}"/>
	<acme:submit code="administrator.system-configuration.submit.label.update" action="/administrator/system-configuration/update"/>
</acme:form>