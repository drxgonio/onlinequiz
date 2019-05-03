package grouptwo.quizexam.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	private static final Map<String,List<String>> map=new HashMap<String,List<String>>();
		static {
			init();
		}
		private static void init()
		{
			//cáº¥u hÃ¬nh cho admin
			List<String> urlPatternsAD=new ArrayList<String>();
			urlPatternsAD.add("/HomeQuizController");
			urlPatternsAD.add("/ListExam");
			urlPatternsAD.add("/AddExam");
			urlPatternsAD.add("/EditExam");
			urlPatternsAD.add("/ListQuestion");
			urlPatternsAD.add("/AddQuestion");
			urlPatternsAD.add("/EditQuestion");
			
			urlPatternsAD.add("/ListAllStudent");
			urlPatternsAD.add("/AddStudent");
			urlPatternsAD.add("/EditAllStudent");
			
			urlPatternsAD.add("/ListCourse");
			urlPatternsAD.add("/AddCourse");
			urlPatternsAD.add("/EditCourse");
			
			urlPatternsAD.add("/ListAllStudent");
			urlPatternsAD.add("/AddStudent");
			urlPatternsAD.add("/EditAllStudent");
			
			urlPatternsAD.add("/ListSubject");
			urlPatternsAD.add("/AddSubject");
			urlPatternsAD.add("/EditSubject");
			
			urlPatternsAD.add("/ListCoursesExam");

			urlPatternsAD.add("/ListStudent");
			urlPatternsAD.add("/AddStudentCourse");
			
			
			//cáº¥u hÃ¬nh cho há»�c sinh
			List<String> urlPatternsStu=new ArrayList<String>();
			urlPatternsStu.add("/HomeQuizController");
			urlPatternsStu.add("/DoTest");
			urlPatternsStu.add("/TestOn");
			
			
			//cáº¥u hÃ¬nh cho quáº£n lÃ½ Ä‘á»�
			List<String> urlPatternsExam=new ArrayList<String>();
			urlPatternsExam.add("/HomeQuizController");
			urlPatternsExam.add("/ListExam");
			urlPatternsExam.add("/AddExam");
			urlPatternsExam.add("/EditExam");
			urlPatternsExam.add("/DeleteExam");


			
			
			//cáº¥u hÃ¬nh cho quáº£n lÃ½ cÃ¢u há»�i
			List<String> urlPatternsQus=new ArrayList<String>();
			urlPatternsQus.add("/HomeQuizController");
			urlPatternsQus.add("/ListQuestion");
			urlPatternsQus.add("/AddQuestion");
			urlPatternsQus.add("/EditQuestion");
			
			
			//cáº¥u hÃ¬nh cho quáº£n lÃ½ lá»›p há»�c vÃ  sinh viÃªn
			List<String> urlPatternsStu_Course=new ArrayList<String>();
			urlPatternsStu_Course.add("/HomeQuizController");
			urlPatternsStu_Course.add("/ListAllStudent");
			urlPatternsStu_Course.add("/AddStudent");
			urlPatternsStu_Course.add("/EditAllStudent");
			
			urlPatternsStu_Course.add("/ListCourse");
			urlPatternsStu_Course.add("/AddCourse");
			urlPatternsStu_Course.add("/EditCourse");
			
			urlPatternsStu_Course.add("/ListAllStudent");
			urlPatternsStu_Course.add("/AddStudent");
			urlPatternsStu_Course.add("/EditAllStudent");
			
			urlPatternsStu_Course.add("/ListSubject");
			urlPatternsStu_Course.add("/AddSubject");
			urlPatternsStu_Course.add("/EditSubject");
			
			urlPatternsStu_Course.add("/ListCoursesExam");

			urlPatternsStu_Course.add("/ListStudent");
			urlPatternsStu_Course.add("/AddStudentCourse");
			
			map.put("ad", urlPatternsAD);
			map.put("stu",urlPatternsStu);
			map.put("asma",urlPatternsQus);
			map.put("stuma",urlPatternsStu_Course);
			map.put("exma",urlPatternsExam);
			
		
		}
		public static Set<String> getAllRoles()
		{
			return map.keySet();
		}
		public static List<String> getAllUrlPatternForRole(String role)
		{
			return map.get(role);
		}
}
