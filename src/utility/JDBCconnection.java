package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnection extends BaseClass{

static Connection conc = null;

	public static void connectjdbc(){
		
		try {
			Class.forName("org.sqlite.JDBC");
			conc = DriverManager.getConnection(prop.getProperty("JDBC"));
			System.out.println("JDBC connection created");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void createtable(){
		try{ 
			connectjdbc();
		String sqltable = "CREATE TABLE IF NOT EXISTS IMDBdata (\n"
                + "	year String NOT NULL,\n"
                + "	name String NOT NULL,\n"
                + "	rating String NOT NULL\n"
                + ");";
		
		Statement stmt = conc.createStatement();
            // create a new table
            stmt.execute(sqltable);
            System.out.println("JDBC table is  created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	
		public static void insert(String year,String name, String rating) {
	        String sql = "INSERT INTO IMDBdata(year ,name,rating) VALUES(?,?,?)";
	 
	        try {   connectjdbc();
	                PreparedStatement pstmt = conc.prepareStatement(sql) ;
	                pstmt.setString(1, year);
	                pstmt.setString(2, name);
	            pstmt.setString(3, rating);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

	