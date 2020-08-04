<%@ page import="com.test.Modules" %>



<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'chapter', 'error')} required">
	<label for="chapter">
		<g:message code="modules.chapter.label" default="Chapter" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="chapter" name="chapter.id" from="${com.test.Chapters.list()}" optionKey="id" required="" value="${modulesInstance?.chapter?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'entityTypeOrder', 'error')} ">
	<label for="entityTypeOrder">
		<g:message code="modules.entityTypeOrder.label" default="Entity Type Order" />
		
	</label>
	<g:textField name="entityTypeOrder" value="${modulesInstance?.entityTypeOrder}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'iconName', 'error')} ">
	<label for="iconName">
		<g:message code="modules.iconName.label" default="Icon Name" />
		
	</label>
	<g:textField name="iconName" value="${modulesInstance?.iconName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'menuOrderNumber', 'error')} required">
	<label for="menuOrderNumber">
		<g:message code="modules.menuOrderNumber.label" default="Menu Order Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="menuOrderNumber" type="number" value="${modulesInstance.menuOrderNumber}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'modelePath', 'error')} ">
	<label for="modelePath">
		<g:message code="modules.modelePath.label" default="Modele Path" />
		
	</label>
	<g:textField name="modelePath" value="${modulesInstance?.modelePath}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'moduleFiles', 'error')} ">
	<label for="moduleFiles">
		<g:message code="modules.moduleFiles.label" default="Module Files" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${modulesInstance?.moduleFiles?}" var="m">
    <li><g:link controller="moduleFiles" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="moduleFiles" action="create" params="['modules.id': modulesInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles')])}</g:link>
</li>
</ul>

</div>



<div class="fieldcontain ${hasErrors(bean: modulesInstance, field: 'moduleName', 'error')} ">
	<label for="moduleName">
		<g:message code="modules.moduleName.label" default="Module Name" />
		
	</label>
	<g:textField name="moduleName" value="${modulesInstance?.moduleName}"/>
</div>

