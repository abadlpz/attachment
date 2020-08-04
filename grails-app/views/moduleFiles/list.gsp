
<%@ page import="com.test.ModuleFiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'moduleFiles.label', default: 'ModuleFiles')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-moduleFiles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-moduleFiles" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="isFileRequired" title="${message(code: 'moduleFiles.isFileRequired.label', default: 'Is File Required')}" />
					
						<th><g:message code="moduleFiles.modules.label" default="Modules" /></th>
					
						<th><g:message code="moduleFiles.userDefinedFiles.label" default="User Defined Files" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${moduleFilesInstanceList}" status="i" var="moduleFilesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${moduleFilesInstance.id}">${fieldValue(bean: moduleFilesInstance, field: "isFileRequired")}</g:link></td>
					
						<td>${fieldValue(bean: moduleFilesInstance, field: "modules")}</td>
					
						<td>${fieldValue(bean: moduleFilesInstance, field: "userDefinedFiles")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${moduleFilesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
