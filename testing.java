package bankingapp;

import java.util.ArrayList;
import java.util.Scanner;
public class testing {
	
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		String username;
		String password;
		User currentUser;
		Database.connection();
		
		//sign in the user
		System.out.println("Welcome.");
		System.out.print("Do you have an account? type 1 to sign up or anything else to sign in: ");
		int yn = keyboard.nextInt();
		System.out.println(yn);
		if(yn == 1) {
			System.out.println("Create new Account");
			System.out.print("Enter your username: ");
			username = keyboard.next();
			System.out.print("Enter your password: ");
			password = keyboard.next();
			User tempUser = new User(username, password, 0);
			Database.storeUser(tempUser);
		}else {
			//get username and password
			System.out.println("Sign in");
			System.out.print("Enter your username: ");
			username = keyboard.next();
			System.out.print("Enter your password: ");
			password = keyboard.next();
		}
		
		currentUser = new User(Database.getUser(username, password));
		
		//retrieve the expense types for this user from the database
		ArrayList<Double> expenses = new ArrayList<Double>();
		for(int i = 0; i < Database.getExpenseTypesForUser(currentUser).size(); i+=3) {
			String name = (String) Database.getExpenseTypesForUser(currentUser).get(i);
			double goal = (Double) Database.getExpenseTypesForUser(currentUser).get(i+1);
			expenses.add((Double) Database.getExpenseTypesForUser(currentUser).get(i+2));
			
			currentUser.newNode(name, goal);
		}
		
		for(int i = 0; i < currentUser.getNodes().length; i++) {
			currentUser.newExpense(i, expenses.get(i));
		}
		
		//remove the user from the database to be added back later updated
		Database.removeUser(currentUser);
		
		//ask the user what they would like to do
		System.out.print("Would you like to 1: Print all your expense types"
										   + "2: Add new Expense Type"
										   + "3: Add new Expense");
		int inputActivity = keyboard.nextInt();
		switch(inputActivity) {
		case 1:
			//print the expense types stored for the user with the given username
			for(int i = 0; i < currentUser.getNodes().length; i+=3) {
				System.out.print(currentUser.getNodes()[i] + " ");
				System.out.print(currentUser.getNodes()[i+1] + " ");
				System.out.print(currentUser.getNodes()[i+2] + " ");
				System.out.print("\n");
			}
			break;
		case 2:
			//add a new expense type
			System.out.print("Enter the name of this expense type");
			String name = keyboard.next();
			System.out.print("Enter the amount of money that you would like to stay below for this expense type");
			double goal = keyboard.nextDouble();
			currentUser.newNode(name, goal);
			break;
		case 3:
			//add a new expense to an expense type
			boolean found = false;
			System.out.print("Enter the name of the expense type you would like to add an expense to");
			String eName = keyboard.next();
			System.out.print("Enter the amount of the expense");
			double expense = keyboard.nextDouble();
			for (int i = 0; i < currentUser.getNodes().length; i++) {
				if(currentUser.getNodes()[i].getName().equals(eName)) {
					currentUser.newExpense(i, expense);
					found = true;
				}
			}
			if(!found) {
				System.out.println("Invalid input");
			}
			break;
		default:
			System.out.println("Invalid input");
		}
		
		//save the user data to the database
		Database.storeUser(currentUser);
		for (int i = 0; i < currentUser.getNodes().length; i++) {
			Database.storeExpenseType(currentUser.getNodes()[i], currentUser.getUsername());
		}
	}
}
