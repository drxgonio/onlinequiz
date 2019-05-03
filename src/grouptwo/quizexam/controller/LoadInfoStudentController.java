package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import grouptwo.quizexam.model.Profilestudent;
import grouptwo.quizexam.service.ProfilestudentService;

@WebServlet("/LoadInfoStudent")
public class LoadInfoStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadInfoStudentController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String typeSearch = request.getParameter("typeSearch");
		if (typeSearch.equals("id")) {
			int studentId = Integer.parseInt(request.getParameter("studentId"));

			Profilestudent student = ProfilestudentService.getProfilestudentById(studentId);

			String json = new Gson().toJson(student);
			response.getWriter().println(json);
		}
		
		if(typeSearch.equals("name"))
		{
			String name = request.getParameter("studentId");

			List<Profilestudent> student = new ArrayList<>();
			student = ProfilestudentService.getProfilestudentByName(name);
			
			String json = new Gson().toJson(student);
			response.getWriter().println(json);
		}
	}


}
