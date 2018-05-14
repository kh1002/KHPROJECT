package stream;

import java.io.FileInputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.Action;

public class FileDownloadAction implements Action {
	String dir;
	String fileName;
	InputStream inputStream;
	
	public String execute() throws Exception {
		inputStream = new FileInputStream(dir + "/" + fileName);
		return SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	

}
