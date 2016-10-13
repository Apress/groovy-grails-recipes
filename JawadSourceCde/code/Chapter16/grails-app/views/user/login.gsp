<html>
  <head><title>Please login</title></head>
  <body>
  ${message}
  <g:form name="myForm" action="login">
     Username: <g:textField name="name" value="${username}" /><br/>
     Password: <g:textField name="password" value="${password}" />
     <input type="submit" value="Login" />
      <div>demo/demo</div>
   </g:form>
  </body>
</html>