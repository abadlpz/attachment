<%@ page import="com.test.ModuleFiles" %>



<div class="fieldcontain ${hasErrors(bean: moduleFilesInstance, field: 'isFileRequired', 'error')} ">
	<label for="isFileRequired">
		<g:message code="moduleFiles.isFileRequired.label" default="Is File Required" />
		
	</label>
	<g:checkBox name="isFileRequired" value="${moduleFilesInstance?.isFileRequired}" />
</div>



<div class="fieldcontain ${hasErrors(bean: moduleFilesInstance, field: 'modules', 'error')} required">
	<label for="modules">
		<g:message code="moduleFiles.modules.label" default="Modules" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="modules" name="modules.id" from="${com.test.Modules.list()}" optionKey="id" required="" value="${moduleFilesInstance?.modules?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: moduleFilesInstance, field: 'userDefinedFiles', 'error')} required">
	<label for="userDefinedFiles">
		<g:message code="moduleFiles.userDefinedFiles.label" default="User Defined Files" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="userDefinedFiles" name="userDefinedFiles.id" from="${com.test.UserDefinedFiles.list()}" optionKey="id" required="" value="${moduleFilesInstance?.userDefinedFiles?.id}" class="many-to-one"/>
</div>

