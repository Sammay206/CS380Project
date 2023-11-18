package project380;

public class User {
	private String username;
	private String password;
	private double income;
	private ExpenseType[] nodes;
	
	public User(String username, String password, double income) {
		this.username = username;
		this.password = password;
		this.income = income;
		this.nodes = new ExpenseType[0];
	}
	
	public User(User u) {
		if(u == null) {
			return;
		}
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.income = u.getIncome();
		this.nodes = new ExpenseType[0];
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
	
	public void newExpense(int index, double amount) {
		nodes[index].newExpense(amount);
	}
	
	public ExpenseType[] getNodes() {
		return nodes;
	}
}
