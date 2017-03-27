
public class Account {

	private double balance;
	
	public Account(double money){
		balance = money;
	}
	
	public double getBalance(){
		return balance;
	}
	public void debit(double s){
		if(balance > 0){
			balance = balance - s;
		}
		else{
			System.out.println("Debit amount exceeded account balance");
		}
	}
	public void credit(double s){
		balance = balance + s;
	}
	protected void setBalance(double s){
		balance = s;
	}
}