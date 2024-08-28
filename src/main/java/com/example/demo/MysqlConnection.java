package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class MysqlConnection {
	public int EMPLOYEE_ID;
    public String FIRST_NAME;
    public String LAST_NAME;
    
    MysqlConnection(){    	
    }
    
    
	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}


	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}


	public String getFIRST_NAME() {
		return FIRST_NAME;
	}


	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}


	public String getLAST_NAME() {
		return LAST_NAME;
	}


	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
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
            
            
            while (resultSet.next()) {
                EMPLOYEE_ID = resultSet.getInt("EMPLOYEE_ID");
                FIRST_NAME = resultSet.getString("FIRST_NAME");
                LAST_NAME = resultSet.getString("LAST_NAME").trim();
                System.out.println("Employee ID : " + EMPLOYEE_ID
                                   + " Name : " + FIRST_NAME +" "+ LAST_NAME);
            }
		
            resultSet.close();
            statement.close();
            connection.close();
            
            
		}  catch (Exception exception) {
            System.out.println(exception);
        }
		finally { 
		}		
	}
}
