
<%@ page import="com.test.LegalEntityFileStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalEntityFileStatus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalEntityFileStatus" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalEntityFileStatus">
			
				<g:if test="${legalEntityFileStatusInstance?.legalEntityFileStatusName}">
				<li class="fieldcontain">
					<span id="legalEntityFileStatusName-label" class="property-label"><g:message code="legalEntityFileStatus.legalEntityFileStatusName.label" default="Legal Entity File Status Name" /></span>
					
						<span class="property-value" aria-labelledby="legalEntityFileStatusName-label"><g:fieldValue bean="${legalEntityFileStatusInstance}" field="legalEntityFileStatusName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityFileStatusInstance?.legalEntityFiles}">
				<li class="fieldcontain">
					<span id="legalEntityFiles-label" class="property-label"><g:message code="legalEntityFileStatus.legalEntityFiles.label" default="Legal Entity Files" /></span>
					
						<g:each in="${legalEntityFileStatusInstance.legalEntityFiles}" var="l">
						<span class="property-value" aria-labelledby="legalEntityFiles-label"><g:link controller="legalEntityFiles" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${legalEntityFileStatusInstance?.id}" />
					<g:link class="edit" action="edit" id="${legalEntityFileStatusInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
