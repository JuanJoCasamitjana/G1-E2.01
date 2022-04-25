<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1>
	<acme:message code="patron.patron-dashboard.form.title"/>
</h1>

<h3>
	<acme:message code="patron.patron-dashboard.form.count-patronages"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="patron.patron-dashboard.form.count-patronages-caption"/>
	</caption>
	<jstl:forEach var="countPatronages" items="${ totalNumberPatronagesOfStatus }">
		<tr>
			<th scope="row">
				<acme:print value=" - ${countPatronages.key}"/>
			</th>
			<td>
				<acme:print value="${countPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>

</table>

<h3>
	<acme:message code="patron.patron-dashboard.form.average-patronages"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="patron.patron-dashboard.form.average-patronages-caption"/>
	</caption>
	<jstl:forEach var="averagePatronages" items="${ averageBudgetPatronagesOfStatusByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" - ${averagePatronages.key.first} | ${averagePatronages.key.second}"/>
			</th>
			<td>
				<acme:print value="${averagePatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="patron.patron-dashboard.form.deviation-patronages"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="patron.patron-dashboard.form.deviation-patronages-caption"/>
	</caption>
	<jstl:forEach var="deviationPatronages" items="${ deviationBudgetPatronagesOfStatusByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" - ${deviationPatronages.key.first} | ${deviationPatronages.key.second}"/>
			</th>
			<td>
				<acme:print value="${deviationPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="patron.patron-dashboard.form.minimum-patronages"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="patron.patron-dashboard.form.minimum-patronages-caption"/>
	</caption>
	<jstl:forEach var="minimumPatronages" items="${ minimumBudgetPatronagesOfStatusByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" - ${minimumPatronages.key.first} | ${minimumPatronages.key.second}"/>
			</th>
			<td>
				<acme:print value="${minimumPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="patron.patron-dashboard.form.maximum-patronages"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="patron.patron-dashboard.form.maximum-patronages-caption"/>
	</caption>
	<jstl:forEach var="maximumPatronages" items="${ maximumBudgetPatronagesOfStatusByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" - ${maximumPatronages.key.first} | ${maximumPatronages.key.second}"/>
			</th>
			<td>
				<acme:print value="${maximumPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<acme:return/>

