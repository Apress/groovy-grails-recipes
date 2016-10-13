import static org.codehaus.groovy.grails.commons.ConfigurationHolder.config
beans = {
  uploadService(UploadService) {
      uploadLocation = config.upload.location
    }
}