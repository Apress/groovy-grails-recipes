<!-- grails-app/views/viewForum/_displayTopics.gsp -->
<div class="post">
  <a href="${createLink(action: 'viewTopic',
          params: [forumName: params.forumName, subject: topic.subject])}">
    ${topic.subject}
  </a>
</div>
