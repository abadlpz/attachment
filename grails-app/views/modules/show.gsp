
<%@ page import="com.test.Modules" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'modules.label', default: 'Modules')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-modules" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-modules" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list modules">
			
				<g:if test="${modulesInstance?.chapter}">
				<li class="fieldcontain">
					<span id="chapter-label" class="property-label"><g:message code="modules.chapter.label" default="Chapter" /></span>
					
						<span class="property-value" aria-labelledby="chapter-label"><g:link controller="chapters" action="show" id="${modulesInstance?.chapter?.id}">${modulesInstance?.chapter?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.entityTypeOrder}">
				<li class="fieldcontain">
					<span id="entityTypeOrder-label" class="property-label"><g:message code="modules.entityTypeOrder.label" default="Entity Type Order" /></span>
					
						<span class="property-value" aria-labelledby="entityTypeOrder-label"><g:fieldValue bean="${modulesInstance}" field="entityTypeOrder"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.iconName}">
				<li class="fieldcontain">
					<span id="iconName-label" class="property-label"><g:message code="modules.iconName.label" default="Icon Name" /></span>
					
						<span class="property-value" aria-labelledby="iconName-label"><g:fieldValue bean="${modulesInstance}" field="iconName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.menuOrderNumber}">
				<li class="fieldcontain">
					<span id="menuOrderNumber-label" class="property-label"><g:message code="modules.menuOrderNumber.label" default="Menu Order Number" /></span>
					
						<span class="property-value" aria-labelledby="menuOrderNumber-label"><g:fieldValue bean="${modulesInstance}" field="menuOrderNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.modelePath}">
				<li class="fieldcontain">
					<span id="modelePath-label" class="property-label"><g:message code="modules.modelePath.label" default="Modele Path" /></span>
					
						<span class="property-value" aria-labelledby="modelePath-label"><g:fieldValue bean="${modulesInstance}" field="modelePath"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.moduleFiles}">
				<li class="fieldcontain">
					<span id="moduleFiles-label" class="property-label"><g:message code="modules.moduleFiles.label" default="Module Files" /></span>
					
						<g:each in="${modulesInstance.moduleFiles}" var="m">
						<span class="property-value" aria-labelledby="moduleFiles-label"><g:link controller="moduleFiles" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.moduleFilesDependencies}">
				<li class="fieldcontain">
					<span id="moduleFilesDependencies-label" class="property-label"><g:message code="modules.moduleFilesDependencies.label" default="Module Files Dependencies" /></span>
					
						<g:each in="${modulesInstance.moduleFilesDependencies}" var="m">
						<span class="property-value" aria-labelledby="moduleFilesDependencies-label"><g:link controller="moduleFilesDependency" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${modulesInstance?.moduleName}">
				<li class="fieldcontain">
					<span id="moduleName-label" class="property-label"><g:message code="modules.moduleName.label" default="Module Name" /></span>
					
						<span class="property-value" aria-labelledby="moduleName-label"><g:fieldValue bean="${modulesInstance}" field="moduleName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${modulesInstance?.id}" />
					<g:link class="edit" action="edit" id="${modulesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
