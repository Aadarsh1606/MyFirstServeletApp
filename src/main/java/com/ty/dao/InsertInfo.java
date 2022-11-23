package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ty.dto.User;

public class InsertInfo {
	public boolean insertUserInfo(User u) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeejdbc", "root", "root");

		PreparedStatement preparedStatement = connection.prepareStatement("Insert into employee value(?,?,?,?)" ) ;
		
		preparedStatement.setInt(1, u.getId()) ;
		preparedStatement.setString(4, u.getAddress()) ;
		preparedStatement.setString(2, u.getName()) ;
		preparedStatement.setLong(3, u.getPhoneNumber()) ;
		
		preparedStatement.execute() ;
		connection.close() ;
		System.out.println("Data stored");
		return true;
	}
	
	public User getUserInfo(User u) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.) Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeejdbc", "root", "root");

		// 3.) Create Statement
		PreparedStatement preparedStatement1 = connection.prepareStatement("Select * from employee where id = ? and phone = ?");
		
		preparedStatement1.setInt(1,u.getId());
		preparedStatement1.setLong(3, u.getPhoneNumber());

		ResultSet result =   preparedStatement1.executeQuery();
		if(result.next())
		{
			String name = result.getString(2);
			String address = result.getString(4);
			u.setAddress(address);
			u.setName(name);
			return u;
		}
		connection.close();
		return null;

	}
	
	public boolean updateId(User u) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeejdbc", "root", "root");

		PreparedStatement preparedStatement1 = connection.prepareStatement("Update employee set name = ? where id = ?");

		

	
		preparedStatement1.setString(2,u.getName());
		preparedStatement1.setInt(1, u.getId());

		preparedStatement1.execute();

		connection.close();

		System.out.println("Done");
		return true;

	}
	
	public boolean deleteById(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.) Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeejdbc", "root", "root");

		// 3.) Create Statement

		PreparedStatement preparedStatement2 = connection.prepareStatement("Delete from employee where id = ?");

		System.out.println("Enter your id to be Deleted");
		

		preparedStatement2.setInt(1, id);

		preparedStatement2.execute();

		connection.close();
		
		System.out.println("Done");
		return true;
	}
	
	public ArrayList<User> findAll() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

//		 2.) Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeejdbc", "root", "root");

//		 3.) Create Statement
		Statement statement = connection.createStatement();

//		 4.) process the result
		ArrayList<User> u = new ArrayList();
		
		ResultSet resultSet = statement.executeQuery("Select * from employee");
		
		while (resultSet.next()) 
		{
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println("-------------------------------|");
		}
		
		// 5. close
		connection.close();

		System.out.println("Done");
		return  u ;

	}
}
