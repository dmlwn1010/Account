
public class SavingAccount extends Account {
	//������
	public SavingAccount(double money, double interest){
		super(money);
		this.interest = interest;
	}
	private double interest; //������
	private int times = 0; //������ �ð�
	private double estimate = getBalance(); //estimateValue()���� ��ġ ��� ����
	
	public void debit(double s) throws Exception{
		if(times < 12){
			throw new Exception("���� ��� �� �� �����ϴ�.");
			//System.out.println("���� ����� �� �����ϴ�.");
		} else if(s < 0){
			throw new Exception("���� �Է�!");
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
