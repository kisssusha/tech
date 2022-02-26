import models.Bank;
import models.CentralBank;
import models.Client;
import models.PercentOfDeposit;
import services.ClientBuilder;
import tools.BanksException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BanksException {
        CentralBank central = null;
        Scanner in = new Scanner(System.in);
        System.out.println("1 - Создание полного клиента ");
        System.out.println("2 - Создание клиента с ограничениями");
        System.out.println("Name, Surname, Address, Passport");
        String str = in.nextLine();
        ClientBuilder creation = null;
        Client client = null;
        Bank bank = null;
        switch (str)
        {
            case "1":
                client = creation.changeName(in.nextLine()).
                        changeSurname(in.nextLine()).changeAddress(in.nextLine()).
                        changePassport(in.nextLine()).create();
                break;
            case "2":
                client = creation.changeName(in.nextLine()).changeSurname(in.nextLine()).create();
                break;
        }

        while (str != "exit")
        {
            System.out.println("1 - Создание банка");
            System.out.println("2 - Добавление клиента в банк");
            System.out.println("3 - Создание счета в банке");
            System.out.println("4 - Снятие денег со счета");
            System.out.println("5 - Пополнение счета");
            System.out.println("6 - Перевод денег");
            System.out.println("7 - Отмена пополнения");
            System.out.println("8 - Отмена снятия");
            System.out.println("9 - Отмена перевода");
            System.out.println("10 - Промотка времени");
            System.out.println("exit - program finish");
            str = in.nextLine();
            switch (str)
            {
                case "1":
                    PercentOfDeposit percent = null;
                    for (int j = 0; j < 2; j++)
                    {
                        System.out.println("Введите сумму и процент");
                        percent.addPercentAndSum(in.nextInt(), in.nextDouble());
                    }
                    System.out.println("Введите параметры банка");

                    bank = new Bank(in.nextLine(), in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(), percent);
                    central.registerBank(bank);
                    break;
                case "2":
                    bank.addClientInBank(client);
                    break;
                case "3":
                    switch (in.nextLine())
                    {
                        case "1":
                            System.out.println("Введите сумму и срок");
                            central.creationAccount(bank, in.nextInt(), client, in.nextInt(), "Credit");
                            break;
                        case "2":
                            System.out.println("Введите сумму и срок");
                            central.creationAccount(bank, in.nextInt(), client, in.nextInt(), "Debit");
                            break;
                        case "3":
                            System.out.println("Введите сумму и срок");
                            central.creationAccount(bank, in.nextInt(), client, in.nextInt(), "Deposit");
                            break;
                        default:
                            throw new BanksException("Invalid option");
                    }

                    break;
                case "4":
                    System.out.println("Введите сумму и номер счета");
                    central.withdrawalMoney(bank, in.nextInt(), in.nextInt(), client);
                    break;
                case "5":
                    System.out.println("Введите сумму и номер счета");
                    central.refillMoneyOn(bank, in.nextInt(), in.nextInt());
                    break;
                case "6":
                    System.out.println("Введите сумму, номер счета отправителя и номер счета получателя");
                    central.transferMoneyOnBalance(bank, in.nextInt(), in.nextInt(), bank, in.nextInt(), client);
                    break;
                case "7":
                    System.out.println("Введите сумму и номер счета ");
                    central.cancelRefill(bank,  in.nextInt(),  in.nextInt());
                    break;
                case "8":
                    System.out.println("Введите сумму и номер счета ");
                    central.cancelWithdrawal(bank,  in.nextInt(),  in.nextInt());
                    break;
                case "9":
                    System.out.println("Введите сумму, номер счета отправителя и номер счета получателя");
                    central.cancelTransfer(bank,  in.nextInt(),  in.nextInt(), bank, in.nextInt());
                    break;
                case "10":
                    System.out.println("Введите сумму и номер счета ");
                    central.checkTime( in.nextInt(), bank.getAccountId( in.nextInt()));
                    break;

                case "exit":
                    System.out.println("finish");
                    break;
            }
        }
    }
}
