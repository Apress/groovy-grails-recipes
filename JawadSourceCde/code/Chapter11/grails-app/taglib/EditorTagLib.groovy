class EditorTagLib {
  def editor = {attrs, body ->
    out << render(template: "/editor",
            model: [subjectFieldName: attrs.subjectFieldName,
                    messageFieldName: attrs.messageFieldName]);
  }
}
