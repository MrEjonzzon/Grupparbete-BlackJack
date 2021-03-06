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
	
	boolean goToGame;
	private String userName;
	private int balance;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet result = null;
	
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
			conn = DriverManager.getConnection("jdbc:mysql://18.202.69.163:3306/amiralidb?" + "user=amirali&password=password");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void register() 
	{
		System.out.println("\n--------REGISTER--------\n");
		System.out.print("Enter username: ");
		String userName = input.next();
		setUserName(userName);
		System.out.print("Enter password: ");
		String password = input.next();
		boolean valid = true;
		int defaultC = 500; // The value the user will get for creating an account to the database. 
		try
		{
			statement = conn.createStatement();
			result = statement.executeQuery("select * from users");
			
			while(result.next()) 
			{
				if (result.getString("userName").equals(userName)) 
				{
					valid = false;
					result.close();
					break;
				}
				else 
				{
					valid = true;
				}
			}
			
			if (valid) 
			{
				pStatement = conn.prepareStatement("insert into users value(default, ?, ?, ?)");
				pStatement.setString(1, userName);
				pStatement.setString(2, password);
				pStatement.setInt(3, defaultC);
				pStatement.executeUpdate();
				pStatement.close();
				System.out.println("Account with username " + getUserName() + " has succesfully been created. Current balance is " + defaultC);
				
			}
			else 
			{
				System.out.println("(Username already taken, try again!)");

			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void login() 
	{
		System.out.println("\n--------LOGIN-----------\n");
		System.out.print("Enter username: ");
		String userName = input.next();
		System.out.print("Enter password: ");
		String password = input.next();
		
		boolean valid = true;
		
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
						setBalance(result.getInt("currency"));
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
				System.out.println("Succefully logged in as " + userName + "\nYour balance is " + getBalance());
				setUserName(userName);
				setGoToGame(true);
			}
			else 
			{
				System.out.println("Username or password is wrong! Try again");
				login();
			}
			result.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateBalanceDB(int balance) 
	{
		try {
			pStatement = conn.prepareStatement("update users set currency=? where userName=?");
			pStatement.setInt(1, balance);
			pStatement.setString(2, getUserName());
			pStatement.executeUpdate();
			setBalance(balance);
			pStatement.close();
		} catch (Exception e) {
			System.out.println("Error!" + e);
		}
	}

	public boolean isGoToGame() {
		return goToGame;
	}

	public void setGoToGame(boolean goToGame) {
		this.goToGame = goToGame;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
