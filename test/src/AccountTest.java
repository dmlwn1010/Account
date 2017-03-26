import java.util.Scanner;

public class AccountTest {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Account account1 = new Account(0); //잔고를 0으로 초기화 시켜놓음
		Account account2 = new Account(0);
		
		while(true){
			System.out.println("입금을 원하시면 1번, 출금을 원하시면 2번을 누르세요.");
			int menu = input.nextInt();
			if(menu == 1){ //입금
				System.out.println("1번 -> account1, 2 번-> account2");
				menu = input.nextInt();
				if(menu == 1){
					System.out.print("입금할 금액을 입력하세요: ");
					double s = input.nextDouble();
					account1.credit(s);
				} else if(menu == 2){
					System.out.print("입급할 금액을 입력하세요: ");
					double s= input.nextDouble();
					account2.credit(s);
				}
				System.out.printf("%f\n", account1.getBalance()); //잔고 확인
				System.out.printf("%f\n", account2.getBalance());
			}
			else if(menu == 2){ //출력
				System.out.println("1번 -> account1, 2번 -> account2")	;
				menu = input.nextInt();
				if(menu == 1){
					System.out.print("출금할 금액을 입력하세요: ");
					double s = input.nextDouble();
					account1.debit(s);
				} else if(menu == 2){
					System.out.print("출금할 금액을 입력하세요: ");
					double s = input.nextDouble();
					account2.debit(s);
				}
				System.out.printf("%f\n", account1.getBalance()); //잔고 확인
				System.out.printf("%f\n", account2.getBalance());
			}
		}
	}
}