package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }
    
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("���� " + interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public String toString() {
        return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + 
               ", �ܾ�: " + balance + "��, ������: " + interestRate + "%";
    }
}