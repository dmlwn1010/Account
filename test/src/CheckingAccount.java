
public class CheckingAccount extends Account {
	
	public CheckingAccount(double bal, double limit, double intt, double loan_intt){
		super(bal);
		credit_limit = limit;
		interest = intt;
		loan_interest = loan_intt;
	}
	private double credit_limit; //대출 한도
	private double interest; //이자
	private double loan_interest; //대출이자
	 
	public void debit(double s){
		if(-credit_limit > getBalance() - s){
			System.out.println("Over!");
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
		}
		else{
			setBalance(getBalance()*(1 + loan_interest));
		}
	}
}
