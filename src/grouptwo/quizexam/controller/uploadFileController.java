package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.SubjectService;
import grouptwo.quizexam.utils.FileUtlis;




@WebServlet("/uploadFileControler")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class uploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public uploadFileController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("subjectLs", SubjectService.getAllSubjects());
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadFile.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveFullPath=FileUtlis.createFoderUploadFile(request);
		String pathFile=FileUtlis.upLoadFile(request, saveFullPath);
		String nameSubject=request.getParameter("nameSubject");
		
		int idSubject=SubjectService.getSubjectsByName(nameSubject).getSubjectID();
		if(pathFile!=null)
		{
			System.out.println(pathFile);
			FileUtlis.readAndWriteFileExcel(pathFile,2,idSubject);
			FileUtlis.DeleteFile(pathFile);
			response.sendRedirect(request.getContextPath() + "/uploadFileResults");
		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadFile.jsp");
		}
	}

}
