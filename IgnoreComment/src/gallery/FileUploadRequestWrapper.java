package gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.sun.corba.se.spi.orb.StringPair;

import java.util.Map;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;


public class FileUploadRequestWrapper extends HttpServletRequestWrapper {
	private boolean multipart = false;
	
	private HashMap parameterMap;
	private HashMap fileItemMap;
	
	public FileUploadRequestWrapper(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
		this(request, -1, -1, null);
	}
	
	public FileUploadRequestWrapper(HttpServletRequest request, int threshold, int max, String repositoryPath) throws FileUploadException, UnsupportedEncodingException {
		super(request);
		
		parsing(request, threshold, max, repositoryPath);
	}
	
	private void parsing(HttpServletRequest request, int threshold, int max, String repositoryPath) throws FileUploadException, UnsupportedEncodingException {
		
		if(FileUpload.isMultipartContent(request)) {
			multipart = true;
			
			parameterMap = new java.util.HashMap();
			fileItemMap = new java.util.HashMap();
			
			DiskFileUpload diskFileUpload = new DiskFileUpload();
			if(threshold != -1) {
				diskFileUpload.setSizeThreshold(threshold);
			}
			diskFileUpload.setSizeMax(max);
			if(repositoryPath != null) {
				diskFileUpload.setRepositoryPath(repositoryPath);
			}
			
			java.util.List list = diskFileUpload.parseRequest(request);
			for(int i =0; i<list.size(); i++) {
				FileItem fileItem = (FileItem) list.get(i);
				String name = fileItem.getFieldName();
				
				if(fileItem.isFormField()) {
					String value = fileItem.getString("EUC-KR"); //"EUC-KR"을 넣으면 한글이 깨지지 않는다. 클래스에서 하는 작업이라 예외처리를 해야한다.
					String[] values = (String[]) parameterMap.get(name);
					if(values == null) {
						values = new String[] { value };
					}
					else {
						String[] tempValues = new String[values.length + 1];
						System.arraycopy(values, 0, tempValues, 0, 1);
						tempValues[tempValues.length-1] = value;
						values = tempValues;
					}
					parameterMap.put(name, values);
				}
				else {
					fileItemMap.put(name, fileItem);
				}		
			}
			addTo();
		}
	}
	public boolean isMultipartContent() {
		return multipart;
	}
	public String getParameter(String name) {
		if(multipart) {
			String[] values = (String[])parameterMap.get(name);
			if(values == null) return null;
			return values[0];
		} 
		else 
			return super.getParameter(name);
	}
	
	public String[] getParameterValues(String name) {
		if(multipart) return (String[])parameterMap.get(name);
		else return super.getParameterValues(name);		
	}
	
	public Enumeration getParameterNames() {
		if(multipart) {
			return new Enumeration() {
				Iterator iter = parameterMap.keySet().iterator();
				
				public boolean hasMoreElements() {
					return iter.hasNext();
				}
				public Object nextElement() {
					return iter.next();
				}
			};
		}
		else {
			return super.getParameterNames();
		}
	}
	
	public Map getParameterMap() {
	        if (multipart)
	            return parameterMap;
	        else
	            return super.getParameterMap();
	}
	
	public FileItem getFileItem(String name) { 
		if(multipart) return (FileItem) fileItemMap.get(name);
		else return null;
	}
	 
	public void delete() {
		if(multipart) {
			Iterator fileItemIter = fileItemMap.values().iterator();
			while(fileItemIter.hasNext()) {
				FileItem fileItem = (FileItem)fileItemIter.next();
				fileItem.delete();
			}
		}
	}
	
	public void addTo() {
		super.setAttribute(FileUploadRequestWrapper.class.getName(), this);
	}
	
	public static FileUploadRequestWrapper getFrom(HttpServletRequest request) {
		return (FileUploadRequestWrapper) request.getAttribute(FileUploadRequestWrapper.class.getName());
	}
	
	public static boolean hasWrapper(HttpServletRequest request) {
		if(FileUploadRequestWrapper.getFrom(request)==null) {
			return false;
		}
		else {
			return true;
		}
	}
}

