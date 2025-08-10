package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
        bank.createCheckingAccount("��ö��", 20000, 5000);
        bank.createSavingsAccount("�̿���", 30000, 2.0);
        
        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        try {
            System.out.println("=== �Ա�/��� �׽�Ʈ ===");
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);
            
            System.out.println("\n=== ���� ���� �׽�Ʈ ===");
            SavingsAccount sa = (SavingsAccount) bank.findAccount("AC1000");
            sa.applyInterest();

            System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
            bank.transfer("AC1002", "AC1001", 5000);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // ���� ó�� �׽�Ʈ
        try {
            bank.withdraw("AC1001", 6000.0); // ��� �ѵ� �ʰ�
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        
        try {
            bank.withdraw("AC1000", 20000.0); // �ܾ� ����
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999"); // �������� �ʴ� ����
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}