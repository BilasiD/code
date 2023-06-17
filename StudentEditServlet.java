package jsp_student1_servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_student1.Student;
@WebServlet("/edit")
public class StudentEditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phoneno=Long.parseLong(req.getParameter("phoneno"));
	ServletContext  context=getServletContext();
	String stringfees=context.getInitParameter("fees");
	double fees=Double.parseDouble(stringfees);


	Student student=new Student();
	student.setAddress(address);
   student.setEmail(email);
   student.setFees(fees);
   student.setName(name);
   student.setPassword(password);
   student.setPhoneno(phoneno);
	}
}
