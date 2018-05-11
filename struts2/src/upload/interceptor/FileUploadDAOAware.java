package upload.interceptor;

import upload.dao.FileUploadDAO;

public interface FileUploadDAOAware {
	public void setFileUploadDAO(FileUploadDAO fileUploadDAO);
}
