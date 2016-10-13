

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Topic</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Topic List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Topic</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${topic}">
            <div class="errors">
                <g:renderErrors bean="${topic}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="subject">Subject:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:topic,field:'subject','errors')}">
                                    <input type="text" id="subject" name="subject" value="${fieldValue(bean:topic,field:'subject')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="message">Message:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:topic,field:'message','errors')}">
                                    <textarea rows="5" cols="40" name="message">${fieldValue(bean:topic, field:'message')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="date">Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:topic,field:'date','errors')}">
                                    <g:datePicker name="date" value="${topic?.date}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="forum">Forum:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:topic,field:'forum','errors')}">
                                    <g:select optionKey="id" from="${Forum.list()}" name="forum.id" value="${topic?.forum?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="rating">Rating:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:topic,field:'rating','errors')}">
                                    
         <resource:rating />
         <richui:rating dynamic="true" id="rating" units="5"
         rating="${fieldValue(bean:topic,
         field:'rating')}"
         controller="topic"
         action="rate" />
         
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
