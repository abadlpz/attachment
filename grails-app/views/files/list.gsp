
<%@ page import="com.test.Files" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'files.label', default: 'Files')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-files" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-files" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="createdBy" title="${message(code: 'files.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="createdOn" title="${message(code: 'files.createdOn.label', default: 'Created On')}" />
					
						<g:sortableColumn property="fileContentType" title="${message(code: 'files.fileContentType.label', default: 'File Content Type')}" />
					
						<g:sortableColumn property="fileExpirationDate" title="${message(code: 'files.fileExpirationDate.label', default: 'File Expiration Date')}" />
					
						<g:sortableColumn property="fileName" title="${message(code: 'files.fileName.label', default: 'File Name')}" />
					
						<g:sortableColumn property="filePath" title="${message(code: 'files.filePath.label', default: 'File Path')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${filesInstanceList}" status="i" var="filesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${filesInstance.id}">${fieldValue(bean: filesInstance, field: "createdBy")}</g:link></td>
					
						<td><g:formatDate date="${filesInstance.createdOn}" /></td>
					
						<td>${fieldValue(bean: filesInstance, field: "fileContentType")}</td>
					
						<td><g:formatDate date="${filesInstance.fileExpirationDate}" /></td>
					
						<td>${fieldValue(bean: filesInstance, field: "fileName")}</td>
					
						<td>${fieldValue(bean: filesInstance, field: "filePath")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${filesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
