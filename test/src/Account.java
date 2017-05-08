import java.util.ArrayList;
public abstract class Account implements Valuable{

	private double balance; //잔고
	
	public Account(double money){
		balance = money;
	}
	
	public double getBalance(){
		return balance;
	}
	public void debit(double s) throws Exception{ //출금 함수
		balance -= s;
		/*if(balance > 0){
			balance = balance - s;
		}
		else{
			System.out.println("Debit amount exceeded account balance");
		}*/
	}
	public void credit(double s){ //입금 함수
		balance = balance + s;
	}
	protected void setBalance(double s){ //잔고 수정
		balance = s;
	}
	public abstract double getWithdrawableAccount(); //현재 출금 가능한 금액을 return
	
	public abstract void passTime(int time); //기간을 인자로 받아 해당기간이 지난 후 이자를 계산해 준다
	public abstract void passTime();
	
	public static double sumForAccount(ArrayList<? extends Account> list){
		double sum = 0;
		for(Account account : list){
			sum += account.getBalance();
		}
		return sum;
	}
	public static void passTimeForList(ArrayList<? extends Account> list, int month){
		for(Account account : list){
			account.passTime(month);
		}
	}
	
}