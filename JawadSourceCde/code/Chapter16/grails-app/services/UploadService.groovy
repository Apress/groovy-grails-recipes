class UploadService {
  boolean transactional = false
  def uploadLocation

  def upload(def file) {
    file.transferTo(new File(uploadLocation + file.originalFilename))
  }
}