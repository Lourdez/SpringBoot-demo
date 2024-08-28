package com.example.demo;

import java.sql.*;
import org.springframework.stereotype.Component;
@Component
public class mysqlconn {
	
	public String sample= "";

	public static void main(String[] args) throws ClassNotFoundException {
		
sqlcon();

	}

	private static void sqlcon() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
			Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            
            resultSet = statement.executeQuery(
                    "select * from students;");
            
            int age;
            String name;
            while (resultSet.next()) {
                age = resultSet.getInt("age");
                name = resultSet.getString("name").trim();
                System.out.println("age : " + age
                                   + " Name : " + name);
            }
		
            resultSet.close();
            statement.close();
            connection.close();
            
            
		}  catch (Exception exception) {
            System.out.println(exception);
        }
		finally {
			
		//	System.out.println("exited with error");
			 
		}		
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}
}


