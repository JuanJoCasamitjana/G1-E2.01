<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1>
	<acme:message code="administrator.admin-dashboard.form.title"/>
</h1>

<h2>
	<acme:message code="administrator.admin-dashboard.form.components"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.admin-dashboard.form.count-components"/>
		</th>
		<td>
			<acme:print value="${totalNumberComponents}"/>
		</td>
	</tr>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.average-components"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="averageComponents" items="${ averageRetailPriceComponentsByTechnologyAndCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${averageComponents.key.first} | ${averageComponents.key.second}"/>
			</th>
			<td>
				<acme:print value="${averageComponents.value}"/>
			</td>
		</tr>
	</jstl:forEach>

</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.deviation-components"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="deviationComponents" items="${ deviationRetailPriceComponentsByTechnologyAndCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${deviationComponents.key.first} ${deviationComponents.key.second}"/>
			</th>
			<td>
				<acme:print value="${deviationComponents.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.minimum-components"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="minimumComponents" items="${ minimumRetailPriceComponentsByTechnologyAndCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${minimumComponents.key.first} ${minimumComponents.key.second}"/>
			</th>
			<td>
				<acme:print value="${minimumComponents.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.maximum-components"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="maximumComponents" items="${ maximumRetailPriceComponentsByTechnologyAndCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${maximumComponents.key.first} ${maximumComponents.key.second}"/>
			</th>
			<td>
				<acme:print value="${maximumComponents.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h2>
	<acme:message code="administrator.admin-dashboard.form.tools"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.admin-dashboard.form.count-tools"/>
		</th>
		<td>
			<acme:print value="${totalNumberTools}"/>
		</td>
	</tr>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.average-tools"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="averageTools" items="${ averageRetailPriceToolsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${averageTools.key}"/>
			</th>
			<td>
				<acme:print value="${averageTools.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.deviation-tools"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="deviationTools" items="${ deviationRetailPriceToolsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${deviationTools.key}"/>
			</th>
			<td>
				<acme:print value="${deviationTools.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.minimum-tools"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="minimumTools" items="${ minimumRetailPriceToolsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${minimumTools.key}"/>
			</th>
			<td>
				<acme:print value="${minimumTools.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.maximum-tools"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="maximumTools" items="${ maximumRetailPriceToolsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${maximumTools.key}"/>
			</th>
			<td>
				<acme:print value="${maximumTools.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2>
	<acme:message code="administrator.admin-dashboard.form.patronages"/>
</h2>

<h3>
	<acme:message code="administrator.admin-dashboard.form.count-patronages"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="countPatronages" items="${ totalNumberPatronagesOfStatus }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${totalNumberPatronagesOfStatus.key}"/>
			</th>
			<td>
				<acme:print value="${totalNumberPatronagesOfStatus.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.average-patronages"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="averagePatronages" items="${ averageBudgetPatronagesOfStatus }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${averagePatronages.key}"/>
			</th>
			<td>
				<acme:print value="${averagePatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.deviation-patronages"/>
</h3>

<table class="table table-sm">	
	<jstl:forEach var="deviationPatronages" items="${ deviationBudgetPatronagesOfStatus }">
		<tr>	
			<th scope="row">
				<acme:print value=" -- ${deviationPatronages.key}"/>
			</th>
			<td>
				<acme:print value="${deviationPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.minimum-patronages"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="minimumPatronages" items="${ minimumBudgetPatronagesOfStatus }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${minimumPatronages.key}"/>
			</th>
			<td>
				<acme:print value="${minimumPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="administrator.admin-dashboard.form.maximum-patronages"/>
</h3>

<table class="table table-sm">
	<jstl:forEach var="maximumPatronages" items="${ maximumBudgetPatronagesOfStatus }">
		<tr>
			<th scope="row">
				<acme:print value=" -- ${maximumPatronages.key}"/>
			</th>
			<td>
				<acme:print value="${maximumPatronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<acme:return/>

