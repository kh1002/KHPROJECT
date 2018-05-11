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
	
	//실제 파일이 저장 될 디렉토리
	private final String UPLOAD_DIR = "C:/Java/upload/";
	private Log log = LogFactory.getLog(FileUploadAction.class);
	// fileUpload 인터셉터가 설정하는 부분
	// setter 가 만들어져 있어야 한다.	
	
	// fileUpload 인터셉터가 임시디렉토리에 저장한 파일 객체
	File doc;
	//content type
	String docContentType;
	//원본 파일 이름
	String docFileName;
	//도메인 오브젝트
	UserInfo userInfo;
	//실제 UPLOAD 디렉토리에 보관된 파일 객체
	File savedFile;
	//FileUploadDAO 참조
	FileUploadDAO fileUploadDAO;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(fileUploadDAO.inserUserInfo(userInfo)) {
			log.info(">>>>> fileUploadDAO.inserUserInfo 후~~");
			
			if(doc != null && doc.exists()) {
				log.info(">>>>> File Copy 전~.~");
				savedFile = new File(UPLOAD_DIR + docFileName);
				FileUtils.copyFile(doc, savedFile);
				log.info(">>>>> File Copy 후.....");
			}
		}		
		return SUCCESS;
	}
	
	/* set 메서드들 */
	
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
	
	/* get 메서드들 */
	
	
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
