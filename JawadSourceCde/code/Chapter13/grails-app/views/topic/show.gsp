

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Topic</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Topic List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Topic</g:link></span>
        </div>
        <div class="body">
            <h1>Show Topic</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:topic, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Subject:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:topic, field:'subject')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Message:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:topic, field:'message')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:topic, field:'date')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Forum:</td>
                            
                            <td valign="top" class="value"><g:link controller="forum" action="show" id="${topic?.forum?.id}">${topic?.forum?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Rating:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:topic, field:'rating')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${topic?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
