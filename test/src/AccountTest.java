import java.util.Scanner;

public class AccountTest {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Account account1 = new Account(0); //�ܰ� 0���� �ʱ�ȭ ���ѳ���
		Account account2 = new Account(0);
		
		while(true){
			System.out.println("�Ա��� ���Ͻø� 1��, ����� ���Ͻø� 2���� ��������.");
			int menu = input.nextInt();
			if(menu == 1){ //�Ա�
				System.out.println("1�� -> account1, 2 ��-> account2");
				menu = input.nextInt();
				if(menu == 1){
					System.out.print("�Ա��� �ݾ��� �Է��ϼ���: ");
					double s = input.nextDouble();
					account1.credit(s);
				} else if(menu == 2){
					System.out.print("�Ա��� �ݾ��� �Է��ϼ���: ");
					double s= input.nextDouble();
					account2.credit(s);
				}
				System.out.printf("%f\n", account1.getBalance()); //�ܰ� Ȯ��
				System.out.printf("%f\n", account2.getBalance());
			}
			else if(menu == 2){ //���
				System.out.println("1�� -> account1, 2�� -> account2")	;
				menu = input.nextInt();
				if(menu == 1){
					System.out.print("����� �ݾ��� �Է��ϼ���: ");
					double s = input.nextDouble();
					account1.debit(s);
				} else if(menu == 2){
					System.out.print("����� �ݾ��� �Է��ϼ���: ");
					double s = input.nextDouble();
					account2.debit(s);
				}
				System.out.printf("%f\n", account1.getBalance()); //�ܰ� Ȯ��
				System.out.printf("%f\n", account2.getBalance());
			}
		}
	}
}