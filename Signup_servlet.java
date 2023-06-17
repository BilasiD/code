package jsp_student1_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jsp_student_Dao.StudentDao;
import jsp_student1.Student;

public class Signup_servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phoneno = Long.parseLong(req.getParameter("phoneno"));
		String address = req.getParameter("address");
		ServletContext context = getServletContext();
		String fee = context.getInitParameter("fees");
		double fees = Double.parseDouble(fee);

		StudentDao dao = new StudentDao();
//		taking all students from the database
		List<Student> students = dao.getAllStudent();
		boolean value = false;
//		checking my email with the already exist students email
        for(Student student:students) {
        	if(student.getEmail().equals(email)) {
        		value=true;
        		break;
        	}
        }

//       value=false when your email is not present in the database
//        value=true when your email is present in the database

        if(value) {
//        	give a msg email already exist
        	req.setAttribute("message", "EMAILALREADYEXIST");
        	RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
        	dispatcher.include(req, resp);
        }else {
//        	insert the data into the database
        	Student student = new Student();
    		student.setAddress(address);
    		student.setEmail(email);
    		student.setFees(fees);
    		student.setId(id);
    		student.setName(name);
    		student.setPassword(password);
    		student.setPhoneno(phoneno);

    		StudentDao studentDao = new StudentDao();
    		studentDao.saveStudent(student);
    		req.setAttribute("message", "Signed In Successfullly");
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);

        }

	}}
