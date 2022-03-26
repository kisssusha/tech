package service;

import DAO.enums.MyColors;
import DAO.interfaces.Dao;
import DAO.models.CatsEntity;
import DAO.models.CatsForOwnerEntity;
import DAO.models.FriendsForCatEntity;
import DAO.models.OwnersEntity;
import DAO.tools.DaoException;
import service.tools.KotikiException;

import java.sql.Timestamp;

public class KotikiService {

    private final Dao<CatsEntity> catsDao;
    private final Dao<OwnersEntity> ownerDao;
    private final Dao<FriendsForCatEntity> friendshipDao;
    private final Dao<CatsForOwnerEntity> shelterDao;


    public KotikiService(Dao<CatsEntity> catsDao, Dao<OwnersEntity> ownerDao,
                         Dao<FriendsForCatEntity> friendshipDao,
                         Dao<CatsForOwnerEntity> shelterDao) {
        this.catsDao = catsDao;
        this.ownerDao = ownerDao;
        this.friendshipDao = friendshipDao;
        this.shelterDao = shelterDao;
    }


    public boolean deleteCat(long idCat) throws KotikiException {
        if (idCat == 0) throw new KotikiException("Invalid cat");
        try {
            for (FriendsForCatEntity fr : friendshipDao.findAllEntity()) {
                if (fr.getIdCat() == idCat ||
                        fr.getIdFriend() == idCat) friendshipDao.deleteEntity(fr);
            }
        } catch (DaoException e) {
         throw new KotikiException(e.getMessage());
        }

        try {
            return catsDao.deleteEntity(catsDao.getById(idCat));
        } catch (DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean deleteOwner(long idOwner) throws KotikiException {
        if (idOwner == 0) throw new KotikiException("Invalid owner");
        try {
            for (CatsForOwnerEntity fr : shelterDao.findAllEntity()) {
                if (fr.getIdOwner() == idOwner) shelterDao.deleteEntity(fr);
            }
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
        try {
            return ownerDao.deleteEntity(ownerDao.getById(idOwner));
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean changeCat(long idCat) throws KotikiException {
        if (idCat == 0) throw new KotikiException("Invalid cat");
        try {
            return catsDao.changeEntity(catsDao.getById(idCat));
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean changeOwner(long owner) throws KotikiException {
        if (owner == 0) throw new KotikiException("Invalid owner");
        try {
            return ownerDao.changeEntity(ownerDao.getById(owner));
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean addOwner(String name, Timestamp birthday) throws KotikiException {
        OwnersEntity owner = new OwnersEntity();
        owner.setName(name);
        owner.setDate(birthday);
        try {
            return ownerDao.addEntity(owner);
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean addCat(String name, Timestamp birthday, MyColors color) throws KotikiException {
        CatsEntity cat = new CatsEntity();
        cat.setColor(color);
        cat.setName(name);
        cat.setBirth(birthday);
        try {
            return catsDao.addEntity(cat);
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean friendship(long cat1, long cat2) throws KotikiException {
        if (cat1 == 0) throw new KotikiException("Invalid cat1");
        if (cat2 == 0) throw new KotikiException("Invalid cat2");
        FriendsForCatEntity friends = new FriendsForCatEntity();
        friends.setIdCat(cat1);
        friends.setIdFriend(cat2);

        try {
            return friendshipDao.addEntity(friends);
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean shelterCat(long owner, long cat) throws KotikiException {
        if (cat == 0) throw new KotikiException("Invalid cat");
        if (owner == 0) throw new KotikiException("Invalid owner");
        try {
            for (CatsForOwnerEntity pt : shelterDao.findAllEntity()) {
                if (pt.getIdCat() == cat) return false;
            }
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
        CatsForOwnerEntity pets = new CatsForOwnerEntity();
        pets.setIdCat(cat);
        pets.setIdOwner(owner);

        try {
            return shelterDao.addEntity(pets);
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
    }

    public boolean deleteFriendship(long id1, long id2) throws KotikiException {
        if (id1 == id2) throw new KotikiException("Invalid friends");
        try {
            for (FriendsForCatEntity fr : friendshipDao.findAllEntity()) {
                if (fr.getIdCat() == id1 && fr.getIdFriend() == id2 ||
                        fr.getIdFriend() == id1 && fr.getIdCat() == id2) return friendshipDao.deleteEntity(fr);
            }
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
        return false;
    }

    public boolean deleteShelter(long idCat, long idOwner) throws KotikiException {
        try {
            for (CatsForOwnerEntity fr : shelterDao.findAllEntity()) {
                if (fr.getIdCat() == idCat && fr.getIdOwner() == idOwner) shelterDao.deleteEntity(fr);

            }
        } catch (DAO.tools.DaoException e) {
            throw new KotikiException(e.getMessage());
        }
        return true;
    }
}

