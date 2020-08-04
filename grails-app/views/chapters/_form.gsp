<%@ page import="com.test.Chapters" %>



<div class="fieldcontain ${hasErrors(bean: chaptersInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="chapters.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${chaptersInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: chaptersInstance, field: 'modules', 'error')} ">
	<label for="modules">
		<g:message code="chapters.modules.label" default="Modules" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${chaptersInstance?.modules?}" var="m">
    <li><g:link controller="modules" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="modules" action="create" params="['chapters.id': chaptersInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'modules.label', default: 'Modules')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: chaptersInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="chapters.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${chaptersInstance?.name}"/>
</div>

