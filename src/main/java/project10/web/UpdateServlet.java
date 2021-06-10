package project10.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project10.Dao.StudentDao;
import project10.model.Student;
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String stud_id=request.getParameter("stud_id");
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String contactno=request.getParameter("contactno");
		

		String email=request.getParameter("email");
        String address=request.getParameter("address");
        String course=request.getParameter("course");

		Student e=new Student();
		e.setStud_id(stud_id);
		e.setName(name);
		e.setAge(age);
		e.setContactno(contactno);
		e.setEmail(email);
		e.setAddress(address);
		e.setCourse(course);
		
		int status=StudentDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
