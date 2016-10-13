

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Forum List</title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
    <span class="menuButton"><g:link class="create" action="create">New Forum</g:link></span>
</div>
<div class="body">
    <h1>Forum List</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${forum}">
        <div class="errors">
            <g:renderErrors bean="${forum}" as="list"/>
        </div>
    </g:hasErrors>
    <div class="list">
        <table>
            <thead>
                <tr>
                    
                    <g:sortableColumn property="id" title="Id"/>
                    
                    <g:sortableColumn property="name" title="Name"/>
                    
                    <g:sortableColumn property="description" title="Description"/>
                    
                </tr>
            </thead>
            <tbody>
                <g:each in="${forumList}" status="i" var="forum">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                        <td><g:link action="show" id="${forum.id}">${fieldValue(bean:forum, field:'id')}</g:link></td>
                        
                        <td>${fieldValue(bean:forum, field:'name')}</td>
                        
                        <td>${fieldValue(bean:forum, field:'description')}</td>
                        
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
    <div class="paginateButtons">
        <g:paginate total="${Forum.count()}"/>
    </div>
</div>
</body>
</html>
