<%@ page import="com.test.LegalEntityFileStatus" %>



<div class="fieldcontain ${hasErrors(bean: legalEntityFileStatusInstance, field: 'legalEntityFileStatusName', 'error')} ">
	<label for="legalEntityFileStatusName">
		<g:message code="legalEntityFileStatus.legalEntityFileStatusName.label" default="Legal Entity File Status Name" />
		
	</label>
	<g:textField name="legalEntityFileStatusName" value="${legalEntityFileStatusInstance?.legalEntityFileStatusName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityFileStatusInstance, field: 'legalEntityFiles', 'error')} ">
	<label for="legalEntityFiles">
		<g:message code="legalEntityFileStatus.legalEntityFiles.label" default="Legal Entity Files" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${legalEntityFileStatusInstance?.legalEntityFiles?}" var="l">
    <li><g:link controller="legalEntityFiles" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="legalEntityFiles" action="create" params="['legalEntityFileStatus.id': legalEntityFileStatusInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles')])}</g:link>
</li>
</ul>

</div>

