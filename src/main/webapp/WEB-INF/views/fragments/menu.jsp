<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.roles.Provider,acme.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.victor" action="https://youtu.be/dQw4w9WgXcQ"/>
			<acme:menu-suboption code="master.menu.anonymous.77929136F" action="https://www.youtube.com/watch?v=dQw4w9WgXcQ"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-juacasben" action="https://www.reddit.com/r/badfoodporn/comments/g7y69z/made_my_wife_a_derpy_dragon_with_her_bday_waffles/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-andvarbay" action="https://www.youtube.com/watch?v=0iCtC-EOzEo"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-danenrdia" action="https://discord.com"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/tool-kit/list"/>
			<acme:menu-suboption code="master.menu.any.components" action="/any/item/list-component"/>
			<acme:menu-suboption code="master.menu.any.tools" action="/any/item/list-tool"/>
			<acme:menu-suboption code="master.menu.any.chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.announcements" action="/authenticated/announcement/listRecent"/>
			<acme:menu-suboption code="master.menu.authenticated.system-configuration" action="/authenticated/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/tool-kit/list"/>
			<acme:menu-suboption code="master.menu.any.components" action="/any/item/list-component"/>
			<acme:menu-suboption code="master.menu.any.tools" action="/any/item/list-tool"/>
			<acme:menu-suboption code="master.menu.any.chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
			<acme:menu-suboption code="master.menu.inventor.components" action="/inventor/item/list-component"/>
			<acme:menu-suboption code="master.menu.inventor.tools" action="/inventor/item/list-tool"/>
			<acme:menu-suboption code="master.menu.inventor.patronage" action="/inventor/patronage/list"/>
			<acme:menu-suboption code="master.menu.inventor.patronage-reports" action="/inventor/patronage-report/list"/>
			<acme:menu-suboption code="master.menu.inventor.toolkits" action="/inventor/tool-kit/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.patronage" action="/patron/patronage/list"/>
			<acme:menu-suboption code="master.menu.patron.patronage-report" action="/patron/patronage-report/list"/>
			<acme:menu-suboption code="master.menu.patron.patron-dashboard" action="/patron/patron-dashboard/show"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.system-configuration" action="/administrator/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.admin-dashboard" action="/administrator/admin-dashboard/show"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.authenticated.announcement.list" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

