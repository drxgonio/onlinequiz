package grouptwo.quizexam.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.BaseService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@WebServlet("/ReportExam")
public class ReportExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReportExam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");		
		
		HttpSession session=request.getSession();
		User use=(User) session.getAttribute("loginedUser");
		int studentId;
		int examId;
		try {
			if(request.getParameter("idExam")==null)
			{
				examId	= (int) session.getAttribute("idExamCurent");
			}
			else
			{
				examId	= Integer.parseInt(request.getParameter("idExam"));
			}
			studentId = use.getUserId();
			JasperReport jasperReport = null;
			JasperDesign jasperDesign = null;
			Map<String, Object> parameters = new HashMap<String,Object>();
			parameters.put("studentId", studentId);
			parameters.put("examId", examId);

			String path = getServletContext().getRealPath("/WEB-INF/");
			jasperDesign = JRXmlLoader.load(path + "/report.jrxml");
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, BaseService.getConnection());
			OutputStream outStream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setContentLength(byteStream.length);
			outStream.write(byteStream, 0, byteStream.length);
		}
		catch(JRException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
