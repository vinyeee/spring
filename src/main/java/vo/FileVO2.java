package vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVO2 {
	private MultipartFile[] uploadFiles;

	public MultipartFile[] getUploadFiles() {		
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
}
