import java.util.ArrayList;
import java.util.InputMismatchException;

public class AccountTest {
	public static void main(String args[]) throws Exception{
		CheckingAccount account1 = new CheckingAccount(100, 50, 0.01, 0.07);
		SavingAccount account2 = new SavingAccount(100, 0.05);
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(account1);
		accountList.add(account2);
		
		System.out.println("전체 계좌의 잔액 합산: " + Account.sumForAccount(accountList));
		
		System.out.println("전체 계좌의 12개월 후 적용");
		Account.passTimeForList(accountList, 12);
		System.out.println("전체 계좌의 잔액 합산: " + Account.sumForAccount(accountList));
	}
		/*Scanner scan = new Scanner(System.in);
		
		Valuable[] objectList = new Valuable[4];
		
		objectList[0] = new CheckingAccount(100,50,0.01,0.07);
		objectList[1] = new SavingAccount(100,0.05);
		objectList[2] = new Human("Mark", 20);
		objectList[3] = new Car("MyCar", 5000);
		
		for(Valuable objectItem : objectList){
			System.out.printf("%s \n", objectItem.toString());
			System.out.printf("1 month later Value (Method Overloding, no parameter) : %.2f\n", objectItem.estimateValue());
			System.out.printf("5 month later Value : %.2f\n\n", objectItem.estimateValue(5));
		}
		
		Account account1 = new CheckingAccount(100,50,0.01,0.07);
		Account account2 = new SavingAccount(100,0.05);
		CheckingAccount c_account1 = (CheckingAccount)account1;
		
		int cmd;
		do{
			cmd = scan.nextInt();
			switch(cmd){
				//CheckingAccount 테스트 
				case 1 : 
					try{ 
						System.out.println("$100 입금");
						account1.credit(100);
						System.out.printf("Account1의 잔액 : $%.2f\n",account1.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account1.getWithdrawableAccount());
						System.out.println("------------------------------------------------------");
						
						System.out.println("$150 출금");
						account1.debit(150);
						System.out.printf("Account1의 잔액 : $%.2f\n",account1.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account1.getWithdrawableAccount());
						if(c_account1.isBankrupted()==true)
							System.out.println("파산");
						System.out.println("------------------------------------------------------");
						
						account1.passTime();
						System.out.printf("1개월 뒤 가치변화 후 Account1의 잔액 : $%.2f\n",account1.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account1.getWithdrawableAccount());
						if(c_account1.isBankrupted()==true)
							System.out.println("파산");
						System.out.println("------------------------------------------------------");
							
					
						System.out.println("$80 출금");
						account1.debit(80);
						System.out.printf("Account1의 잔액 : $%.2f\n",account1.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account1.getWithdrawableAccount());
						if(c_account1.isBankrupted()==true)
							System.out.println("파산");
						System.out.println("------------------------------------------------------");
						
						System.out.print("5개윌 뒤 가치 : ");
						account1.passTime(5);
						System.out.printf("5개월 뒤 가치 변화 후 Account1의 잔액 : $%.2f\n",account1.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account1.getWithdrawableAccount());
						if(c_account1.isBankrupted()==true)
							System.out.println("파산");
						System.out.println("------------------------------------------------------");
						
						System.out.println("amount에 음수입력");
						account1.debit(-1);
						System.out.println("------------------------------------------------------");
						
					}catch(InputMismatchException e){
						System.out.println("예외발생 " + e.toString() + ": 숫자를 입력하세요\n");
					}
					catch(Exception e){
						System.out.println("예외발생   "+e.toString());
					}
					
					break;
			
				
				//SavingsAccount 테스트 
				case 2 : 
					try{ 
						System.out.println("$150 출금");
						account2.debit(150);
						System.out.printf("Account2의 잔액 : $%.2f\n",account2.getBalance());
						System.out.printf("Account2의 출금가능액 : $%.2f\n",account2.getWithdrawableAccount());
						
					}catch(InputMismatchException e){
						System.out.println("예외발생 " + e.toString() + ": 숫자를 입력하세요\n");
					}
					catch(Exception e){
						System.out.println("예외발생   "+e.toString());
					}
					break;
					
				case 3 :
					try{ 
						account2.passTime();
						
						System.out.printf("1개월 뒤 가치변화 후 Account2의 잔액 : $%.2f\n",account2.getBalance());
						System.out.printf("Account2의 출금가능액 : $%.2f\n",account2.getWithdrawableAccount());
						System.out.printf("1개윌 째의 가치 : %.2f\n",account2.estimateValue());
						System.out.println("------------------------------------------------------");
		
						account2.passTime(5);
						System.out.printf("5개월 뒤 가치 변화 후 Account2의 잔액 : $%.2f\n",account2.getBalance());
						System.out.printf("Account1의 출금가능액 : $%.2f\n",account2.getWithdrawableAccount());
						System.out.printf("6개윌 째의 가치 : %.2f\n",account2.estimateValue(6));
						System.out.println("------------------------------------------------------");
						
						account2.passTime(5);
						System.out.printf("5개월 뒤 가치 변화 후 Account2의 잔액 : $%.2f\n",account2.getBalance());
						System.out.printf("Account2의 출금가능액 : $%.2f\n",account2.getWithdrawableAccount());
						System.out.printf("11개월 째의 가치 %.2f\n",account2.estimateValue(11));
						System.out.println("------------------------------------------------------");
						
						account2.passTime();
						System.out.printf("1개월 뒤 가치변화 후 Account2의 잔액 : $%.2f\n",account2.getBalance());
						System.out.printf("Account2의 출금가능액 : $%.2f\n",account2.getWithdrawableAccount());
	
						System.out.println("------------------------------------------------------");
						
						System.out.println("amount에 음수입력");
						account1.debit(-1);
						System.out.println("------------------------------------------------------");
						
					}catch(InputMismatchException e){
						System.out.println("예외발생 " + e.toString() + ": 숫자를 입력하세요\n");
					}
					catch(Exception e){
						System.out.println("예외발생   "+e.toString());
					}		
					break;
					
				case 0 : System.out.println("끝");
			}	
		}while(cmd!=0);		
	} 


	/*public static void main(String[] args){
		Account account1 = new CheckingAccount(100, 50, 0.01, 0.07);
		Account account2 = new SavingAccount(100, 0.05);

		Scanner scan = new Scanner(System.in);
		try{
			double amount = 0;		
			System.out.printf("Enter deposit amount for Account1: ");
			amount = scan.nextDouble();
			account1.debit(amount);
			System.out.println("Account1 balance: $" + account1.getBalance());
			
			System.out.printf("Enter deposit amount for Account2: ");
			amount = scan.nextDouble();
			account2.debit(amount);
			System.out.printf("Account2 balance: $" + account2.getBalance());
		} catch(InputMismatchException e){
			System.out.println("예외 발생: 숫자를 입력하세요\n" + e.toString());
		} catch(Exception e){
			System.out.println("예외발생  " + e.toString());
		} finally{
			account1.passTime(2);
			System.out.println("2 month later account1: " + account1.getBalance());
		}*/
		
}	
