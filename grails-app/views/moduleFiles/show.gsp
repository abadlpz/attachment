
<%@ page import="com.test.ModuleFiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'moduleFiles.label', default: 'ModuleFiles')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-moduleFiles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-moduleFiles" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list moduleFiles">
			
				<g:if test="${moduleFilesInstance?.isFileRequired}">
				<li class="fieldcontain">
					<span id="isFileRequired-label" class="property-label"><g:message code="moduleFiles.isFileRequired.label" default="Is File Required" /></span>
					
						<span class="property-value" aria-labelledby="isFileRequired-label"><g:formatBoolean boolean="${moduleFilesInstance?.isFileRequired}" /></span>
					
				</li>
				</g:if>
			

				<g:if test="${moduleFilesInstance?.modules}">
				<li class="fieldcontain">
					<span id="modules-label" class="property-label"><g:message code="moduleFiles.modules.label" default="Modules" /></span>
					
						<span class="property-value" aria-labelledby="modules-label"><g:link controller="modules" action="show" id="${moduleFilesInstance?.modules?.id}">${moduleFilesInstance?.modules?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${moduleFilesInstance?.userDefinedFiles}">
				<li class="fieldcontain">
					<span id="userDefinedFiles-label" class="property-label"><g:message code="moduleFiles.userDefinedFiles.label" default="User Defined Files" /></span>
					
						<span class="property-value" aria-labelledby="userDefinedFiles-label"><g:link controller="userDefinedFiles" action="show" id="${moduleFilesInstance?.userDefinedFiles?.id}">${moduleFilesInstance?.userDefinedFiles?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${moduleFilesInstance?.id}" />
					<g:link class="edit" action="edit" id="${moduleFilesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
