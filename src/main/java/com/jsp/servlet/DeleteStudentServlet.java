package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));


		Connection conn= null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/servletdb","postgres","0000");
			
			PreparedStatement pst = conn.prepareStatement("delete from student where id= ?");
			
			pst.setInt(1, id);
			
			int rowexecuted = pst.executeUpdate();
			
			if(rowexecuted>0) {
				System.out.println(rowexecuted+" delted successfully....");
			}
			else {
				System.out.println("Does'not Executed succesfully..");
			}
			PrintWriter p = res.getWriter();
			
			p.write("Successfully deleted to DataBase...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
