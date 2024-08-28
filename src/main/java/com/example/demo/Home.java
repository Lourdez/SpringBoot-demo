package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Home {

	private String owner;
	private int doorno;
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getDoorno() {
		return doorno;
	}

	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	void connect() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "1234");
			Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            
            resultSet = statement.executeQuery(
                    "select * from employees;");
            
            int EMPLOYEE_ID;
            String FIRST_NAME;
            String LAST_NAME;
            String JOB_ID;
            while (resultSet.next()) {
                EMPLOYEE_ID = resultSet.getInt("EMPLOYEE_ID");
                FIRST_NAME = resultSet.getString("FIRST_NAME");
                LAST_NAME = resultSet.getString("LAST_NAME");
                JOB_ID = resultSet.getString("JOB_ID").trim();
                System.out.println("Employee ID : " + EMPLOYEE_ID
                                   + " Name : " + FIRST_NAME +" "+ LAST_NAME+" " +"Job ID : "+JOB_ID);
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
