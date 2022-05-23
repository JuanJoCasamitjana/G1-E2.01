<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>	
	<acme:list-column code="inventor.toolKit.list.label.code" path="code"/>
	<acme:list-column code="inventor.toolKit.list.label.title" path="title"/>
	<acme:list-column code="inventor.toolKit.list.label.published" path="published"/>
</acme:list>

<acme:button code="inventor.toolKit.list.label.create" action="/inventor/tool-kit/create"/>
