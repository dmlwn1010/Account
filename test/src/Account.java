
public abstract class Account implements Valuable{

	private double balance;
	
	public Account(double money){
		balance = money;
	}
	
	public double getBalance(){
		return balance;
	}
	public void debit(double s) throws Exception{
		balance -= s;
		/*if(balance > 0){
			balance = balance - s;
		}
		else{
			System.out.println("Debit amount exceeded account balance");
		}*/
	}
	public void credit(double s){
		balance = balance + s;
	}
	protected void setBalance(double s){
		balance = s;
	}
	public abstract double getWithdrawableAccount();
	
	public abstract void passTime(int time);
	public abstract void passTime();
}