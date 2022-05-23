
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}">
	
	<acme:input-moment code="inventor.patronageReport.form.label.creationDate" path="creationDate" readonly="true"/>
	<acme:input-textbox code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronageReport.form.label.optionalLink" path="optionalLink"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="inventor.patronageReport.form.label.patronage" path="patronage">
				<jstl:forEach items="${ patronages }" var="patronageSelected">
					<acme:input-option code="${patronageSelected.code}" value="${patronageSelected.code}"/>
				</jstl:forEach>
			</acme:input-select>
			<acme:input-checkbox code="inventor.patronageReport.form.label.confirmation" path="confirmation"/>
			<acme:submit code="inventor.patronageReport.form.button.create" action="/inventor/patronage-report/create"/>
		</jstl:when>
		<jstl:when test="${command == 'show'}">
			<acme:input-textbox code="inventor.patronageReport.form.label.patronage" path="patronage"/>
			<acme:input-textbox code="inventor.patronageReport.form.label.serialCode" path="serialCode"/>		
		</jstl:when>			
	</jstl:choose>	

</acme:form>

