package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/findallstudent")
@WebServlet("/findStudent.html")
public class FindAllStudentServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		Connection conn =null;
		try {
			res.setContentType("text/html"); // Important to tell browser it's HTML
	        PrintWriter out = res.getWriter();
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/servletdb","postgres","0000");
			
			PreparedStatement pst = conn.prepareStatement("select * from student");
			
			ResultSet rs = pst.executeQuery();
			out.println("<html><body>");
            out.println("<h2>Student List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Degree</th><th>Department</th><th>YOP</th></tr>");

            // Loop through result set
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("degree") + "</td>");
                out.println("<td>" + rs.getString("department") + "</td>");
                out.println("<td>" + rs.getInt("yop") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
//			while(resultset.next()) {
//				res.getWriter().write(resultset.getInt(1) + resultset.getString(2)+ resultset.getString(3)+ resultset.getString(4)+resultset.getInt(5));
//			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
