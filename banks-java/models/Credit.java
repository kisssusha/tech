package models;

import services.IAccount;

public class Credit implements IAccount {
    private double commissionTmp = 0;
    public double commissionOfCredit;
    public double limitOfBank;
    public int idOfBank;
    public int balanceOfBank;

    public Credit(int id, double commission, double limit, int balance)
    {
        commissionOfCredit = commission;
        limitOfBank = limit;
        idOfBank = id;
        balanceOfBank = balance;
    }

    public void withdrawalOperation(int sum) {

        balanceOfBank -=sum;
    }

    public void cancelWithdrawalOperation(int sum) {

        balanceOfBank +=sum;
    }

    public void refillOperation(int sum) {

        balanceOfBank +=sum;
    }

    public void cancelRefillOperation(int sum) {

        balanceOfBank -=sum;
    }

    public void transferOperation(IAccount other, int sum) {
        balanceOfBank -=sum;
        other.refillOperation(sum);
    }

    public void cancelTransferOperation(IAccount other, int sum) {
        balanceOfBank +=sum;
        other.withdrawalOperation(sum);
    }

    public void benefitPay(int time) {
        commissionTmp += balanceOfBank * commissionOfCredit /300;
        balanceOfBank -=(int) commissionTmp *time;
        commissionTmp =0;
    }

    public boolean withdraw(int sum) {
        return Math.abs(balanceOfBank -sum)< limitOfBank;
    }

    public int getAccountId(){

        return idOfBank;
    }

    public int checkBalance() {

        return balanceOfBank;
    }
}
