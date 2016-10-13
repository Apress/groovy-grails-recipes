<!-- grails-app/views/viewForum/index.gsp -->
<html>
<head>
  <meta name="layout" content="supplementary"/>
  <title>Simple GSP page</title>
</head>
<body>
<div id="page">
  <div id="content">
    ${params?.message} <br/>
    ${params.forumName} Topics: <p/>
    <g:if test='${!session."${params.forumName}"}'>
      No topics
    </g:if>
    <g:render template="displayTopics" var="topic"
            collection='${session."${params.forumName}"}'/>
    <div>
      <a href="${createLink(action: 'compose',
              params: [forumName: params.forumName])}">Compose</a>
      <a href="${createLink(controller: 'main')}">Back to forums</a>
    </div>
  </div>
</div>
</body>
</html>
