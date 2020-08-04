
<%@ page import="com.test.Files" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'files.label', default: 'Files')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-files" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-files" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list files">
			
				<g:if test="${filesInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="files.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${filesInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.createdOn}">
				<li class="fieldcontain">
					<span id="createdOn-label" class="property-label"><g:message code="files.createdOn.label" default="Created On" /></span>
					
						<span class="property-value" aria-labelledby="createdOn-label"><g:formatDate date="${filesInstance?.createdOn}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.fileContentType}">
				<li class="fieldcontain">
					<span id="fileContentType-label" class="property-label"><g:message code="files.fileContentType.label" default="File Content Type" /></span>
					
						<span class="property-value" aria-labelledby="fileContentType-label"><g:fieldValue bean="${filesInstance}" field="fileContentType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.fileExpirationDate}">
				<li class="fieldcontain">
					<span id="fileExpirationDate-label" class="property-label"><g:message code="files.fileExpirationDate.label" default="File Expiration Date" /></span>
					
						<span class="property-value" aria-labelledby="fileExpirationDate-label"><g:formatDate date="${filesInstance?.fileExpirationDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.fileName}">
				<li class="fieldcontain">
					<span id="fileName-label" class="property-label"><g:message code="files.fileName.label" default="File Name" /></span>
					
						<span class="property-value" aria-labelledby="fileName-label"><g:fieldValue bean="${filesInstance}" field="fileName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.filePath}">
				<li class="fieldcontain">
					<span id="filePath-label" class="property-label"><g:message code="files.filePath.label" default="File Path" /></span>
					
						<span class="property-value" aria-labelledby="filePath-label"><g:fieldValue bean="${filesInstance}" field="filePath"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.fileSize}">
				<li class="fieldcontain">
					<span id="fileSize-label" class="property-label"><g:message code="files.fileSize.label" default="File Size" /></span>
					
						<span class="property-value" aria-labelledby="fileSize-label"><g:fieldValue bean="${filesInstance}" field="fileSize"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.lastModify}">
				<li class="fieldcontain">
					<span id="lastModify-label" class="property-label"><g:message code="files.lastModify.label" default="Last Modify" /></span>
					
						<span class="property-value" aria-labelledby="lastModify-label"><g:fieldValue bean="${filesInstance}" field="lastModify"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.lastModifyOn}">
				<li class="fieldcontain">
					<span id="lastModifyOn-label" class="property-label"><g:message code="files.lastModifyOn.label" default="Last Modify On" /></span>
					
						<span class="property-value" aria-labelledby="lastModifyOn-label"><g:formatDate date="${filesInstance?.lastModifyOn}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${filesInstance?.legalEntityFiles}">
				<li class="fieldcontain">
					<span id="legalEntityFiles-label" class="property-label"><g:message code="files.legalEntityFiles.label" default="Legal Entity Files" /></span>
					
						<g:each in="${filesInstance.legalEntityFiles}" var="l">
						<span class="property-value" aria-labelledby="legalEntityFiles-label"><g:link controller="legalEntityFiles" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${filesInstance?.id}" />
					<g:link class="edit" action="edit" id="${filesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
