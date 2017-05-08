import java.util.ArrayList;
public abstract class Account implements Valuable{

	private double balance; //�ܰ�
	
	public Account(double money){
		balance = money;
	}
	
	public double getBalance(){
		return balance;
	}
	public void debit(double s) throws Exception{ //��� �Լ�
		balance -= s;
		/*if(balance > 0){
			balance = balance - s;
		}
		else{
			System.out.println("Debit amount exceeded account balance");
		}*/
	}
	public void credit(double s){ //�Ա� �Լ�
		balance = balance + s;
	}
	protected void setBalance(double s){ //�ܰ� ����
		balance = s;
	}
	public abstract double getWithdrawableAccount(); //���� ��� ������ �ݾ��� return
	
	public abstract void passTime(int time); //�Ⱓ�� ���ڷ� �޾� �ش�Ⱓ�� ���� �� ���ڸ� ����� �ش�
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