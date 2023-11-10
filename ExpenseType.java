package bankingapp;

public class ExpenseType {
	private String name;
	private double goal;
	private double expenses;
	
	public ExpenseType(String name, double goal) {
		this.name = name;
		this.goal = goal;
		expenses = 0;
	}
	
	public void newExpense(double newExpense) {
		expenses += newExpense;
	}
	
	public String evaluateGoal() {
		String color;
		if(expenses < goal) {
			color = "Green";
		}else if(expenses == goal) {
			color = "Yellow";
		}else {
			color = "Red";
		}
		
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGoal() {
		return goal;
	}
	
	public double getExpenses() {
		return expenses;
	}
	
	public String toString() {
		String str = name + "\nGoal: " + goal + "\nExpenses: " + expenses;
		return str;
	}
}
