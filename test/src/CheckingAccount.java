
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
	public void nextMonth(){ //한달 지났을 때 잔액변동
		if(getBalance() > 0){
			setBalance(getBalance()*(1 + interest));
		} else{
			setBalance(getBalance()*(1 + loanInterest));
		}
	}
	
	public double getWithdrawableAccount(){ //현재 출금 가능한 금액을 return
		if(getBalance() > -creditLimit){
			return creditLimit + getBalance();
		} else{
			return 0;
		}
	}
	public void passTime(int time){ //기간을 인자로 받아 해당기간이 지난 후 이자를 계산해 준다
		for(int i = 0; i < time; i++){
			nextMonth();
		}
	}
	public void passTime(){ //한달 후의 이자를 계산
		nextMonth();
	}
	
	public boolean isBankrupted(){ //현재 금액이 파산했는지 확인
		return (getBalance() < -creditLimit);
	}
	
	public double estimateValue(int month){ //사물의 가치를 return 
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
