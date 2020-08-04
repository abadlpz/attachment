
<%@ page import="com.test.UserDefinedFiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userDefinedFiles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userDefinedFiles" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="allowedFileContentType" title="${message(code: 'userDefinedFiles.allowedFileContentType.label', default: 'Allowed File Content Type')}" />
					
						<g:sortableColumn property="allowedFileExtensions" title="${message(code: 'userDefinedFiles.allowedFileExtensions.label', default: 'Allowed File Extensions')}" />
					
						<g:sortableColumn property="fileName" title="${message(code: 'userDefinedFiles.fileName.label', default: 'File Name')}" />
					
						<g:sortableColumn property="maxFileSize" title="${message(code: 'userDefinedFiles.maxFileSize.label', default: 'Max File Size')}" />
					
						<g:sortableColumn property="maximunRequiredFiles" title="${message(code: 'userDefinedFiles.maximunRequiredFiles.label', default: 'Maximun Required Files')}" />
					
						<g:sortableColumn property="minimunRequiredFiles" title="${message(code: 'userDefinedFiles.minimunRequiredFiles.label', default: 'Minimun Required Files')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userDefinedFilesInstanceList}" status="i" var="userDefinedFilesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userDefinedFilesInstance.id}">${fieldValue(bean: userDefinedFilesInstance, field: "allowedFileContentType")}</g:link></td>
					
						<td>${fieldValue(bean: userDefinedFilesInstance, field: "allowedFileExtensions")}</td>
					
						<td>${fieldValue(bean: userDefinedFilesInstance, field: "fileName")}</td>
					
						<td>${fieldValue(bean: userDefinedFilesInstance, field: "maxFileSize")}</td>
					
						<td>${fieldValue(bean: userDefinedFilesInstance, field: "maximunRequiredFiles")}</td>
					
						<td>${fieldValue(bean: userDefinedFilesInstance, field: "minimunRequiredFiles")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userDefinedFilesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
