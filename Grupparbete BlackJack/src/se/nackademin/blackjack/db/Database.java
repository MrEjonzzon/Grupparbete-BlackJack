package se.nackademin.blackjack.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {
	
	Scanner input = new Scanner(System.in);
	
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet result = null;
	private int balance;


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Database()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?" + "user=AdminBlackJack&password=BlackJack18");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void register() 
	{
		System.out.print("Enter username: ");
		String userName = input.next();
		System.out.print("Enter password: ");
		String password = input.next();
		boolean notValid = true;
		int defaultC = 500; // The value the user will get for creating an account to the database. 
		try 
		{
			statement = conn.createStatement();
			result = statement.executeQuery("select * from users");
			
			while(result.next()) 
			{
				if (result.getString("userName").equals(userName)) 
				{
					notValid = true;
					break;
				}
				else 
				{
					notValid = false;
				}
			}
			
			if (notValid == false) 
			{
				pStatement = conn.prepareStatement("insert into users value(default, ?, ?, ?)");
				pStatement.setString(1, userName);
				pStatement.setString(2, password);
				pStatement.setInt(3, defaultC);
				pStatement.executeUpdate();
				System.out.println("Account with username " + userName + " has succesfully been created. Current amount is " + defaultC);
			}
			else 
			{
				System.out.println("(Username already taken, try again!)");
				register();
			
			}
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void login() 
	{
		System.out.print("Enter username: ");
		String userName = input.next();
		System.out.print("Enter password: ");
		String password = input.next();
		
		boolean valid = true;
		int currency = 0;
		
		try {
			
			statement = conn.createStatement();
			result = statement.executeQuery("select * from users");
			
			while(result.next()) 
			{
				if(result.getString("userName").equals(userName)) 
				{
					if(result.getString("pwd").equals(password)) 
					{
						valid = true;
						currency = result.getInt("currency");
						break;
					}
					else 
					{
						valid = false;
					}
				}
				else 
				{
					valid = false;
				}
			}
			
			if(valid) 
			{
				System.out.println("Succefully logged in as " + userName + "\nYour currency is " + currency);
			}
			else 
			{
				System.out.println("Username or password is wrong! Try again");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
