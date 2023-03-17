package container;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Myme
 */
public class Myme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int n=1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myme() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		
		String name=request.getParameter("Name");
		String email=request.getParameter("Email");
		String subject=request.getParameter("Subject");
		String message=request.getParameter("Message");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myme","root","");
//			int n= Integer.parseInt(request.getParameter("uname"));
//			int p= Integer.parseInt(request.getParameter("pass"));
			PreparedStatement ps=con.prepareStatement("insert into contacts values(?,?,?,?,?)");
//			PreparedStatement ps2=con.prepareStatement("select accnoa from Admins where accnoa=? and pinnoa=?");
			ps.setInt(1, n);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, subject);
			ps.setString(5, message);
//			ps2.setInt(1, n);
//			ps2.setInt(2, p);
			int i=ps.executeUpdate();
			
			if(i>0) 
			{
				out.print("you are successfully registered!<br><br>");
				out.println("<a href=index.jsp style=text-decoration:none;><font color=orange>Back...</a>");
			}
			n++;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
