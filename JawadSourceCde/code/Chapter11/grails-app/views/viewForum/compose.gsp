<!-- grails-app/views/viewForum/compose.gsp -->
<!-- Note: you can't upload a file using formRemote  -->
<html>
<head>
  <meta name="layout" content="main"/>
  <title>${params.forumName}</title></head>
<body>
<div id="message"></div>
<div id="error"></div>
<g:form name="myForm" url="[action:'submit']"
        enctype="multipart/form-data">
  <g:hiddenField name="forumName" value="${params.forumName}"/>
  Compose a ${params.name} topic <br/>
  <g:editor subjectFieldName="post.subject" messageFieldName="post.message"/>
</g:form>
</body>
</html>
