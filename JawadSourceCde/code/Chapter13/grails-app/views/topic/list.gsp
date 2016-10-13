

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Topic List</title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
    <span class="menuButton"><g:link class="create" action="create">New Topic</g:link></span>
</div>
<div class="body">
    <h1>Topic List</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${topic}">
        <div class="errors">
            <g:renderErrors bean="${topic}" as="list"/>
        </div>
    </g:hasErrors>
    <div class="list">
        <table>
            <thead>
                <tr>
                    
                    <g:sortableColumn property="id" title="Id"/>
                    
                    <g:sortableColumn property="subject" title="Subject"/>
                    
                    <g:sortableColumn property="message" title="Message"/>
                    
                    <g:sortableColumn property="date" title="Date"/>
                    
                    <th>Forum</th>
                    
                    <g:sortableColumn property="rating" title="Rating"/>
                    
                </tr>
            </thead>
            <tbody>
                <g:each in="${topicList}" status="i" var="topic">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                        <td><g:link action="show" id="${topic.id}">${fieldValue(bean:topic, field:'id')}</g:link></td>
                        
                        <td>${fieldValue(bean:topic, field:'subject')}</td>
                        
                        <td>${fieldValue(bean:topic, field:'message')}</td>
                        
                        <td>${fieldValue(bean:topic, field:'date')}</td>
                        
                        <td>${fieldValue(bean:topic, field:'forum')}</td>
                        
                        <td>${fieldValue(bean:topic, field:'rating')}</td>
                        
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
    <div class="paginateButtons">
        <g:paginate total="${Topic.count()}"/>
    </div>
</div>
</body>
</html>
