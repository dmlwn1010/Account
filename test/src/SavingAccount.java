
public class SavingAccount extends Account {
	//생성자
	public SavingAccount(double money, double interest){
		super(money);
		this.interest = interest;
	}
	private double interest; //이자율
	private int times = 0; //지나간 시간
	private double estimate = getBalance(); //estimateValue()에서 가치 담는 변수
	
	public void debit(double s) throws Exception{
		if(times < 12){
			throw new Exception("아직 출금 할 수 없습니다.");
			//System.out.println("아직 출금할 수 없습니다.");
		} else if(s < 0){
			throw new Exception("음수 입력!");
		}
		else{
			if(getBalance() > 0 && getBalance() - s > 0){
				setBalance(getBalance() - s);
			}
		}
	}
	public double getWithdrawableAccount(){
		if(times < 12){
			return 0;
		} else{
			return getBalance();
		}
	}
	public void passTime(int time){
		times = times + time;
		if(times == 12){
			setBalance(getBalance()*Math.pow((1 + interest), times));
		}
	}
	
	public double EstimateValue(int month){
		estimate = estimate*Math.pow((1 + interest), month);
		return estimate;
	}
	public String toString(){
		return String.format("SavingsAccount_Balance: %f", getBalance());
	}
}
