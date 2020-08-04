<%@ page import="com.test.UserDefinedFiles" %>



<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'allowedFileContentType', 'error')} ">
	<label for="allowedFileContentType">
		<g:message code="userDefinedFiles.allowedFileContentType.label" default="Allowed File Content Type" />
		
	</label>
	<g:textField name="allowedFileContentType" value="${userDefinedFilesInstance?.allowedFileContentType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'allowedFileExtensions', 'error')} ">
	<label for="allowedFileExtensions">
		<g:message code="userDefinedFiles.allowedFileExtensions.label" default="Allowed File Extensions" />
		
	</label>
	<g:textField name="allowedFileExtensions" value="${userDefinedFilesInstance?.allowedFileExtensions}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'fileName', 'error')} ">
	<label for="fileName">
		<g:message code="userDefinedFiles.fileName.label" default="File Name" />
		
	</label>
	<g:textField name="fileName" value="${userDefinedFilesInstance?.fileName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'maxFileSize', 'error')} required">
	<label for="maxFileSize">
		<g:message code="userDefinedFiles.maxFileSize.label" default="Max File Size" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxFileSize" type="number" value="${userDefinedFilesInstance.maxFileSize}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'maximunRequiredFiles', 'error')} ">
	<label for="maximunRequiredFiles">
		<g:message code="userDefinedFiles.maximunRequiredFiles.label" default="Maximun Required Files" />
		
	</label>
	<g:textField name="maximunRequiredFiles" value="${userDefinedFilesInstance?.maximunRequiredFiles}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'minimunRequiredFiles', 'error')} ">
	<label for="minimunRequiredFiles">
		<g:message code="userDefinedFiles.minimunRequiredFiles.label" default="Minimun Required Files" />
		
	</label>
	<g:textField name="minimunRequiredFiles" value="${userDefinedFilesInstance?.minimunRequiredFiles}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userDefinedFilesInstance, field: 'moduleFiles', 'error')} ">
	<label for="moduleFiles">
		<g:message code="userDefinedFiles.moduleFiles.label" default="Module Files" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userDefinedFilesInstance?.moduleFiles?}" var="m">
    <li><g:link controller="moduleFiles" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="moduleFiles" action="create" params="['userDefinedFiles.id': userDefinedFilesInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles')])}</g:link>
</li>
</ul>

</div>


