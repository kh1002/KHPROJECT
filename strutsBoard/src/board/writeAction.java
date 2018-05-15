package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class writeAction extends ActionSupport {
	public static Reader reader; //파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체
	
	private boardVO paramClass; //파라미터를 저장할 객체. ibatis로 보내기 위함
	private boardVO resultClass; //쿼리 결과 값을 저장할 객체. ibatis에서 실행된 결과를 가져오려고
	
	private int currentPage;
	
	private int no;
	private String subject;
	private String name;
	private String password;
	private String content;
	private String file_orgName; //업로드 파일의 원래이름
	private String file_savName; //서버에 저장할 업로드 파일의 이름. 고유번호로 구분
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기
	
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath="C:\\java\\upload\\"; //업로드 경로
	
	//생성자
	public writeAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml의 내용을 적용한 sqlMapper객체생성
		reader.close();
		
	}
	
	//등록 폼
	public String form() throws Exception {
		return SUCCESS;
	}
	
	//게시판 write액션
	public String execute() throws Exception {
		
		//파라미터와 리절트 객체 생성(자바빈 객체 생성)
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		//등록할 항목 설정
		paramClass.setSubject(getSubject());
		paramClass.setName(getName());
		paramClass.setPassword(getPassword());
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());
		
		//등록 쿼리 수행
		sqlMapper.insert("insertBoard",paramClass); //(함수이름?, 자바빈) //9개중 7개의 변수 세팅
		
		//첨부파일을 선택했다면 파일을 업로드한다
		if(getUpload() != null) { //업로드했다면
			
			//등록한 글 번호 가져오기
			resultClass = (boardVO) sqlMapper.queryForObject("selectLastNo"); //queryForObject는 결과가 여러줄일때 씀
			
			//실제 서버에 저장될 파일 이름과 확장자 설정
			String file_name = "file_" + resultClass.getNo();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//서버에 파일 저장
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정
			paramClass.setNo(resultClass.getNo());
			paramClass.setFile_orgname(getUploadFileName()); //원래 파일이름
			paramClass.setFile_savname(file_name+"."+file_ext); //서버에 저장한 파일 이름
			
			//파일 정보 업데이트
			sqlMapper.update("updateFile", paramClass); //파일 관련 정보를 넣어 db에 다시 저장시킨다.(그래서 update문)			
		}
		return SUCCESS;		
	}

	//get set 메서드들
	public boardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile_orgName() {
		return file_orgName;
	}

	public void setFile_orgName(String file_orgName) {
		this.file_orgName = file_orgName;
	}

	public String getFile_savName() {
		return file_savName;
	}

	public void setFile_savName(String file_savName) {
		this.file_savName = file_savName;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
	
	
	
	
	
	
	
}
