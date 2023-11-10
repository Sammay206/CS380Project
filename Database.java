package bankingapp;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	public static Connection con;
	public static final String username = "username";
	public static final String password = "password";
	public static final String income = "income";
	
	public static final String name = "name";
	public static final String goal = "goal";
	public static final String expenses = "expenses";
	
	/**
	 * A method that connects to the database
	 */
	public static void connection() {
		String url = "jdbc:mysql://localhost:3306/bankingapp";
		String username = "root";
		String pass = "cs380";
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
		}catch(Exception e){
			System.out.println("Exception" + e.getMessage());
		}
	}
	/**
	 * a method that stores an expense type in the database
	 * @param e
	 * @param uname
	 */
	public static void storeExpenseType(ExpenseType e, String uname) {
		String query = "insert into expensetype (" + username + ", " + name + ", " + goal + ", " + expenses + 
					 ") values (\"" + uname + "\", \"" + e.getName() + "\", " + e.getGoal() + ", " + e.getExpenses() + ")";
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception x) {
			System.out.println("Exception" + x.getMessage());
		}
	}
	
	/**
	 * A method that stores a user profile in the database
	 * @param u
	 */
	public static void storeUser(User u) {
		String query = "insert into users (" + username + ", " + password + ", " + income +
				 	   ") values (\"" + u.getUsername() + "\", \"" + u.getPassword() + "\", " + u.getIncome() + ")";
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	/**
	 * A method that retreives a user profile from the database
	 * @param uname
	 * @param pword
	 * @return a user profile
	 */
	public static User getUser(String uname, String pword) {
		ArrayList<String> userData = new ArrayList<String>();
		User u;
		double ic = 0;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from users where username = \"" + uname + "\" and password = \"" + pword + "\"");
			
			System.out.println("select * from users where username = \"" + uname + "\" and password = \"" + pword + "\"");
			while(rs.next()) {
				userData.add(rs.getString(username));
				userData.add(rs.getString(password));
				ic = (rs.getDouble(income));
			}
		}catch(Exception e) {
			//System.out.println("Exception" + e.getMessage());
		}
		if(userData.size() >= 2 && userData.get(0) != null && userData.get(1) != null) {
			u = new User(userData.get(0), userData.get(1), ic);
			return u;
		}
		return null;
	}
	
	public static ArrayList<Object> getExpenseTypesForUser(User u){
		ArrayList<Object> output = new ArrayList<Object>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select name, goal, expenses from expensetype e join users u on e.username = u.username where e.username = \"" + u.getUsername() + "\"");
			
			while(rs.next()) {
				output.add(rs.getString(name));
				output.add(rs.getDouble(goal));
				output.add(rs.getDouble(expenses));
			}
		}catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return output;
	}

	public static void removeUser(User u) {
		String query1 = "delete from expensetype where " + username + " = \"" + u.getUsername() + "\"";
				System.out.println(query1);
		String query2 = "delete from users where " + username + " = \"" + u.getUsername() + "\"";
		System.out.println(query2);
		
		try {
			con.createStatement().executeUpdate(query1);
		}catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		try {
			con.createStatement().executeUpdate(query2);
		}catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}
}
