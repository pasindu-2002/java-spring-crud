package lk.nibm.edu.ead2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieving form data
    	
    	StudentService ser = new StudentService();
    	
    	int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String registrationNo = request.getParameter("registrationNo");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        int age = Integer.parseInt(request.getParameter("age"));
        
        if (firstName.isEmpty() || lastName.isEmpty() || registrationNo.isEmpty()) {
            request.setAttribute("error", "One or more fields are empty.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        
        Student s1 = new Student();
        s1.setId(id);
        s1.setFirstName(firstName);
        s1.setLastName(lastName);
        s1.setRegistrationNo(registrationNo);
        s1.setEmail(email);
        s1.setTelephone(telephone);
        s1.setAge(age);
        
        System.out.println(s1);
		try {
			if(ser.insert(s1)) {
			 	
			}
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<script> alert(\"Student Details Insert Successfully\");</script>");
	        out.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
       
    }
}

