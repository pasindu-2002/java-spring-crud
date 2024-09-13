package lk.nibm.edu.ead2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class Database {
 
	private static Database database;
	private Connection connection;
 
	private Database() throws SQLException, NamingException {
		this.connection = connect();
		System.out.println("HSQLDB database connection established...");
	}
 
	public static Database getDatabase() throws SQLException, NamingException {
		if(database == null) {
			database = new Database();
		}
 
		return database;
	}
	private Connection connect() throws SQLException, NamingException {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:/comp/env/DB");
		return ds.getConnection();
	}
 
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}
 
	public void close() throws SQLException {
		this.connection.close();
	}
}
