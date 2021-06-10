
package project10.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project10.Dao.StudentDao;
import project10.model.Student;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'><center><h2>Add New Student</h2></center></a>");
		out.println("<h1>Student list</h1>");
		
		List<Student> list=StudentDao.getAllStudent();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Stud_id</th><th>Name</th><th>Age</th> <th>Contactno</th><th>Email</th><th>Address</th><th>Course</th><th>Edit</th><th>Delete</th></tr>");
		for(Student e:list){
			out.print("<tr><td>"+e.getStud_id()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td><td>"+e.getContactno()+"</td>"
	+ "<td>"+e.getEmail()+"</td ><td>"+e.getAddress()+"</td><td>"+e.getCourse()+"</td>"
			+ "<td><a href='EditServlet?stud_id="+e.getStud_id()+"'>edit</a></td>"
									+ "<td><a href='DeleteServlet?stud_id="+e.getStud_id()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
