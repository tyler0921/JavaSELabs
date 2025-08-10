package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + this.balance + "��");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance < amount) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + this.balance + "��");
        }
        this.balance -= amount;
        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + this.balance + "��");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public abstract String toString();
}