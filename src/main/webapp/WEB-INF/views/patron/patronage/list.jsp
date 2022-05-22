<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>	
	<acme:list-column code="patron.patronage.list.label.status" path="status" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.code" path="code" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.legalStuff" path="legalStuff" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.budget" path="budget" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.creationDate" path="creationDate" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.startDate" path="startDate" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.finishDate" path="finishDate" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.moreInfo" path="moreInfo" width="10%"/>
	<acme:list-column code="patron.patronage.list.label.published" path="published" width="10%"/>
	
</acme:list>
<acme:button code="patron.patronage.list.button.create" action="/patron/patronage/create"/>
