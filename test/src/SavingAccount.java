
public class SavingAccount extends Account {
	//생성자
	public SavingAccount(double money, double interest){
		super(money);
		this.interest = interest;
	}
	private double interest; //이자율
	private int times = 0; //지나간 시간
	
	public void debit(double s){
		if(times < 12){
			System.out.println("아직 출금할 수 없습니다.");
		} else{
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
}
