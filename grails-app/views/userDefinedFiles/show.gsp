
<%@ page import="com.test.UserDefinedFiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userDefinedFiles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userDefinedFiles" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list userDefinedFiles">
			
				<g:if test="${userDefinedFilesInstance?.allowedFileContentType}">
				<li class="fieldcontain">
					<span id="allowedFileContentType-label" class="property-label"><g:message code="userDefinedFiles.allowedFileContentType.label" default="Allowed File Content Type" /></span>
					
						<span class="property-value" aria-labelledby="allowedFileContentType-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="allowedFileContentType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.allowedFileExtensions}">
				<li class="fieldcontain">
					<span id="allowedFileExtensions-label" class="property-label"><g:message code="userDefinedFiles.allowedFileExtensions.label" default="Allowed File Extensions" /></span>
					
						<span class="property-value" aria-labelledby="allowedFileExtensions-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="allowedFileExtensions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.fileName}">
				<li class="fieldcontain">
					<span id="fileName-label" class="property-label"><g:message code="userDefinedFiles.fileName.label" default="File Name" /></span>
					
						<span class="property-value" aria-labelledby="fileName-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="fileName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.maxFileSize}">
				<li class="fieldcontain">
					<span id="maxFileSize-label" class="property-label"><g:message code="userDefinedFiles.maxFileSize.label" default="Max File Size" /></span>
					
						<span class="property-value" aria-labelledby="maxFileSize-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="maxFileSize"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.maximunRequiredFiles}">
				<li class="fieldcontain">
					<span id="maximunRequiredFiles-label" class="property-label"><g:message code="userDefinedFiles.maximunRequiredFiles.label" default="Maximun Required Files" /></span>
					
						<span class="property-value" aria-labelledby="maximunRequiredFiles-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="maximunRequiredFiles"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.minimunRequiredFiles}">
				<li class="fieldcontain">
					<span id="minimunRequiredFiles-label" class="property-label"><g:message code="userDefinedFiles.minimunRequiredFiles.label" default="Minimun Required Files" /></span>
					
						<span class="property-value" aria-labelledby="minimunRequiredFiles-label"><g:fieldValue bean="${userDefinedFilesInstance}" field="minimunRequiredFiles"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userDefinedFilesInstance?.moduleFiles}">
				<li class="fieldcontain">
					<span id="moduleFiles-label" class="property-label"><g:message code="userDefinedFiles.moduleFiles.label" default="Module Files" /></span>
					
						<g:each in="${userDefinedFilesInstance.moduleFiles}" var="m">
						<span class="property-value" aria-labelledby="moduleFiles-label"><g:link controller="moduleFiles" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>

			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userDefinedFilesInstance?.id}" />
					<g:link class="edit" action="edit" id="${userDefinedFilesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
