package controller;

import DAO.enums.MyColors;
import DAO.implemetations.CatsDao;
import DAO.implemetations.FriendshipDao;
import DAO.implemetations.OwnersDao;
import DAO.implemetations.ShelterDao;
import DAO.interfaces.Dao;
import DAO.models.CatsEntity;
import DAO.models.CatsForOwnerEntity;
import DAO.models.FriendsForCatEntity;
import DAO.models.OwnersEntity;
import service.KotikiService;
import service.tools.KotikiException;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws KotikiException {
        Dao<CatsEntity> catsDao = new CatsDao();
        Dao<OwnersEntity> ownerDao = new OwnersDao();
        Dao<FriendsForCatEntity> friendshipDao = new FriendshipDao();
        Dao<CatsForOwnerEntity> shelterDao = new ShelterDao();
        KotikiService kotiki = new KotikiService(catsDao, ownerDao,
                friendshipDao, shelterDao);

        Scanner in = new Scanner(System.in);
        String str = null;

        while (!Objects.equals(str, "exit")) {
            System.out.print("Введите опцию :" + "\n");
            System.out.print("Добавить кота - 1" + "\n");
            System.out.print("Добавить хозяина - 2" + "\n");
            System.out.print("Присвоить кота хозяину - 3" + "\n");
            System.out.print("Подружить котов - 4" + "\n");
            System.out.print("Удалить кота - 5" + "\n");
            System.out.print("Удалить хозяина - 6" + "\n");
            System.out.print("Разорвать дружбу котов - 7" + "\n");
            System.out.print("Сделать кота без хозяина - 8" + "\n");
            System.out.print("Выход в главное меню - exit" + "\n");
            str = in.nextLine();
            switch (str) {
                case "1":
                    CatsEntity cat = new CatsEntity();
                    System.out.print("Введите имя кота" + "\n");
                    String name = in.nextLine();
                    System.out.print("Введите породу кота" + "\n");
                    String breed = in.nextLine();
                    System.out.print("Введите дату рождения кота" + "\n");
                    System.out.print("В виде гггг-мм-дд " + "\n");
                    Timestamp birthday = Timestamp.valueOf(in.nextLine()+" 00:00:00");
                    System.out.print("Введите цвет кота:" + "\n");
                    System.out.print("Black" + "\n");
                    System.out.print("White" + "\n");
                    System.out.print("Orange" + "\n");
                    System.out.print("Brown" + "\n");
                    MyColors color = null;
                    switch (in.nextLine()) {
                        case "Black":
                            color = MyColors.Black;
                            break;
                        case "White":
                            color = MyColors.White;
                            break;
                        case "Orange":
                            color = MyColors.Orange;
                        case "Brown":
                            color = MyColors.Brown;
                            break;
                    }
                    kotiki.addCat(name, birthday, color);
                    break;
                case "2":
                    OwnersEntity owner = new OwnersEntity();
                    System.out.print("Введите имя хозяина" + "\n");
                    String nameOwner = in.nextLine();
                    System.out.print("Введите дату рождения хозяина" + "\n");
                    System.out.print("В виде гггг-мм-дд чч:мм:сс " + "\n");
                    Timestamp birthdayOwner = Timestamp.valueOf(in.nextLine());
                    kotiki.addOwner(nameOwner, birthdayOwner);
                    break;
                case "3":
                    System.out.print("Введите id хозяина" + "\n");
                    long idOwner = in.nextLong();
                    System.out.print("Введите id кота" + "\n");
                    long idCat = in.nextLong();
                    kotiki.shelterCat(idOwner, idCat);
                    break;
                case "4":
                    System.out.print("Введите id кота" + "\n");
                    long id1 = in.nextLong();
                    System.out.print("Введите id друга" + "\n");
                    long id2 = in.nextLong();
                    kotiki.friendship(id1, id2);
                    break;
                case "5":
                    System.out.print("Введите id кота" + "\n");
                    long id3 = in.nextLong();
                    kotiki.deleteCat(id3);
                    break;
                case "6":
                    System.out.print("Введите id хозяина" + "\n");
                    long id4 = in.nextLong();
                    kotiki.deleteOwner(id4);
                    break;
                case "7":
                    System.out.print("Введите id кота" + "\n");
                    long id5 = in.nextLong();
                    System.out.print("Введите id друга" + "\n");
                    long id6 = in.nextLong();
                    kotiki.deleteFriendship(id5, id6);
                    break;
                case "8":
                    System.out.print("Введите id хозяина" + "\n");
                    long idOwner1 = in.nextLong();
                    System.out.print("Введите id кота" + "\n");
                    long idCat1 = in.nextLong();
                    kotiki.deleteShelter(idCat1, idOwner1);
                    break;
                case "exit":
                    System.out.println("finish");
                    break;
            }
        }
    }

}

