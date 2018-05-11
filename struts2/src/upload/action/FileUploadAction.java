package upload.action;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import upload.dao.FileUploadDAO;
import upload.interceptor.FileUploadDAOAware;
import upload.model.UserInfo;


public class FileUploadAction extends ActionSupport implements Preparable, ModelDriven<UserInfo>, FileUploadDAOAware {

	private static final long serialVersionUID = 1L;
	
	//���� ������ ���� �� ���丮
	private final String UPLOAD_DIR = "C:/Java/upload/";
	private Log log = LogFactory.getLog(FileUploadAction.class);
	// fileUpload ���ͼ��Ͱ� �����ϴ� �κ�
	// setter �� ������� �־�� �Ѵ�.	
	
	// fileUpload ���ͼ��Ͱ� �ӽõ��丮�� ������ ���� ��ü
	File doc;
	//content type
	String docContentType;
	//���� ���� �̸�
	String docFileName;
	//������ ������Ʈ
	UserInfo userInfo;
	//���� UPLOAD ���丮�� ������ ���� ��ü
	File savedFile;
	//FileUploadDAO ����
	FileUploadDAO fileUploadDAO;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(fileUploadDAO.inserUserInfo(userInfo)) {
			log.info(">>>>> fileUploadDAO.inserUserInfo ��~~");
			
			if(doc != null && doc.exists()) {
				log.info(">>>>> File Copy ��~.~");
				savedFile = new File(UPLOAD_DIR + docFileName);
				FileUtils.copyFile(doc, savedFile);
				log.info(">>>>> File Copy ��.....");
			}
		}		
		return SUCCESS;
	}
	
	/* set �޼���� */
	
	public void setDoc(File doc) {
		this.doc = doc;
	}

	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}
	
	/* get �޼���� */
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public File getDoc() {
		return this.doc;
	}
	
	public File getSavedFile() {
		return this.savedFile;
	}
	
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		userInfo = new UserInfo();
	}

	
	
	
	

}
