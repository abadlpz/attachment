<%@ page import="com.test.Files" %>



<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="files.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${filesInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'createdOn', 'error')} required">
	<label for="createdOn">
		<g:message code="files.createdOn.label" default="Created On" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdOn" precision="day"  value="${filesInstance?.createdOn}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'fileContentType', 'error')} ">
	<label for="fileContentType">
		<g:message code="files.fileContentType.label" default="File Content Type" />
		
	</label>
	<g:textField name="fileContentType" value="${filesInstance?.fileContentType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'fileExpirationDate', 'error')} required">
	<label for="fileExpirationDate">
		<g:message code="files.fileExpirationDate.label" default="File Expiration Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fileExpirationDate" precision="day"  value="${filesInstance?.fileExpirationDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'fileName', 'error')} ">
	<label for="fileName">
		<g:message code="files.fileName.label" default="File Name" />
		
	</label>
	<g:textField name="fileName" value="${filesInstance?.fileName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'filePath', 'error')} ">
	<label for="filePath">
		<g:message code="files.filePath.label" default="File Path" />
		
	</label>
	<g:textField name="filePath" value="${filesInstance?.filePath}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'fileSize', 'error')} ">
	<label for="fileSize">
		<g:message code="files.fileSize.label" default="File Size" />
		
	</label>
	<g:textField name="fileSize" value="${filesInstance?.fileSize}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'lastModify', 'error')} ">
	<label for="lastModify">
		<g:message code="files.lastModify.label" default="Last Modify" />
		
	</label>
	<g:textField name="lastModify" value="${filesInstance?.lastModify}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'lastModifyOn', 'error')} required">
	<label for="lastModifyOn">
		<g:message code="files.lastModifyOn.label" default="Last Modify On" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastModifyOn" precision="day"  value="${filesInstance?.lastModifyOn}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: filesInstance, field: 'legalEntityFiles', 'error')} ">
	<label for="legalEntityFiles">
		<g:message code="files.legalEntityFiles.label" default="Legal Entity Files" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${filesInstance?.legalEntityFiles?}" var="l">
    <li><g:link controller="legalEntityFiles" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="legalEntityFiles" action="create" params="['files.id': filesInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles')])}</g:link>
</li>
</ul>

</div>

