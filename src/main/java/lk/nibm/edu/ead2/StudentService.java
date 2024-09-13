package lk.nibm.edu.ead2;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

public class StudentService {
	
	private static final int status = 0;

	public boolean insert(Student student) throws SQLException, NamingException {
		String sql = "INSERT INTO public.Employee(ID,FirstName,LastName,RegistrationNo,Email,Telephone,Age) VALUES(?,?,?,?,?,?,?)";
		Database db = Database.getDatabase();
		PreparedStatement ps = db.getPreparedStatement(sql);
		
			ps.setInt(1, student.getId());
		    ps.setString(2, student.getFirstName());
		    ps.setString(3, student.getLastName());
		    ps.setString(4, student.getRegistrationNo());
		    ps.setString(5, student.getEmail());
		    ps.setString(6, student.getTelephone());
		    ps.setInt(7, student.getAge());
		    
		    int rowsInserted = ps.executeUpdate(); // executeUpdate() returns the number of rows affected
		    ps.close();
		
		return status > 0;
	}

}
