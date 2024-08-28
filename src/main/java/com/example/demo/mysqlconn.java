package com.example.demo;

import java.sql.*;
public class mysqlconn {

	public static void main(String[] args) throws ClassNotFoundException {

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
}