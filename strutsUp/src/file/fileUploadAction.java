package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;


public class fileUploadAction extends ActionSupport {
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	private String fileUploadPath = "C:\\java\\upload\\";
	
	public String upload() throws Exception {
		File destFile = new File(fileUploadPath + getUploadFileName());
		FileUtils.copyFile(getUpload(), destFile);
		
		FileInputStream inputStream = new FileInputStream(upload);
		FileOutputStream outputStream = new FileOutputStream(fileUploadPath + getUploadFileName());
		int bytesRead = 0;
		byte[] buffer = new byte[1024];
		
		while((bytesRead = inputStream.read(buffer,0,1024)) != -1) {
			outputStream.write(buffer,0,bytesRead);
		}
		
		outputStream.close();
		inputStream.close();
				
		return SUCCESS;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String getUploadContentType() {
		return uploadContentType;
	}
	
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	

}
