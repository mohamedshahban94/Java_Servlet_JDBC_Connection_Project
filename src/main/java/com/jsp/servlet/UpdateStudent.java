package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updatestudent")
public class UpdateStudent extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String degree = req.getParameter("degree");
		String department = req.getParameter("department");
		int yop = Integer.parseInt(req.getParameter("yop"));

		
		Connection conn= null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/servletdb","postgres","0000");
			
			PreparedStatement pst = conn.prepareStatement("update student set degree = ?,department= ?,yop= ? where id = ?");
			
			pst.setString(1, degree);
			pst.setString(2, department);
			pst.setInt(3, yop);
			pst.setInt(4, id);
			
			int rowexe = pst.executeUpdate();
			if(rowexe>0) {
				System.out.println("Updated successfully..");
			}
			else {
				System.out.println("failed to update");
			}
			
			res.getWriter().write("Updated student data successfully... ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
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
