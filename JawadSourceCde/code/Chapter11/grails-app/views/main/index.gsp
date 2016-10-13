<!--grails-app/views/main/index.gsp -->
<html>
<head><title>Main</title></head>
<body>Welcome to Groovy and Grails forum
<div>
  <ul>
    <g:each in="${forums}" var="forum">
      <li><g:link controller="viewForum" params='[forumName:"${forum}"]'>
        ${forum}</g:link></li>
    </g:each>
  </ul>
</div>
</body>
</html>
