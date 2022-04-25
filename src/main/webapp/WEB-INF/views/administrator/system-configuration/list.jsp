
<%--
- list.jsp
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

<acme:list readonly="true">
	<acme:list-column code="administrator.system-configuration.list.label.accepted-currencies" path="acceptedCurrencies"/>
	<acme:list-column code="administrator.system-configuration.list.label.system-currency" path="defaultSystemCurrency"/>
	<acme:list-column code="administrator.system-configuration.list.label.strong-spam-term" path="strongSpamTerms"/>
	<acme:list-column code="administrator.system-configuration.list.label.strong-spam-threshold" path="strongSpamThreshold"/>
	<acme:list-column code="administrator.system-configuration.list.label.weak-spam-term" path="weakSpamTerms"/>
	<acme:list-column code="administrator.system-configuration.list.label.weak-spam-threshold" path="weakSpamThreshold"/>
</acme:list>
