<!-- grails-app/views/layouts/Supplementary.gsp -->
<html>
<head>
  <title><g:layoutTitle default="Grails"/></title>
  <link rel="stylesheet"
          href="${createLinkTo(dir: 'css', file: 'supplementary.css')}"/>
  <link rel="shortcut icon"
          href="${createLinkTo(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
  <g:layoutHead/>
  <g:javascript library="application"/>
</head>
<body>
<div id="header">
  <div id="menu">
    <ul>
      <li class="current_page_item"><a href="#">Homepage</a></li>
      <li><a href="#">News</a></li>
      <li><a href="#">Blog</a></li>
      <li><a href="#">About</a></li>
      <li class="last"><a href="#">Contact</a></li>
    </ul>
  </div>
</div>
<div id="logo">
  <h1><a href="#">Welcome to Groovy and Grails Forums</a></h1>
  <h2>Design by Free Css Templates</h2>
</div>
<g:layoutBody/>
</body>
</html>
