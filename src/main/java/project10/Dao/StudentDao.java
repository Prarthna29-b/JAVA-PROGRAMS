package project10.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project10.model.Student;

public class StudentDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/institutedatabase","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Student e){
		int status=0 ;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(stud_id,name,age, contactno,email,address,course) values (?,?,?,?,?,?,?)");
			ps.setString(1,e.getStud_id());
			ps.setString(2,e.getName());
			ps.setString(3,e.getAge());
			ps.setString(4,e.getContactno());
			ps.setString(5,e.getEmail());
			ps.setString(6,e.getAddress());
			ps.setString(7,e.getCourse());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Student e){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update student set name=?,age=?,contactno=?,email=?,address=?,course=? where stud_id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getAge());
			ps.setString(3,e.getContactno());
			ps.setString(4,e.getEmail());
			ps.setString(5,e.getAddress());
			ps.setString(6,e.getCourse());
			ps.setString(7, e.getStud_id());
			status=ps.executeUpdate();
			
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int stud_id){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from student where stud_id=?");
			ps.setInt(1,stud_id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Student getStudent(String stud_id){
		Student e=new Student();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where stud_id=?");
			ps.setString(1,stud_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setStud_id(rs.getString(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getString(3));
				e.setContactno(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setCourse(rs.getString(7));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Student> getAllStudent(){
		List<Student> list=new ArrayList<Student>();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student e=new Student();
				e.setStud_id(rs.getString(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getString(3));
				e.setContactno(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setCourse(rs.getString(7));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}

