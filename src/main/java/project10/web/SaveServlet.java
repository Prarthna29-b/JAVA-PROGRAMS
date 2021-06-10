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
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
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
		
	    int status=StudentDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
