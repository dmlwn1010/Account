
public class Account {

	private double balance;
	
	public double getBalance(){
		return balance;
	}
	
	public void debit(double s){
		if(balance > 0){
			balance = balance - s;
		}
		else{
			System.out.println("Debit amount exceeded account balance");
		}
	}
	
	public void credit(double s){
		balance = balance + s;
	}
	
	protected void setBalance(){
		
	}
}

/*public class AccountTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Account account = new Account();
		
		double a = input.nextInt();
		double b = input.nextInt();
		double account1 = 0;
		double account2 = 0;
		
		System.out.printf("acco	unt1 balance: $%f\n", a);
		account.credit(account1, a);
		
		System.out.printf("account2 balance: $%f\n", account.balance(account2));
		
		System.out.printf("Enter withdrawal amount for account1: %f\n", b);
		
		System.out.printf("subtracting %f from account1 balance\n", b);
		account.debit(account2, b);
		
		System.out.printf("account1 balance: $%f\n", account.balance(account1));
		System.out.printf("account2 balance: $%f\n", account.balance(account2));
		
		double a2 = input.nextInt();
		//double b2 = input.nextInt();
		
		System.out.printf("Enter withdrawal amount for account2: %f\n", a2);
		account.debit(account2, a2);
		
		System.out.printf("subtracting %f from account2 balance\n", a2);
		System.out.print("Debit amount exceeded account balance.\n");
		
		
		
		
	}
}*/