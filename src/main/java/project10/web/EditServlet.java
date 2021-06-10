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
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Student</h1>");
		String stud_id=request.getParameter("stud_id");
		
		
		Student e=StudentDao.getStudent(stud_id);
		
		out.print("<form action='UpdateServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='stud_id' value='"+e.getStud_id()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Age:</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");
		out.print("<tr><td>Contactno:</td><td><input type='text' name='contactno' value='"+e.getContactno()+"'/></td></tr>");

		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td>Course:</td><td><input type='text' name='course' value='"+e.getCourse()+"'/></td></tr>");

		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("<tr><td><input type='reset' value='Reset' /></td></tr>");
		out.print("</table>");
		
		
		
		out.print("</form>");
		
		out.close();
	}
}
