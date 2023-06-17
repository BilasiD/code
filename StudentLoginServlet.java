package jsp_student1_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jsp_student_Dao.StudentDao;
import jsp_student1.Student;

public class StudentLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		List<Student> students = dao.getAllStudent();

		boolean value = false;
		for (Student student : students) {
			if (student.getEmail().equals(email)) {
				value = true;
				break;
			}
		}
		//when it is going to give this
		//false=when that email is not at all present in the database
		//true=when that email is present in the database
				if (value) {
//			check with password
		// first fetch the student based on the email
					Student student = dao.getStudentByEmail(email);
					if (student.getPassword().equals(password)) {
//		    	login success 
						req.setAttribute("list", students);
						RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
						dispatcher.forward(req, resp);
					} else {
//		    	login failure because of wrong password
						req.setAttribute("message", "Wrong password /n Please enter a valid password");
						RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
						dispatcher.include(req, resp);
					}
				} else {
//					give a msg that email is not present email doesnot exist
//					i need show the same login page
							req.setAttribute("message", "EMAILDOESNOTEXIST");
							RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
							dispatcher.include(req, resp);
						}

					}
	}
