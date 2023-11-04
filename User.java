package bankingapp;

public class User {
	private String username;
	private String password;
	private double income;
	private ExpenseType[] nodes;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		income = 0;
	}
	
	public void newIncome(double amount) {
		income += amount;
	}
	
	public double calculateTotalExpenses() {
		double totalExpenses = 0;
		for(int i = 0; i < nodes.length; i++) {
			totalExpenses += nodes[i].getExpenses();
		}
		return totalExpenses;
	}
	
	public void newNode(String name, double goal) {
		ExpenseType e = new ExpenseType(name, goal);
		ExpenseType[] nodes2 = new ExpenseType[nodes.length + 1];
		for(int i = 0; i < nodes.length; i++) {
			nodes2[i] = nodes[i];
		}
		nodes2[nodes.length] = e;
		nodes = new ExpenseType[nodes2.length];
		for(int i = 0; i < nodes2.length; i++) {
			nodes[i] = nodes2[i];
		}
		
	}
	
	public double getIncome() {
		return income;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ExpenseType[] getNodes() {
		return nodes;
	}
}
