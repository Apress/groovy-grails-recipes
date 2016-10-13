<g:form action="submit" enctype="multipart/form-data">
    Subject: <g:textField name="topic.subject" />
    <br/>
    Topic: <g:textArea name="topic.message"
             rows="5" cols="40"/>
      Upload file:<input type="file" name="topic.myFile" />
      <input type="submit" value="Upload" name="" />
</g:form>