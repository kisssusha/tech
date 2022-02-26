package services;

public interface IAccount
{
    public void withdrawalOperation(int sum);
    public void cancelWithdrawalOperation(int sum);
    public void refillOperation(int sum);
    public void cancelRefillOperation(int sum);
    public void transferOperation(IAccount other, int sum);
    public void cancelTransferOperation(IAccount other, int sum);
    public void benefitPay(int time);
    public boolean withdraw(int sum);
    public int getAccountId();
    public int checkBalance();
}
