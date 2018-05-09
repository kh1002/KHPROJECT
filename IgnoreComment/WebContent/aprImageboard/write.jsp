<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page errorPage="error_view.jsp"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="gallery.ImageUtil"%>
<%@ page import="gallery.FileUploadRequestWrapper"%>
<%@ page import="gallery.Theme"%>
<%@ page import="gallery.ThemeManager"%>
<%@ page import="gallery.ThemeManagerException"%>

<%
	FileUploadRequestWrapper requestWrap = new FileUploadRequestWrapper(request, -1, -1,
			"C:\\java\\App\\KH10GALLERY\\WebContent\\temp");
	HttpServletRequest tempRequest = request;
	request = requestWrap;
%>

<jsp:useBean id="theme" class="gallery.Theme">
	<jsp:setProperty name="theme" property="*" />
</jsp:useBean>

<%
	FileItem imageFileItem = requestWrap.getFileItem("imageFile");
	String image = "";
	if (imageFileItem.getSize() > 0) {
		image = Long.toString(System.currentTimeMillis());
		File imageFile = new File("C:\\java\\App\\KH10GALLERY\\WebContent\\image", image);
		if (imageFile.exists()) {
			for (int i = 0; true; i++) {
				imageFile = new File("C:\\java\\App\\KH10GALLERY\\WebContent\\image", image + "_" + i);
				if (!imageFile.exists()) {
					image = image + "_" + i;
					break;
				}

			}
		}
		imageFileItem.write(imageFile);
		
		//  썸네일 이미지 생성
		File destFile = new File(
				"C:\\java\\App\\KH10GALLERY\\WebContent\\image", image+".small.jpg");
		ImageUtil.resize(imageFile, destFile, 50, ImageUtil.RATIO);

	}
	
	theme.setRegister(new Timestamp(System.currentTimeMillis()));
	theme.setImage(image);
	ThemeManager manager = ThemeManager.getInstance();
	manager.insert(theme);
%>

<script>
alert("새로운 이미지를 등록했습니다.");
location.href="list.jsp";</script>