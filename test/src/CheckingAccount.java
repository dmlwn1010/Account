
public class CheckingAccount extends Account {
	
	public CheckingAccount(double bal, double limit, double intt, double loanIntt){
		super(bal);
		creditLimit = limit;
		interest = intt;
		loanInterest = loanIntt;
	}
	private double creditLimit; //���� �ѵ�
	private double interest; //����
	private double loanInterest; //��������
	
	@Override
	public void debit(double s) throws Exception{
		if(-creditLimit > getBalance() - s){ //�ѵ� �ʰ� �ݾ� �����Ϸ��� ���
			throw new Exception("Debit amount exceeded account balance.");
		} else if(s < 0){
			throw new Exception("���� �Է�!");
		}
		else{
			setBalance(getBalance() - s);
			if(getBalance() < 0){
				System.out.println("Balance is minus");
			}
		}
	}
	public void nextMonth(){
		if(getBalance() > 0){
			setBalance(getBalance()*(1 + interest));
		} else{
			setBalance(getBalance()*(1 + loanInterest));
		}
	}
	
	public double getWithdrawableAccount(){
		if(getBalance() > -creditLimit){
			return creditLimit + getBalance();
		} else{
			return 0;
		}
	}
	public void passTime(int time){
		for(int i = 0; i < time; i++){
			nextMonth();
		}
	}
	public void passTime(){
		nextMonth();
	}
	public boolean isBankrupted(){
		if(getBalance() < -creditLimit){
			return true;
		} else{
			return false;
		}
	}
	
	public double estimateValue(int month){
		for(int i = 0; i < month; i++){
			nextMonth();
		}
		return getBalance();
	}
	public double estimateValue(){
		nextMonth();
		return getBalance();
	}
	public String toString(){
		return String.format("CheckingAccount_Balance: %f", getBalance());
	}
}
