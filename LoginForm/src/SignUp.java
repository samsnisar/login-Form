

import java.io.IOException;

import java.math.BigDecimal;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       static Connection conn;
       static PreparedStatement ps;
  
    public SignUp() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/practice","admin","admin");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		BigDecimal phone=new BigDecimal(request.getParameter("phone"));
		String password=request.getParameter("password");
		String	gender=request.getParameter("gender");
		
	try {
		ps=conn.prepareStatement("Insert into login values(?,?,?,?,?)");
		
		ps.setString(1,name);
		ps.setString(2, email);
		ps.setBigDecimal(3, phone);
		ps.setString(4,password);
		ps.setString(5, gender);
		ps.executeUpdate();
		ps.close();
		  
		response.sendRedirect(request.getContextPath() + "/SignedUp.jsp");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
