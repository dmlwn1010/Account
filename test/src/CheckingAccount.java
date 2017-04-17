
public class CheckingAccount extends Account {
	
	public CheckingAccount(double bal, double limit, double intt, double loanIntt){
		super(bal);
		creditLimit = limit;
		interest = intt;
		loanInterest = loanIntt;
	}
	private double creditLimit; //대출 한도
	private double interest; //이자
	private double loanInterest; //대출이자
	
	@Override
	public void debit(double s) throws Exception{
		if(-creditLimit > getBalance() - s){ //한도 초과 금액 인출하려는 경우
			throw new Exception("Debit amount exceeded account balance.");
		} else if(s < 0){
			throw new Exception("음수 입력!");
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
