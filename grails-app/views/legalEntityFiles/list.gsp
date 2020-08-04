
<%@ page import="com.test.LegalEntityFiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalEntityFiles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalEntityFiles" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="createdBy" title="${message(code: 'legalEntityFiles.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="createdOn" title="${message(code: 'legalEntityFiles.createdOn.label', default: 'Created On')}" />
					
						<th><g:message code="legalEntityFiles.file.label" default="File" /></th>
					
						<th><g:message code="legalEntityFiles.legalEntityFileStatus.label" default="Legal Entity File Status" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalEntityFilesInstanceList}" status="i" var="legalEntityFilesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalEntityFilesInstance.id}">${fieldValue(bean: legalEntityFilesInstance, field: "createdBy")}</g:link></td>
					
						<td><g:formatDate date="${legalEntityFilesInstance.createdOn}" /></td>
					
						<td>${fieldValue(bean: legalEntityFilesInstance, field: "file")}</td>
					
						<td>${fieldValue(bean: legalEntityFilesInstance, field: "legalEntityFileStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalEntityFilesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
