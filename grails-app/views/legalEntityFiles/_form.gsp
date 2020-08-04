<%@ page import="com.test.LegalEntityFiles" %>



<div class="fieldcontain ${hasErrors(bean: legalEntityFilesInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="legalEntityFiles.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${legalEntityFilesInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityFilesInstance, field: 'createdOn', 'error')} required">
	<label for="createdOn">
		<g:message code="legalEntityFiles.createdOn.label" default="Created On" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdOn" precision="day"  value="${legalEntityFilesInstance?.createdOn}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityFilesInstance, field: 'file', 'error')} required">
	<label for="file">
		<g:message code="legalEntityFiles.file.label" default="File" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="file" name="file.id" from="${com.test.Files.list()}" optionKey="id" required="" value="${legalEntityFilesInstance?.file?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityFilesInstance, field: 'legalEntityFileStatus', 'error')} required">
	<label for="legalEntityFileStatus">
		<g:message code="legalEntityFiles.legalEntityFileStatus.label" default="Legal Entity File Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="legalEntityFileStatus" name="legalEntityFileStatus.id" from="${com.test.LegalEntityFileStatus.list()}" optionKey="id" required="" value="${legalEntityFilesInstance?.legalEntityFileStatus?.id}" class="many-to-one"/>
</div>

